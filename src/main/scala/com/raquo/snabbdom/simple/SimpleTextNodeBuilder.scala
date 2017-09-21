package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.builders.Builder

import scala.scalajs.js

object SimpleTextNodeBuilder extends Builder[VNode] {
  override def build(): VNode = new VNode(js.undefined)
}
