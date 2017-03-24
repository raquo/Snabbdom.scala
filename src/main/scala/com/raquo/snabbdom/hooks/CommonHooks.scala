package com.raquo.snabbdom.hooks

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/** Note: most scaladocs in this class are copied/derived from Snabbdom documentation.
  * Snabbdom is also licensed under MIT license.
  */
@ScalaJSDefined
class CommonHooks[N <: Node[N, D], D <: NodeData[N, D]] extends js.Object {

  type RemoveNode = js.Function0[Any]

  type EmptyVNode = N

  type OldVNode = N

  type NewVNode = N

  type RawCreateHook = js.Function2[EmptyVNode, NewVNode, Any]

  type RawUpdateHook = js.Function2[OldVNode, NewVNode, Any]

  type RawDestroyHook = js.Function1[OldVNode, Any]

  /** Note: you must eventually call RemoveNode callback to remove the node from the DOM */
  type RawRemoveHook = js.Function2[OldVNode, RemoveNode, Any]

  /** Create Hook – a DOM element has been created based on a vnode */
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

  def addCreateHook(hook: (EmptyVNode, NewVNode) => Any): this.type = {
    create = js.defined(
      if (create.isDefined) {
        val oldHook = create.get
        (emptyVNode: N, vnode: N) => {
          oldHook(emptyVNode, vnode)
          hook(emptyVNode, vnode)
        }
      } else {
        hook
      }
    )
    this
  }

  def addUpdateHook(hook: (OldVNode, NewVNode) => Any): this.type = {
    update = js.defined(
      if (update.isDefined) {
        val oldHook = update.get
        (oldVNode: N, vnode: N) => {
          oldHook(oldVNode, vnode)
          hook(oldVNode, vnode)
        }
      } else {
        hook
      }
    )
    this
  }

  def addDestroyHook(hook: OldVNode => Any): this.type = {
    destroy = js.defined(
      if (destroy.isDefined) {
        val oldHook = destroy.get
        (vnode: N) => {
          oldHook(vnode)
          hook(vnode)
        }
      } else {
        hook
      }
    )
    this
  }

  /** Note: you MUST eventually call [[RemoveNode]] callback to remove the node from the DOM */
  def addRemoveHook(hook: (OldVNode, RemoveNode) => Any): this.type = {
    remove = js.defined(
      if (remove.isDefined) {
        val oldHook = remove.get
        (vnode: N, removeNode: RemoveNode) => {
          oldHook(vnode, removeNode)
          hook(vnode, removeNode)
        }
      } else {
        hook
      }
    )
    this
  }
}
