package com.raquo.snabbdom.setters

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.Node

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Represents a key-value modifier that can be applied to a [VNode] to set e.g. an attribute to a particular value
  *
  * This is in contrast to e.g. a VNode, which does not *set* anything, but *appends* to Children
  */
trait Setter[K <: Key[V, N, Self], V, N <: Node[N], Self <: Setter[K, V, N, Self]] extends Modifier[N] {
  val key: K
  val value: V
}

class AttrSetter[V, N <: Node[N]] (
  val key: Attr[V, N],
  val value: V
) extends Setter[Attr[V, N], V, N, AttrSetter[V, N]] {

  def applyTo(vnode: N): Unit = {
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

class EventPropSetter[V <: js.Function, N <: Node[N]] (
  val key: EventProp[V, N],
  val value: V
) extends Setter[EventProp[V, N], V, N, EventPropSetter[V, N]] {

  def applyTo(vnode: N): Unit = {
    if (vnode.data.on.isEmpty) {
      vnode.data.on = js.Dictionary[js.Function](key.name -> value)
    } else {
      vnode.data.on.get.update(key.name, value)
    }
  }
}

class PropSetter[V, N <: Node[N]] (
  val key: Prop[V, N],
  val value: V
) extends Setter[Prop[V, N], V, N, PropSetter[V, N]] {

  def applyTo(vnode: N): Unit = {
    if (vnode.data.props.isEmpty) {
      vnode.data.props = js.Dictionary[Any](key.name -> value)
    } else {
      vnode.data.props.get.update(key.name, value)
    }
  }
}

class StyleSetter[V, N <: Node[N]] (
  val key: Style[V, N],
  val value: V
) extends Setter[Style[V, N], V, N, StyleSetter[V, N]] {

  def applyTo(vnode: N): Unit = {
    if (vnode.data.styles.isEmpty) {
      vnode.data.styles = js.Dictionary[Any](key.name -> value)
    } else {
      vnode.data.styles.get.update(key.name, value)
    }
  }
}
