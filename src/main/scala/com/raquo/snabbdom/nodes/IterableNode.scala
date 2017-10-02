package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

class IterableNode[N <: Node[N, D], D <: NodeData[N, D]](
  val modifiers: Iterable[Modifier[N, D]]
) extends Modifier[N, D] {

  @inline override def apply(node: N): Unit = {
    node.apply(modifiers.toSeq: _*)
  }
}
