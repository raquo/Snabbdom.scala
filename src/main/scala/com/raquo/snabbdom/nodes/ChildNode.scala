package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders

// @TODO[Perf] Can we avoid allocating one ChildNode per VNode? Seems like a value class won't help here.
class ChildNode[N <: Node[N, D], D <: NodeData[N, D]](
  val vnode: N
) extends Modifier[N, D] {

  @inline override def applyTo(parent: N): Unit = {
    parent.addChild(vnode)
  }
}
