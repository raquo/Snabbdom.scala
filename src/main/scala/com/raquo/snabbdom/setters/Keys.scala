package com.raquo.snabbdom.setters

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js

/**
  * A [[Key]] Represents the left hand side of [[Setter]]s, e.g. an attribute (without a value)
  */
trait Key[V, N <: Node[N, D], D <: NodeData[N, D], S <: Setter[_, V, N, D, S]] {

  val name: String

  /** Create a [[Setter]] */
  def := (value: V): S
}

class Attr[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val name: String
) extends Key[V, N, D, AttrSetter[V, N, D]] {

  override def := (value: V): AttrSetter[V, N, D] =
    new AttrSetter[V, N, D](this, value)
}

class EventProp[V <: js.Function, N <: Node[N, D], D <: NodeData[N, D]] (
  val name: String
) extends Key[V, N, D, EventPropSetter[V, N, D]] {

  override def := (value: V): EventPropSetter[V, N, D] =
    new EventPropSetter[V, N, D](this, value)
}

class Prop[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val name: String
) extends Key[V, N, D, PropSetter[V, N, D]] {

  override def := (value: V): PropSetter[V, N, D] =
    new PropSetter[V, N, D](this, value)
}

class Style[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val name: String,
  val cssName: String
) extends Key[V, N, D, StyleSetter[V, N, D]] {

  override def := (value: V): StyleSetter[V, N, D] =
    new StyleSetter[V, N, D](this, value)
}
