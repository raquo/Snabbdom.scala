package com.raquo.snabbdom.collections

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.{Attr, EventProp, Prop, Style}

import scala.scalajs.js

// @TODO[Api] Do we need type params for other stuff? So far we only wanted to customize the nodes...
trait Builders[N <: Node[N, D], D <: NodeData[N, D]] {

  @inline def attr[Value](key: String): Attr[Value, N, D] = {
    new Attr[Value, N, D](key)
  }

  @inline def eventProp[Value <: js.Function](key: String): EventProp[Value, N, D] = {
    new EventProp[Value, N, D](key)
  }

  @inline def prop[Value](key: String): Prop[Value, N, D] = {
    new Prop[Value, N, D](key)
  }

  // @TODO[Integrity] we still use `new Style` in some places to support additional traits e.g. `with MarginAuto`
  @inline def style[Value](jsKey: String, cssKey: String): Style[Value, N, D] = {
    new Style[Value, N, D](jsKey, cssKey)
  }

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.VNodeBuilders]] */
  @inline def node(tagName: js.UndefOr[String]): N

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.VNodeBuilders]] */
  @inline def textNode(text: String): N

  /** We don't actually have an N-agnostic implementation of this. See [[com.raquo.snabbdom.VNodeBuilders]] */
  @inline def nodeData(): D
}
