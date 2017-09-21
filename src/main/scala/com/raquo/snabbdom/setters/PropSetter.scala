package com.raquo.snabbdom.setters

import com.raquo.domtypes.generic.keys.Prop
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js

class PropSetter[V, N <: Node[N, D], D <: NodeData[N, D]](
  val key: Prop[V],
  val value: V
) extends Modifier[N, D] {

  def applyTo(node: N): Unit = {
    if (node.data.props.isEmpty) {
      node.data.props = js.Dictionary[Any](key.name -> value)
    } else {
      node.data.props.get.update(key.name, value)
    }
  }
}
