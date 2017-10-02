package com.raquo.snabbdom.setters

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.keys.KeyKey
import com.raquo.snabbdom.nodes.{Node, NodeData}

class KeySetter[N <: Node[N, D], D <: NodeData[N, D]](
  val key: KeyKey,
  val value: String
) extends Modifier[N, D] {

  override def apply(node: N): Unit = {
    node.key = value
  }
}
