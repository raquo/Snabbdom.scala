package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

// @TODO[Perf] Can we avoid allocating one ChildNode per Node? Seems like a value class won't help here.
class ChildNode[N <: Node[N, D], D <: NodeData[N, D]](
  val node: N
) extends Modifier[N, D] {

  @inline override def apply(parent: N): Unit = {
    parent.addChild(node)
  }
}
