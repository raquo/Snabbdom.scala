package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

class IterableNode[N <: Node[N]](val modifiers: Iterable[Modifier[N]]) extends Modifier[N] {

  @inline def applyTo(vnode: N): Unit = {
    vnode.apply(modifiers.toSeq: _*)
  }
}
