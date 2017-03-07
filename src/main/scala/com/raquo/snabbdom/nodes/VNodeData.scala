package com.raquo.snabbdom.nodes

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

@ScalaJSDefined
trait VNodeData extends js.Object {

  // @TODO[Elegance] Separate raw JS trait and implicit value class

  var attrs: js.UndefOr[js.Dictionary[Boolean | String]] = js.undefined

  var on: js.UndefOr[js.Dictionary[js.Function]] = js.undefined

  var props: js.UndefOr[js.Dictionary[Any]] = js.undefined

  @JSName("style")
  var styles: js.UndefOr[js.Dictionary[Any]] = js.undefined

  @JSName("hook")
  var hooks: js.UndefOr[Hooks] = js.undefined
}
