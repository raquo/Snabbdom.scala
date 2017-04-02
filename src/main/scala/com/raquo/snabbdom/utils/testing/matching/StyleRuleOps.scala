package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import com.raquo.snabbdom.setters.Style
import org.scalajs.dom

import scala.scalajs.js

class StyleRuleOps[V, N <: Node[N, D], D <: NodeData[N, D]](val style: Style[V, N, D]) extends AnyVal {

  def is(expected: V): Rule[N, D] = new Rule[N, D] {
    def applyTo(testNode: ExpectedNode[N, D]): Unit = {
      testNode.addCheck(nodeStyleIs(style, expected))
    }
  }

  private def nodeStyleIs(style: Style[V, N, D], expectedValue: V)(node: dom.Node): MaybeError = {
    val maybeActualValue = node.asInstanceOf[js.Dynamic]
      .selectDynamic("style")
      .selectDynamic(style.name)
      .asInstanceOf[js.UndefOr[V]].toOption
    maybeActualValue match {
      case Some(actualValue) =>
        if (actualValue == expectedValue) {
          None
        } else {
          Some(s"Style `${style.name}` value is incorrect: actual value ${repr(actualValue)}, expected value ${repr(expectedValue)}")
        }
      case None =>
        Some(s"Style `${style.name}` is completely missing, expected ${repr(expectedValue)}")
    }
  }

  private def getStyle(element: dom.Element, style: Style[V, N, D]): Option[String] = {
    element.asInstanceOf[js.Dynamic]
      .selectDynamic("style")
      .selectDynamic(style.name)
      .asInstanceOf[js.UndefOr[String]].toOption
  }
}
