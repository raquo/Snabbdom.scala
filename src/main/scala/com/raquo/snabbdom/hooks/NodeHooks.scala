package com.raquo.snabbdom.hooks

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/** Note: most scaladocs in this class are copied/derived from Snabbdom documentation.
  * Snabbdom is also licensed under MIT license.
  */
@ScalaJSDefined
class NodeHooks[N <: Node[N, D], D <: NodeData[N, D]] extends CommonHooks[N, D] { self =>

  type RawInitHook = js.Function1[NewNode, Any]

  type RawInsertHook = js.Function1[NewNode, Any]

  type RawPrePatchHook = js.Function2[OldNode, NewNode, Any]

  type RawPostPatchHook = js.Function2[OldNode, NewNode, Any]

  /** Init hook – a vnode has been added
    *
    * This hook is invoked during the patch process when a new virtual node
    * has been found. The hook is called before Snabbdom has processed the node
    * in any way. I.e., before it has created a DOM node based on the vnode.
    */
  var init: js.UndefOr[RawInitHook] = js.undefined

  /** Insert Hook – an element has been inserted into the DOM.
    *
    * This hook is invoked once the DOM element for a vnode has been inserted
    * into the document and the rest of the patch cycle is done. This means
    * that you can do DOM measurements (like using getBoundingClientRect in
    * this hook safely, knowing that no elements will be changed afterwards
    * that could affect the position of the inserted elements.
    */
  var insert: js.UndefOr[RawInsertHook] = js.undefined

  /** Pre-patch Hook – an element is about to be patched */
  @JSName("prepatch")
  var prePatch: js.UndefOr[RawPrePatchHook] = js.undefined

  /** Post-patch Hook – an element has been patched */
  @JSName("postpatch")
  var postPatch: js.UndefOr[RawPostPatchHook] = js.undefined

  @JSName("__scala_copy")
  def copy(): NodeHooks[N, D] = {
    new NodeHooks[N, D] {
      init = self.init
      create = self.create
      insert = self.insert
      prePatch = self.prePatch
      update = self.update
      postPatch = self.postPatch
      destroy = self.destroy
      remove = self.remove
    }
  }

  def addInitHook(hook: N => Any): this.type = {
    init = js.defined(
      if (init.isDefined) {
        val oldHook = init.get
        (node: N) => {
          oldHook(node)
          hook(node)
        }
      } else {
        hook
      }
    )
    this
  }

  def addInsertHook(hook: NewNode => Any): this.type = {
    insert = js.defined(
      if (insert.isDefined) {
        val oldHook = insert.get
        (node: N) => {
          oldHook(node)
          hook(node)
        }
      } else {
        hook
      }
    )
    this
  }

  def addPrePatchHook(hook: (OldNode, NewNode) => Any): this.type = {
    prePatch = js.defined(
      if (prePatch.isDefined) {
        val oldHook = prePatch.get
        (oldNode: N, node: N) => {
          oldHook(oldNode, node)
          hook(oldNode, node)
        }
      } else {
        hook
      }
    )
    this
  }

  def addPostPatchHook(hook: (OldNode, NewNode) => Any): this.type = {
    postPatch = js.defined(
      if (postPatch.isDefined) {
        val oldHook = postPatch.get
        (oldNode: N, node: N) => {
          oldHook(oldNode, node)
          hook(oldNode, node)
        }
      } else {
        hook
      }
    )
    this
  }
}

