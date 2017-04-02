package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}

class EmptyVNodeOps[N <: Node[N, D], D <: NodeData[N, D]](
  val emptyVNode: N
) extends AnyVal {

  def like(rules: Rule[N, D]*): ExpectedNode[N, D] = {
    new ExpectedNode[N, D](emptyVNode).like(rules: _*)
  }

  def likeEmpty: ExpectedNode[N, D] = {
    // @TODO[API] Should this enforce zero children?
    new ExpectedNode[N, D](emptyVNode)
  }
}
