package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

import scala.scalajs.js.annotation.JSExport

// @TODO[Elegance] TextNode is basically a text-only VNode. Maybe they should share some type (but consider performance)
class TextNode(
  @JSExport("text")
  val text: String
) extends Modifier {

  @inline def applyTo(parentNode: VNode): Unit = {

    // @TODO avoid this string-concatenation magic, I think
    val hasChildren = parentNode.children.isDefined && parentNode.children.get.length > 0
    if (hasChildren) {
      VNode.addChildToList(parent = parentNode, child = this)
    } else if (parentNode.text.isEmpty) {
      parentNode.text = text
    } else {
      parentNode.text += text
    }
  }
}
