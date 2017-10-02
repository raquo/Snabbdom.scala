package com.raquo.snabbdom

import com.raquo.domtestutils.EventSimulator
import com.raquo.domtestutils.matching.{ExpectedNode, Rule, RuleImplicits}
import com.raquo.domtestutils.scalatest.MountSpec
import com.raquo.snabbdom
import com.raquo.snabbdom.Snabbdom.PatchFn
import com.raquo.snabbdom.hooks.{ModuleHooks, NodeHooks}
import com.raquo.snabbdom.simple.{VNode, VNodeData}
import org.scalajs.dom
import org.scalatest.Suite

import scala.scalajs.js
import scala.scalajs.js.|

trait SnabbdomSpec
  extends MountSpec
  with RuleImplicits
  with EventSimulator
{ this: Suite =>

  val snabbdomModules: js.Array[NativeModule | ModuleHooks[VNode, VNodeData]] = snabbdom.builtInModules

  var jsPatch: PatchFn[VNode, VNodeData] = noopPatchFn _

  var mountedVNode: VNode = null

  def initSnabbdom(): PatchFn[VNode, VNodeData] = Snabbdom.init(snabbdomModules)

  override def clearDOM(): Unit = {
    super.clearDOM()
    jsPatch = noopPatchFn _

  }

  override def resetDOM(): Unit = {
    super.resetDOM()
    jsPatch = initSnabbdom()
  }

  def mount(vnode: VNode, clue: String): Unit = {
    assertEmptyContainer(clue)
    val entry = dom.document.createElement("div")
    entry.setAttribute("id", "snabbdom-entry")
    mountedElementClue = clue
    containerNode.appendChild(entry)

    patch(entry, vnode)
  }

  def mount(clue: String, vnode: VNode): Unit = {
    mount(vnode, clue)
  }

  def mount(vnode: VNode): Unit = {
    mount(vnode, defaultMountedElementClue)
  }

  def patch(nodeOrDOMElement: VNode | dom.Element, newNode: VNode): VNode = {

    // When a patch happens on a mounted node (e.g. because its AttrReceiver patches it)
    // we get a new VNode reference that we need to save if we want to properly unmount it later.
    // @TODO This looks a bit dangerous – is it safe around mount() / unmount() and async operations? Do we need any assert()-s?
    if (newNode.data.hooks.isEmpty) {
      newNode.data.hooks = new NodeHooks[VNode, VNodeData]()
    }
    newNode.data.hooks.get.addPostPatchHook((oldNode: VNode, newNode: VNode) => {
      //      dom.console.log("updating patched node")
      mountedVNode = newNode
    })

    mountedVNode = jsPatch(nodeOrDOMElement, newNode)
    mountedVNode
  }

  def patchMounted(newNode: VNode): VNode = {
    doAssert(
      mountedVNode != null,
      "ASSERT FAIL [patchMounted]: Nothing to patch. You need to mount() before trying to patchMounted()."
    )
    patch(mountedVNode, newNode)
  }

  /** Ensure that any previously used snabbdom node is destroyed before we attempt to mount a new node */
  override def unmount(): Unit = {
    doAssert(
      mountedVNode != null,
      "ASSERT FAIL [unmount]: Nothing to unmount. You need to mount() before trying to unmount()"
    )
    patchMounted(new VNode("div")) // @TODO rude
    super.unmount()
  }

  private def noopPatchFn(nodeOrDOMElement: VNode | dom.Element, newNode: VNode): Nothing = {
    doFail("Patch function is not defined in the test suite. Somehow, resetDocument() was not called. Normally this is done automatically in beforeEach()")
  }

  @inline def commentNode: ExpectedNode = {
    ExpectedNode.comment()
  }
}
