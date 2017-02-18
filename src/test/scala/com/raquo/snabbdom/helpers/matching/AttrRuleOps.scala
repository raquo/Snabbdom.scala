package com.raquo.snabbdom.helpers.matching

import com.raquo.snabbdom.setters.Attr
import org.scalajs.dom

class AttrRuleOps[V](val attr: Attr[V]) extends AnyVal {

  def is(expected: V): Rule = new Rule {
    def applyTo(testNode: ExpectedElement): Unit = {
      testNode.addCheck(nodeAttrIs(attr, Some(expected)))
    }
  }

  def isEmpty: Rule = new Rule {
    def applyTo(testNode: ExpectedElement): Unit = {
      testNode.addCheck(nodeAttrIs(attr, None))
    }
  }

  private def nodeAttrIs(attr: Attr[V], maybeExpectedValue: Option[V])(node: dom.Node): Option[String] = {
    (node, maybeExpectedValue) match {
      case (element: dom.Element, None) =>
        if (element.hasAttribute(attr.name)) {
          val actual = element.getAttribute(attr.name)
          Some(s"Attr `${attr.name}` should not be present: actual value $actual, expected to be missing")
        } else {
          None
        }
      case (element: dom.Element, Some(expectedValue: Boolean)) =>
        val hasAttribute = element.hasAttribute(attr.name)
        val attributeValue = element.getAttribute(attr.name)
        (hasAttribute, expectedValue) match {
          case (true, false) => Some(s"Boolean attr `${attr.name}` mismatch: attribute value is $attributeValue, expected attribute to be missing")
          case (false, true) => Some(s"Boolean attr `${attr.name}` mismatch: attribute is missing, expected to be present")
          case (true, true) if attributeValue != "true" => Some(s"Boolean attr `${attr.name}` value mismatch: actual $attributeValue, expected true")
          case _ => None
        }
      case (element: dom.Element, Some(expectedValue)) =>
        if (!element.hasAttribute(attr.name)) {
          Some(s"Attr `${attr.name}` is missing, expected $expectedValue")
        } else {
          val actualValue = element.getAttribute(attr.name)
          if (actualValue != expectedValue.toString) {
            Some(s"Attr `${attr.name}` value is incorrect: actual value $actualValue, expected value $expectedValue")
          } else {
            None
          }
        }
      case _ =>
        Some(s"Unable to verify Attr `${attr.name}` because node $node is not a DOM Element (might be a text node?)")
    }
  }
}
