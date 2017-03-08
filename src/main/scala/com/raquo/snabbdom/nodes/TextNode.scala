package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class TextNode(val text: String) extends Modifier {

  @inline def applyTo(vnode: VNode): Unit = {
    // @TODO avoid this string-concatenation magic, I think
    val hasChildren = vnode.children.isDefined && vnode.children.get.length > 0
    if (hasChildren) {
      VNode.addChildToList(parent = vnode, child = this)
    } else if (vnode.text.isEmpty) {
      vnode.text = vnode.text
    } else {
      vnode.text += text
    }
  }
}
