package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.Node
import com.raquo.snabbdom.setters.{Attr, Prop, Style}

trait RuleImplicits[N <: Node[N]] {

  implicit def withEmptyVNodeOps(emptyVNode: N): EmptyVNodeOps[N] = {
    new EmptyVNodeOps(emptyVNode)
  }

  implicit def withAttrRuleOps[V](attr: Attr[V, N]): AttrRuleOps[V, N] = {
    new AttrRuleOps(attr)
  }

  implicit def withPropRuleOps[V](prop: Prop[V, N]): PropRuleOps[V, N] = {
    new PropRuleOps(prop)
  }

  implicit def withStyleRuleOps[V](style: Style[V, N]): StyleRuleOps[V, N] = {
    new StyleRuleOps(style)
  }

  implicit def childElementToRule(child: ExpectedElement[N]): Rule[N] = new Rule[N] {
    def applyTo(expectedElement: ExpectedElement[N]): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }

  implicit def childStringToRule(child: String): Rule[N] = new Rule[N] {
    def applyTo(expectedElement: ExpectedElement[N]): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }
}
