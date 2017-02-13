package com.raquo.snabbdom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait Module extends js.Object {

  /** the patch process begins */
  def pre: js.UndefOr[js.Function2[VNode, VNode, Unit]] = js.native

  /** a DOM element has been created based on a vnode [emptyVnode, vnode] */
  def create: js.UndefOr[js.Function2[VNode, VNode, Unit]] = js.native

  /** an element is being updated [oldVnode, vnode] */
  def update: js.UndefOr[js.Function2[VNode, VNode, Unit]] = js.native

  /** an element is directly or indirectly being removed [vnode] */
  def destroy: js.UndefOr[js.Function1[VNode, Unit]] = js.native

  /** an element is directly being removed from the DOM [vnode, removeCallback] */
  def remove: js.UndefOr[js.Function2[VNode, js.Function0[Unit], Unit]] = js.native

  /** the patch process is done */
  def post: js.UndefOr[js.Function0[Unit]] = js.native
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
