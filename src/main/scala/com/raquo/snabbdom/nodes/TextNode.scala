package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier

import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class TextNode(val text: String) extends Modifier {

  @inline def applyTo(vnode: VNode): Unit = vnode.addTextChild(this)
}
