package com.raquo.snabbdom.setters

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js

class StringStyleSetter[V, N <: Node[N, D], D <: NodeData[N, D]](
  val key: Style[V],
  val value: String
) extends Modifier[N, D] {

  def applyTo(node: N): Unit = {
    if (node.data.styles.isEmpty) {
      node.data.styles = js.Dictionary[Any](key.name -> value)
    } else {
      node.data.styles.get.update(key.name, value)
    }
  }
}
