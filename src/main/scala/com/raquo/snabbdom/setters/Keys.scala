package com.raquo.snabbdom.setters

import scala.scalajs.js

/**
  * A [[Key]] Represents the left hand side of [[Setter]]s, e.g. an attribute (without a value)
  */
trait Key[V, S <: Setter[_, V, S]] {

  val name: String

  /** Create a [[Setter]] */
  def := (value: V): S
}

class Attr[V] (val name: String) extends Key[V, AttrSetter[V]] {

  override def := (value: V): AttrSetter[V] =
    new AttrSetter[V](this, value)
}

class EventProp[V <: js.Function] (val name: String) extends Key[V, EventPropSetter[V]] {

  override def := (value: V): EventPropSetter[V] =
    new EventPropSetter[V](this, value)
}

class Prop[V] (val name: String) extends Key[V, PropSetter[V]] {

  override def := (value: V): PropSetter[V] =
    new PropSetter[V](this, value)
}

class Style[V] (val name: String, val cssName: String) extends Key[V, StyleSetter[V]] {

  override def := (value: V): StyleSetter[V] =
    new StyleSetter[V](this, value)
}
