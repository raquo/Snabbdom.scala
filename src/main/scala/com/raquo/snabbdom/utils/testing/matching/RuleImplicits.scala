package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.{Attr, Prop, Style}

trait RuleImplicits[N <: Node[N, D], D <: NodeData[N, D]] {

  implicit def withEmptyVNodeOps(emptyVNode: N): EmptyVNodeOps[N, D] = {
    new EmptyVNodeOps[N, D](emptyVNode)
  }

  implicit def withAttrRuleOps[V](attr: Attr[V, N, D]): AttrRuleOps[V, N, D] = {
    new AttrRuleOps(attr)
  }

  implicit def withPropRuleOps[V](prop: Prop[V, N, D]): PropRuleOps[V, N, D] = {
    new PropRuleOps(prop)
  }

  implicit def withStyleRuleOps[V](style: Style[V, N, D]): StyleRuleOps[V, N, D] = {
    new StyleRuleOps(style)
  }

  implicit def childElementToRule(child: ExpectedElement[N, D]): Rule[N, D] = new Rule[N, D] {
    def applyTo(expectedElement: ExpectedElement[N, D]): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }

  implicit def childStringToRule(child: String): Rule[N, D] = new Rule[N, D] {
    def applyTo(expectedElement: ExpectedElement[N, D]): Unit = {
      expectedElement.addExpectedChild(child)
    }
  }
}
