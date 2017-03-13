package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders

// @TODO[Perf] Can we avoid allocating one ChildNode per VNode? Seems like a value class won't help here.
class ChildNode[N <: VNode](val vnode: N)(implicit builders: Builders[N]) extends Modifier[N] {

  @inline override def applyTo(parent: N): Unit = {
    new RichNode(parent).addChild(vnode)
  }
}
