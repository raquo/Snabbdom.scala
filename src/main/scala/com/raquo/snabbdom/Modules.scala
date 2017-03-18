package com.raquo.snabbdom

import com.raquo.snabbdom.nodes.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// @TODO[API] Seems like Module itself should be of N

@js.native
trait Module extends js.Object {

  /** the patch process begins */
  def pre[N <: Node[N]](): js.UndefOr[js.Function2[N, N, Unit]] = js.native

  /** a DOM element has been created based on a vnode [emptyVnode, vnode] */
  def create[N <: Node[N]](): js.UndefOr[js.Function2[N, N, Unit]] = js.native

  /** an element is being updated [oldVnode, vnode] */
  def update[N <: Node[N]](): js.UndefOr[js.Function2[N, N, Unit]] = js.native

  /** an element is directly or indirectly being removed [vnode] */
  def destroy[N <: Node[N]](): js.UndefOr[js.Function1[N, Unit]] = js.native

  /** an element is directly being removed from the DOM [vnode, removeCallback] */
  def remove[N <: Node[N]](): js.UndefOr[js.Function2[N, js.Function0[Unit], Unit]] = js.native

  /** the patch process is done */
  def post[N <: Node[N]](): js.UndefOr[js.Function0[Unit]] = js.native
}

@JSImport("snabbdom/modules/attributes.js", JSImport.Default)
@js.native
object AttrsModule extends Module

@JSImport("snabbdom/modules/eventlisteners.js", JSImport.Default)
@js.native
object EventsModule extends Module

@JSImport("snabbdom/modules/props.js", JSImport.Default)
@js.native
object PropsModule extends Module

@JSImport("snabbdom/modules/style.js", JSImport.Default)
@js.native
object StyleModule extends Module
