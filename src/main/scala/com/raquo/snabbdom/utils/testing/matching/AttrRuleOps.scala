package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.Attr
import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import org.scalajs.dom

class AttrRuleOps[V, N <: Node[N, D], D <: NodeData[N, D]](val attr: Attr[V, N, D]) extends AnyVal {

  def is(expected: V): Rule[N, D] = new Rule[N, D] {
    def applyTo(testNode: ExpectedElement[N, D]): Unit = {
      testNode.addCheck(nodeAttrIs(attr, Some(expected)))
    }
  }

  def isEmpty: Rule[N, D] = new Rule[N, D] {
    def applyTo(testNode: ExpectedElement[N, D]): Unit = {
      testNode.addCheck(nodeAttrIs(attr, None))
    }
  }

  private def nodeAttrIs(attr: Attr[V, N, D], maybeExpectedValue: Option[V])(node: dom.Node): MaybeError = {
    (node, maybeExpectedValue) match {
      case (element: dom.Element, None) =>
        if (element.hasAttribute(attr.name)) {
          val actual = element.getAttribute(attr.name)
          Some(s"Attr `${attr.name}` should not be present: actual value ${repr(actual)}, expected to be missing")
        } else {
          None
        }
      case (element: dom.Element, Some(expectedValue: Boolean)) =>
        val hasAttribute = element.hasAttribute(attr.name)
        val attributeValue = element.getAttribute(attr.name)
        (hasAttribute, expectedValue) match {
          case (true, false) => Some(s"Boolean attr `${attr.name}` mismatch: attribute value is ${repr(attributeValue)}, expected attribute to be missing")
          case (false, true) => Some(s"Boolean attr `${attr.name}` mismatch: attribute is missing, expected to be present")
          case (true, true) if attributeValue != "true" => Some(s"Boolean attr `${attr.name}` value mismatch: actual ${repr(attributeValue)}, expected true")
          case _ => None
        }
      case (element: dom.Element, Some(expectedValue)) =>
        if (!element.hasAttribute(attr.name)) {
          Some(s"Attr `${attr.name}` is missing, expected ${repr(expectedValue)}")
        } else {
          val actualValue = element.getAttribute(attr.name)
          if (actualValue != expectedValue.toString) {
            Some(s"Attr `${attr.name}` value is incorrect: actual value ${repr(actualValue)}, expected value ${repr(expectedValue)}")
          } else {
            None
          }
        }
      case _ =>
        Some(s"Unable to verify Attr `${attr.name}` because node $node is not a DOM Element (might be a text node?)")
    }
  }
}
