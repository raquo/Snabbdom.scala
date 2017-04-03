package com.raquo.snabbdom.setters

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Represents a key-value modifier that can be applied to a [[Node]]
  * to set e.g. an attribute to a particular value
  *
  * This is in contrast to e.g. a [[Node]], which does not *set* anything,
  * but *appends* to Children. A Setter is an idempotent [[Modifier]].
  */
trait Setter[K <: Key[V, N, D, Self], V, N <: Node[N, D], D <: NodeData[N, D], Self <: Setter[K, V, N, D, Self]]
  extends Modifier[N, D]
{
  val key: K
  val value: V
}

class AttrSetter[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val key: Attr[V, N, D],
  val value: V
) extends Setter[Attr[V, N, D], V, N, D, AttrSetter[V, N, D]] {

  def applyTo(node: N): Unit = {
    val attrKey = key.name
    val attrValue: Boolean | String = value match {
      case booleanValue: Boolean => booleanValue
      case otherValue => otherValue.toString
    }
    if (node.data.attrs.isEmpty) {
      node.data.attrs = js.Dictionary[Boolean | String](attrKey -> attrValue)
    } else {
      node.data.attrs.get.update(attrKey, attrValue)
    }
  }
}

class EventPropSetter[V <: js.Function, N <: Node[N, D], D <: NodeData[N, D]] (
  val key: EventProp[V, N, D],
  val value: V
) extends Setter[EventProp[V, N, D], V, N, D, EventPropSetter[V, N, D]] {

  def applyTo(node: N): Unit = {
    if (node.data.on.isEmpty) {
      node.data.on = js.Dictionary[js.Function](key.name -> value)
    } else {
      node.data.on.get.update(key.name, value)
    }
  }
}

class PropSetter[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val key: Prop[V, N, D],
  val value: V
) extends Setter[Prop[V, N, D], V, N, D, PropSetter[V, N, D]] {

  def applyTo(node: N): Unit = {
    if (node.data.props.isEmpty) {
      node.data.props = js.Dictionary[Any](key.name -> value)
    } else {
      node.data.props.get.update(key.name, value)
    }
  }
}

class StyleSetter[V, N <: Node[N, D], D <: NodeData[N, D]] (
  val key: Style[V, N, D],
  val value: V
) extends Setter[Style[V, N, D], V, N, D, StyleSetter[V, N, D]] {

  def applyTo(node: N): Unit = {
    if (node.data.styles.isEmpty) {
      node.data.styles = js.Dictionary[Any](key.name -> value)
    } else {
      node.data.styles.get.update(key.name, value)
    }
  }
}
