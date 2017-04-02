package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}

trait Rule[N <: Node[N, D], D <: NodeData[N, D]] {
  def applyTo(testNode: ExpectedNode[N, D]): Unit
}
