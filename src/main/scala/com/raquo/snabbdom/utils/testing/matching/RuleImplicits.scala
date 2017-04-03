package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.{Attr, Prop, Style}

trait RuleImplicits[N <: Node[N, D], D <: NodeData[N, D]] {

  implicit def withEmptyNodeOps(emptyNode: N): EmptyNodeOps[N, D] = {
    new EmptyNodeOps[N, D](emptyNode)
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

  implicit def childElementToRule(child: ExpectedNode[N, D]): Rule[N, D] = {
    new Rule[N, D] {
      def applyTo(expectedNode: ExpectedNode[N, D]): Unit = {
        child.addCheck(child.checkTagName)
        expectedNode.addExpectedChild(child)
      }
    }
  }

  implicit def childTextToRule(childText: String)(implicit builders: Builders[N, D]): Rule[N, D] = {
    new Rule[N, D] {
      def applyTo(expectedNode: ExpectedNode[N, D]): Unit = {
        val expectedTextChild = new ExpectedNode[N, D](builders.textNode(childText))
        expectedTextChild.addCheck(ExpectedNode.checkText(childText))
        expectedNode.addExpectedChild(expectedTextChild)
      }
    }
  }
}
