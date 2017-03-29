package com.raquo.snabbdom

import com.raquo.snabbdom.collections.Builders

import scala.scalajs.js

trait VNodeBuilders extends Builders[VNode, VNodeData] {

  @inline override def node(tagName: js.UndefOr[String]): VNode = {
    new VNode(tagName)
  }

  @inline override def textNode(text: String): VNode = {
    val newNode = node(js.undefined)
    newNode.text = text
    newNode
  }

  @inline override def nodeData(): VNodeData = {
    new VNodeData
  }
}
