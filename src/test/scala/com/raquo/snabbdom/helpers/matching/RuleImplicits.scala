package com.raquo.snabbdom.helpers.matching

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.{Attr, Prop, Style}

trait RuleImplicits {

  implicit def withEmptyVNodeOps(emptyVNode: VNode): EmptyVNodeOps = {
    new EmptyVNodeOps(emptyVNode)
  }

  implicit def withAttrRuleOps[V](attr: Attr[V]): AttrRuleOps[V] = {
    new AttrRuleOps(attr)
  }

  implicit def withPropRuleOps[V](prop: Prop[V]): PropRuleOps[V] = {
    new PropRuleOps(prop)
  }

  implicit def withStyleRuleOps[V](style: Style[V]): StyleRuleOps[V] = {
    new StyleRuleOps(style)
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
