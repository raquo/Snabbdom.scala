package com.raquo.snabbdom.setters

import com.raquo.snabbdom.{Modifier, VNode}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

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

  def applyTo(vnode: VNode): Unit = {
    val attrKey = key.name
    val attrValue: Boolean | String = value match {
      case booleanValue: Boolean => booleanValue
      case otherValue => otherValue.toString
    }
    if (vnode.data.attrs.isEmpty) {
      vnode.data.attrs = js.Dictionary[Boolean | String](attrKey -> attrValue)
    } else {
      vnode.data.attrs.get.update(attrKey, attrValue)
    }
  }
}

@ScalaJSDefined
class EventPropSetter[V <: js.Function] (
  val key: EventProp[V],
  val value: V
) extends Setter[EventProp[V], V, EventPropSetter[V]] {

  def applyTo(vnode: VNode): Unit = {
    if (vnode.data.on.isEmpty) {
      vnode.data.on = js.Dictionary[js.Function](key.name -> value)
    } else {
      vnode.data.on.get.update(key.name, value)
    }
  }
}

@ScalaJSDefined
class PropSetter[V] (
  val key: Prop[V],
  val value: V
) extends Setter[Prop[V], V, PropSetter[V]] {

  def applyTo(vnode: VNode): Unit = {
    if (vnode.data.props.isEmpty) {
      vnode.data.props = js.Dictionary[Any](key.name -> value)
    } else {
      vnode.data.props.get.update(key.name, value)
    }
  }
}

@ScalaJSDefined
class StyleSetter[V] (
  val key: Style[V],
  val value: V
) extends Setter[Style[V], V, StyleSetter[V]] {

  def applyTo(vnode: VNode): Unit = {
    if (vnode.data.styles.isEmpty) {
      vnode.data.styles = js.Dictionary[Any](key.name -> value)
    } else {
      vnode.data.styles.get.update(key.name, value)
    }
  }
}
