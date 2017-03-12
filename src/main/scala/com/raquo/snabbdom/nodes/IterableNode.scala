package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

class IterableNode(val modifiers: Iterable[Modifier]) extends Modifier {

  @inline def applyTo(vnode: VNode): Unit = vnode.apply(modifiers.toSeq: _*)
}
