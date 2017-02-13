package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.{Children, Modifier}
import org.scalajs.dom.raw.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class VNode(tagName: String) extends Modifier {

  var elm: js.UndefOr[Node] = js.undefined

  var sel: String = tagName

  var key: js.UndefOr[String] = js.undefined

  var data: VNodeData = new VNodeData {}

  var text: js.UndefOr[String] = js.undefined

  var children: js.UndefOr[Children] = js.undefined

  // @TODO[Elegance] remove applyTo method from here – use evidence objects or something
  @inline override def applyTo(vnode: VNode): Unit = vnode.addChild(this)
}
