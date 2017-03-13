package com.raquo.snabbdom.setters

import com.raquo.snabbdom.VNode

import scala.scalajs.js

/**
  * A [[Key]] Represents the left hand side of [[Setter]]s, e.g. an attribute (without a value)
  */
trait Key[V, N <: VNode, S <: Setter[_, V, N, S]] {

  val name: String

  /** Create a [[Setter]] */
  def := (value: V): S
}

class Attr[V, N <: VNode] (val name: String) extends Key[V, N, AttrSetter[V, N]] {

  override def := (value: V): AttrSetter[V, N] =
    new AttrSetter[V, N](this, value)
}

class EventProp[V <: js.Function, N <: VNode] (val name: String) extends Key[V, N, EventPropSetter[V, N]] {

  override def := (value: V): EventPropSetter[V, N] =
    new EventPropSetter[V, N](this, value)
}

class Prop[V, N <: VNode] (val name: String) extends Key[V, N, PropSetter[V, N]] {

  override def := (value: V): PropSetter[V, N] =
    new PropSetter[V, N](this, value)
}

class Style[V, N <: VNode] (val name: String, val cssName: String) extends Key[V, N, StyleSetter[V, N]] {

  override def := (value: V): StyleSetter[V, N] =
    new StyleSetter[V, N](this, value)
}
