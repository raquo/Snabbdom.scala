package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.Node

trait Rule[N <: Node[N]] {
  def applyTo(testNode: ExpectedElement[N]): Unit
}
