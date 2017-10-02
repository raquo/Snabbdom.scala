package com.raquo.snabbdom.setters

import com.raquo.domtypes.generic.keys.Attr
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.|

class AttrSetter[V, N <: Node[N, D], D <: NodeData[N, D]](
  val key: Attr[V],
  val value: V
) extends Modifier[N, D] {

  override def apply(node: N): Unit = {
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
