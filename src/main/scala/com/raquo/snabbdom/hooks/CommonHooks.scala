package com.raquo.snabbdom.hooks

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

// @TODO[Convenience] Move doc comments into add* methods?

/** Note: most scaladocs in this class are copied/derived from Snabbdom documentation.
  * Snabbdom is also licensed under MIT license.
  */
@ScalaJSDefined
class CommonHooks[N <: Node[N, D], D <: NodeData[N, D]] extends js.Object {

  type RemoveNode = js.Function0[Any]

  type EmptyNode = N

  type OldNode = N

  type NewNode = N

  /** This js.Object is an empty virtual node created from within snabbdom. Don't use it. */
  type RawCreateHook = js.Function2[js.Object, NewNode, Any]

  type RawUpdateHook = js.Function2[OldNode, NewNode, Any]

  type RawDestroyHook = js.Function1[OldNode, Any]

  /** Note: you must eventually call RemoveNode callback to remove the node from the DOM */
  type RawRemoveHook = js.Function2[OldNode, RemoveNode, Any]

  /** Create Hook – a DOM element has been created based on a vnode
    * Note: this hook is not called on comment nodes.
    */
  var create: js.UndefOr[RawCreateHook] = js.undefined

  /** Update Hook – an element is being updated */
  var update: js.UndefOr[RawUpdateHook] = js.undefined

  /** Destroy Hook – an element is directly or indirectly being removed
    *
    * This hook is invoked on a virtual node when its DOM element is removed
    * from the DOM or if its parent is being removed from the DOM.
    *
    * To see the difference between this hook and the [[remove]] hook, consider
    * an example.
    *
    *     var vnode1 = h('div', [h('div', [h('span', 'Hello')])]);
    *     var vnode2 = h('div', []);
    *     patch(container, vnode1);
    *     patch(vnode1, vnode2);
    *
    * Here [[destroy]] is triggered for both the inner `div` element and the
    * `span` element it contains. [remove], on the other hand, is only
    * triggered on the `div` element because it is the only element being
    * detached from its parent.
    */
  var destroy: js.UndefOr[RawDestroyHook] = js.undefined

  /** Remove Hook – an element is directly being removed from the DOM
    *
    * Allows you to hook into the removal of an element. The hook is called
    * once a vnode is to be removed from the DOM. The handling function
    * receives both the vnode and a callback. You can control and delay the
    * removal with the callback. The callback should be invoked once the hook
    * is done doing its business, and the element will only be removed once
    * all remove hooks have invoked their callback.
    *
    * The hook is only triggered when an element is to be removed from its
    * parent – not if it is the child of an element that is removed. For that,
    * see the destroy hook.
    */
  var remove: js.UndefOr[RawRemoveHook] = js.undefined

  def addCreateHook(hook: (js.Object, NewNode) => Any): this.type = {
    create = js.defined(
      if (create.isDefined) {
        val oldHook = create.get
        (emptyNode: js.Object, node: N) => {
          oldHook(emptyNode, node)
          hook(emptyNode, node)
        }
      } else {
        hook
      }
    )
    this
  }

  def addUpdateHook(hook: (OldNode, NewNode) => Any): this.type = {
    update = js.defined(
      if (update.isDefined) {
        val oldHook = update.get
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

  def addDestroyHook(hook: OldNode => Any): this.type = {
    destroy = js.defined(
      if (destroy.isDefined) {
        val oldHook = destroy.get
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

  /** Note: you MUST eventually call [[RemoveNode]] callback to remove the node from the DOM */
  def addRemoveHook(hook: (OldNode, RemoveNode) => Any): this.type = {
    remove = js.defined(
      if (remove.isDefined) {
        val oldHook = remove.get
        (node: N, removeNode: RemoveNode) => {
          oldHook(node, removeNode)
          hook(node, removeNode)
        }
      } else {
        hook
      }
    )
    this
  }
}
