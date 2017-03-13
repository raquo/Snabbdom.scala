package com.raquo.snabbdom.collections

import com.raquo.snabbdom.nodes.VNode

import scala.scalajs.js

trait VNodeBuilders extends Builders[VNode] {

  override def vnode(tagName: js.UndefOr[String]): VNode = {
    new VNode(tagName)
  }
}
