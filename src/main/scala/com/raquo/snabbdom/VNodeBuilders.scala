package com.raquo.snabbdom

import com.raquo.snabbdom.collections.Builders

import scala.scalajs.js

trait VNodeBuilders extends Builders[VNode] {
  override def vnode(tagName: js.UndefOr[String]): VNode = {
    new VNode(tagName)
  }
}
