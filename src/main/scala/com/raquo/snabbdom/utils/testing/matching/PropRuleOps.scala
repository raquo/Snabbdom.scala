package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.Prop
import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import org.scalajs.dom

import scala.scalajs.js

// @TODO Create EventPropOps

class PropRuleOps[V, N <: Node[N, D], D <: NodeData[N, D]](val prop: Prop[V, N, D]) extends AnyVal {

  def is(expected: V): Rule[N, D] = new Rule[N, D] {
    def applyTo(testNode: ExpectedElement[N, D]): Unit = {
      testNode.addCheck(nodePropIs(prop, Some(expected)))
    }
  }

  def isEmpty: Rule[N, D] = new Rule[N, D] {
    def applyTo(testNode: ExpectedElement[N, D]): Unit = {
      testNode.addCheck(nodePropIs(prop, None))
    }
  }

  private def nodePropIs(prop: Prop[V, N, D], maybeExpectedValue: Option[V])(node: dom.Node): MaybeError = {
    val maybeActualValue = getProp(node, prop)
    if (node.isInstanceOf[dom.Element]) {
      (maybeActualValue, maybeExpectedValue) match {
        case (None, None) => None
        case (None, Some(expectedValue)) =>
          Some(s"Prop `${prop.name}` is missing, expected ${repr(expectedValue)}")
        case (Some(actualValue), None) =>
          Some(s"Prop `${prop.name}` should not be present: actual value ${repr(actualValue)}, expected to be missing")
        case (Some(actualValue), Some(expectedValue)) =>
          if (actualValue != expectedValue) {
            Some(s"Prop `${prop.name}` value is incorrect: actual value ${repr(actualValue)}, expected value ${repr(expectedValue)}")
          } else {
            None
          }
      }
    } else {
      Some(s"Unable to verify Prop `${prop.name}` because node $node is not a DOM Element (might be a text node?)")
    }
  }

  private def getProp(element: dom.Node, prop: Prop[V, N, D]): Option[V] = {
    val propValue = element.asInstanceOf[js.Dynamic].selectDynamic(prop.name)
    val jsUndef = js.undefined
    propValue.asInstanceOf[Any] match {
      case str: String if str.length == 0 => None
      case `jsUndef` => None
      case null => None
      case _ => Some(propValue.asInstanceOf[V])
    }
  }
}
