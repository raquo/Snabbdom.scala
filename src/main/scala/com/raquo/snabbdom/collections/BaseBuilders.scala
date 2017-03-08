package com.raquo.snabbdom.collections

import com.raquo.snabbdom.nodes.VNode

trait BaseBuilders extends Builders[VNode] {

  override def vnode(tagName: String): VNode = {
    new VNode(tagName)
  }
}
