package com.raquo.snabbdom.builders

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js

trait Builders[N <: Node[N, D], D <: NodeData[N, D]] {

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.simple.VNodeBuilders]] */
  @inline def node(tagName: js.UndefOr[String]): N

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.simple.VNodeBuilders]] */
  @inline def textNode(text: String): N

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.simple.VNodeBuilders]] */
  @inline def nodeData(): D
}
