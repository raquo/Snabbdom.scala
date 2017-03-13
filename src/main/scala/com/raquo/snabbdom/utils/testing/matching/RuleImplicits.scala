package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.{Attr, Prop, Style}

trait RuleImplicits {

  implicit def withEmptyVNodeOps(emptyVNode: VNode): EmptyVNodeOps = {
    new EmptyVNodeOps(emptyVNode)
  }

  implicit def withAttrRuleOps[V, N <: VNode](attr: Attr[V, N]): AttrRuleOps[V, N] = {
    new AttrRuleOps(attr)
  }

  implicit def withPropRuleOps[V, N <: VNode](prop: Prop[V, N]): PropRuleOps[V, N] = {
    new PropRuleOps(prop)
  }

  implicit def withStyleRuleOps[V, N <: VNode](style: Style[V, N]): StyleRuleOps[V, N] = {
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
