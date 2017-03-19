package com.raquo.snabbdom

import com.raquo.snabbdom.collections.Builders

import scala.scalajs.js

trait VNodeBuilders extends Builders[VNode, VNodeData] {

  @inline override def vnode(tagName: js.UndefOr[String]): VNode = {
    new VNode(tagName)
  }

  @inline override def textNode(text: String): VNode = {
    val node = vnode(js.undefined)
    node.text = text
    node
  }

  @inline override def vnodeData(): VNodeData = {
    new VNodeData
  }
}
