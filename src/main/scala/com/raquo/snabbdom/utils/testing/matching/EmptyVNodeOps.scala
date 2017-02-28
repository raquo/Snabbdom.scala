package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.VNode

class EmptyVNodeOps(val emptyVNode: VNode) extends AnyVal {

  def like(rules: Rule*): ExpectedElement = {
    new ExpectedElement(emptyVNode).like(rules: _*)
  }

  def likeEmpty: ExpectedElement = {
    new ExpectedElement(emptyVNode)
  }
}
