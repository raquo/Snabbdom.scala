package com.raquo.snabbdom

import com.raquo.snabbdom.hooks.ModuleHooks
import com.raquo.snabbdom.nodes.{Node, NodeData}
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("snabbdom", JSImport.Namespace)
object Snabbdom extends js.Object {

  type PatchFn[N <: Node[N, D], D <: NodeData[N, D]] = js.Function2[N | dom.Element, N, N]

  def init[N <: Node[N, D], D <: NodeData[N, D]](modules: js.Array[NativeModule | ModuleHooks[N, D]]): PatchFn[N, D] = js.native
}
