package com.raquo.snabbdom

import com.raquo.snabbdom.nodes.Node
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("snabbdom", JSImport.Namespace)
object Snabbdom extends js.Object {

  type PatchFn[N <: Node[N]] = js.Function2[N | dom.Element, N, N]

  def init[N <: Node[N]](modules: js.Array[Module]): PatchFn[N] = js.native
}
