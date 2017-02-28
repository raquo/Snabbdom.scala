package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.Snabbdom.PatchFn
import com.raquo.snabbdom.utils.testing.matching.ExpectedElement
import com.raquo.snabbdom.tags.div
import com.raquo.snabbdom.{AttrsModule, EventsModule, Module, PropsModule, Snabbdom, StyleModule, VNode}
import org.scalajs.dom
import org.scalatest.{BeforeAndAfterEach, Suite}

import scala.scalajs.js
import scala.scalajs.js.|

trait MountSpec extends BeforeAndAfterEach { this: Suite =>

  import MountSpec._

  var container: dom.Element = null

  var patch: PatchFn = noopPatchFn _

  var snabbdomModules: js.Array[Module] = js.Array(AttrsModule, PropsModule, EventsModule, StyleModule)

  var mountedElementClue: String = defaultMountedElementClue

  override def beforeEach(): Unit = {
    super.beforeEach()
    resetDocument()
  }

  override def afterEach(): Unit = {
    super.afterEach()
    clearDocument()
  }

  def expectElement(expectedElement: ExpectedElement): Unit = {
    val errors = ExpectedElement.checkElement(
      mountedElement(),
      expectedElement,
      clue = mountedElementClue
    )
    if (errors.nonEmpty) {
      fail(s"Rendered element does not match expectations:\n${errors.mkString("\n")}")
    }
  }

  def initSnabbdom(): PatchFn = Snabbdom.init(snabbdomModules)

  def clearDocument(): Unit = {
    removeChildren(dom.document.body)
    patch = noopPatchFn _
  }

  def resetDocument(): Unit = {
    clearDocument()
    container = createContainer()
    dom.document.body.appendChild(container)
    patch = initSnabbdom()
  }

  def mountedElement(): dom.Element = {
    val numMountedElements = container.childNodes.length
    if (numMountedElements == 0) {
      fail(s"ASSERT FAIL [mountedElement]: container has no children. Did you forget to call mount()? Or maybe you've unmounted or cleared the document since then?")
    } else if (numMountedElements > 1) {
      fail(s"ASSERT FAIL [mountedElement]: container must have exactly 1 child, $numMountedElements found. Did you forget to unmount() or clear the document?")
    }

    container.firstChild match {
      case element: dom.Element => element
      case node =>
        fail(s"ASSERT FAIL [mountedElement]: mounted node $node is not an Element")
    }
  }

  def mount(clue: String, vnode: VNode): Unit = {
    mount(vnode, clue)
  }

  def mount(vnode: VNode, clue: String = defaultMountedElementClue): Unit = {
    assert(
      container != null && container.parentNode == dom.document.body,
      "ASSERT FAIL [mount]: Container is null or not mounted to <body> (what did you do!?)"
    )
    // @TODO Looks like this assert is somehow triggering this Scala.js bug? @see https://github.com/scala-js/scala-js/issues/2712
    // @TODO Or maybe something else is going on? Revisit when Scala.js 0.6.15 is released
//    assert(
//      container.firstChild == null,
//      "ASSERT FAIL [mount]: Unexpected children in container. Call unmount() before mounting again."
//    )

    val entry = dom.document.createElement("div")
    entry.setAttribute("id", "snabbdom-entry")

    mountedElementClue = clue
    container.appendChild(entry)
    patch(entry, vnode)
  }

  /** Ensure that any previously used snabbdom node is destroyed before we attempt to mount a new node */
  def unmount(): Unit = {
    mount(div())
    removeChildren(container)
  }

  private def createContainer(): dom.Element = {
    val container = dom.document.createElement("div")
    container.setAttribute("id", "snabbdom-container")
    container
  }

  private def removeChildren(node: dom.Element): Unit = {
    while (node.firstChild != null) {
      node.removeChild(node.firstChild)
    }
  }

  private def noopPatchFn(elementOrVNode: VNode | dom.Element, newVNode: VNode): VNode = {
    fail("Patch function is not defined in the test suite. Somehow, resetDocument() was not called. Normally this is done automatically in beforeEach()")
  }
}

object MountSpec {
  val defaultMountedElementClue = "root"
}
