package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

class IterableNode[N <: Node[N, D], D <: NodeData[N, D]](
  val modifiers: Iterable[Modifier[N, D]]
) extends Modifier[N, D] {

  @inline def applyTo(node: N): Unit = {
    node.apply(modifiers.toSeq: _*)
  }
}
