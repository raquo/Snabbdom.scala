package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

import scala.scalajs.js

// @TODO[Perf] Can we avoid allocating one ChildNode per VNode? Seems like a value class won't help here.
class ChildNode(val vnode: VNode) extends Modifier {

  import VNode.addChildToList

  override def applyTo(parentNode: VNode): Unit = {
    if (parentNode.text.isDefined) {
      addChildToList(parent = parentNode, child = new TextNode(parentNode.text.get))
      parentNode.text = js.undefined
    }
    addChildToList(parent = parentNode, child = vnode)
  }
}
