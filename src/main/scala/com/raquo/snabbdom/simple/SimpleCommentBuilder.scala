package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.builders.Builder

object SimpleCommentBuilder extends Builder[VNode] {

  override def build(): VNode = new VNode("!")
}
