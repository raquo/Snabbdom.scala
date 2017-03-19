package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}

class EmptyVNodeOps[N <: Node[N, D], D <: NodeData[N, D]](
  val emptyVNode: N
) extends AnyVal {

  def like(rules: Rule[N, D]*): ExpectedElement[N, D] = {
    new ExpectedElement[N, D](emptyVNode).like(rules: _*)
  }

  def likeEmpty: ExpectedElement[N, D] = {
    new ExpectedElement[N, D](emptyVNode)
  }
}
