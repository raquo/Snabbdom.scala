package com.raquo.snabbdom.setters

import com.raquo.snabbdom.{Modifier, VNode}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Represents a key-value modifier that can be applied to a [VNode] to set e.g. an attribute to a particular value
  *
  * This is in contrast to e.g. a VNode, which does not *set* anything, but *appends* to Children
  */
@ScalaJSDefined
trait Setter[K <: Key[V, Self], V, Self <: Setter[K, V, Self]] extends Modifier {
  val key: K
  val value: V
}

@ScalaJSDefined
class AttrSetter[V] (
  val key: Attr[V],
  val value: V
) extends Setter[Attr[V], V, AttrSetter[V]] {

  @inline def applyTo(vnode: VNode): Unit = vnode.setAttr[V](this)
}

@ScalaJSDefined
class EventPropSetter[V <: js.Function] (
  val key: EventProp[V],
  val value: V
) extends Setter[EventProp[V], V, EventPropSetter[V]] {

  @inline def applyTo(vnode: VNode): Unit = vnode.setEventProp[V](this)
}

@ScalaJSDefined
class PropSetter[V] (
  val key: Prop[V],
  val value: V
) extends Setter[Prop[V], V, PropSetter[V]] {

  @inline def applyTo(vnode: VNode): Unit = vnode.setProp[V](this)
}

@ScalaJSDefined
class StyleSetter[V] (
  val key: Style[V],
  val value: V
) extends Setter[Style[V], V, StyleSetter[V]] {

  @inline def applyTo(vnode: VNode): Unit = vnode.setStyle[V](this)
}
