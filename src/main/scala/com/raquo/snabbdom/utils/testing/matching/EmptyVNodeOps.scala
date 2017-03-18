package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.Node

class EmptyVNodeOps[N <: Node[N]](val emptyVNode: N) extends AnyVal {

  def like(rules: Rule[N]*): ExpectedElement[N] = {
    new ExpectedElement(emptyVNode).like(rules: _*)
  }

  def likeEmpty: ExpectedElement[N] = {
    new ExpectedElement(emptyVNode)
  }
}
