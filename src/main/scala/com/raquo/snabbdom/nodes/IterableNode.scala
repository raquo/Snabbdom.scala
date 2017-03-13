package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

class IterableNode[N <: VNode](val modifiers: Iterable[Modifier[N]]) extends Modifier[N] {

  @inline def applyTo(vnode: N): Unit = {
    new RichNode(vnode).apply(modifiers.toSeq: _*)
  }
}
