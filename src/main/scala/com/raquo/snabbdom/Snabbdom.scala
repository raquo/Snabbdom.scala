package com.raquo.snabbdom

import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("snabbdom", JSImport.Namespace)
object Snabbdom extends js.Object {

  type PatchFn = js.Function2[VNode | dom.Element, VNode, VNode]

  def init(modules: js.Array[Module]): PatchFn = js.native
}
