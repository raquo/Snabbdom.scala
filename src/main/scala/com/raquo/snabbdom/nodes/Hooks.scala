package com.raquo.snabbdom.nodes

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

// @TODO[API] >>> Should hooks be covariant?

/** Note: most scaladocs in this class are copied from Snabbdom documentation.
  * Snabbdom is also licensed under MIT license.
  */
@ScalaJSDefined
class Hooks[N <: Node[N]] extends js.Object {

  type RemoveNode = js.Function0[Any]

  // @TODO make var fields private? Expose a better API?

  type EmptyVNode = N
  type OldVNode = N
  type NewVNode = N

//  type RawPreHook = js.Function0[Any]
  type RawInitHook = js.Function1[NewVNode, Any]
  type RawCreateHook = js.Function2[EmptyVNode, NewVNode, Any]
  type RawInsertHook = js.Function1[NewVNode, Any]
  type RawPrePatchHook = js.Function2[OldVNode, NewVNode, Any]
  type RawUpdateHook = js.Function2[OldVNode, NewVNode, Any]
  type RawPostPatchHook = js.Function2[OldVNode, NewVNode, Any]
  type RawDestroyHook = js.Function1[OldVNode, Any]

  /** Note: you must eventually call RemoveNode callback to remove the node from the DOM */
  type RawRemoveHook = js.Function2[OldVNode, RemoveNode, Any]

//  /** the patch process begins */
//  var pre: js.UndefOr[RawPreHook] = js.undefined

  // !!! Don't forget to update the COPY method if adding fields!

  /** Init hook – a vnode has been added
    *
    * This hook is invoked during the patch process when a new virtual node
    * has been found. The hook is called before Snabbdom has processed the node
    * in any way. I.e., before it has created a DOM node based on the vnode.
    */
  var init: js.UndefOr[RawInitHook] = js.undefined

  /** Create Hook – a DOM element has been created based on a vnode */
  var create: js.UndefOr[RawCreateHook] = js.undefined

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

  /** Update Hook – an element is being updated */
  var update: js.UndefOr[RawUpdateHook] = js.undefined

  /** Post-patch Hook – an element has been patched */
  @JSName("postpatch")
  var postPatch: js.UndefOr[RawPostPatchHook] = js.undefined

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

  // !!! Don't forget to update the COPY method if adding fields!

//  /** the patch process is done */
//  var post: js.UndefOr[RawPostHook] = js.undefined

  /**
    * param newHook - hook to use if there is currently no hook set
    * param makeNewHook - function that creates a new hook given a current hook
    */
//  def combineHooks[H](currentHook: js.UndefOr[H], newHook: H, makeNewHook: H => H): js.UndefOr[H] = {
//    js.defined(if (currentHook.isDefined) {
//      makeNewHook(currentHook)
//    } else {
//      newHook
//    })
//  }

  // @TODO[Performance] is such currying efficient? Check out the generated code, try to @inline some of this?
//  def combineSingleNodeHook(newHook: VNode => Any)(currentHook: VNode => Any)(vnode: VNode): Any = {
//    currentHook(vnode)
//    newHook(vnode)
//  }

  def addInitHook(hook: N => Any): this.type = {
    init = js.defined(
      if (init.isDefined) {
        val oldHook = init.get
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

  def addInsertHook(hook: NewVNode => Any): this.type = {
    insert = js.defined(
      if (insert.isDefined) {
        val oldHook = insert.get
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

  def addPrePatchHook(hook: (OldVNode, NewVNode) => Any): this.type = {
    prePatch = js.defined(
      if (prePatch.isDefined) {
        val oldHook = prePatch.get
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

  def addPostPatchHook(hook: (OldVNode, NewVNode) => Any): this.type = {
    postPatch = js.defined(
      if (postPatch.isDefined) {
        val oldHook = postPatch.get
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

