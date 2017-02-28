package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import com.raquo.snabbdom.setters.Style
import org.scalajs.dom

import scala.scalajs.js

class StyleRuleOps[V](val style: Style[V]) extends AnyVal {

  def is(expected: V): Rule = new Rule {
    def applyTo(testNode: ExpectedElement): Unit = {
      testNode.addCheck(nodeStyleIs(style, expected))
    }
  }

  private def nodeStyleIs(style: Style[V], expectedValue: V)(node: dom.Node): MaybeError = {
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

  private def getStyle(element: dom.Element, style: Style[V]): Option[String] = {
    element.asInstanceOf[js.Dynamic]
      .selectDynamic("style")
      .selectDynamic(style.name)
      .asInstanceOf[js.UndefOr[String]].toOption
  }
}
