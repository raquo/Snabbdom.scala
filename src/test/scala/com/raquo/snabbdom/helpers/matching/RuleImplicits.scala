package com.raquo.snabbdom.helpers.matching

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.Attr

trait RuleImplicits {

  implicit def withEmptyVNodeOps(emptyVNode: VNode): EmptyVNodeOps = {
    new EmptyVNodeOps(emptyVNode)
  }

  implicit def withAttrRuleOps[V](attr: Attr[V]): AttrRuleOps[V] = {
    new AttrRuleOps(attr)
  }

  implicit def childElementToRule(child: ExpectedElement): Rule = new Rule {
    def applyTo(expectedElement: ExpectedElement): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }

  implicit def childStringToRule(child: String): Rule = new Rule {
    def applyTo(expectedElement: ExpectedElement): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }
}
