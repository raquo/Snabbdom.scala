package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.Node
import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import org.scalajs.dom

import scala.collection.mutable
import scala.scalajs.js.|

class ExpectedElement[N <: Node[N]](private val emptyVNode: N) {

  import ExpectedElement._

  // @TODO[Integrity] Write tests for this test util; it's quite complicated.
  // @TODO[Integrity] assert that no attrs / props / eventprops / etc. are defined because those won't be tested

  private val checksBuffer: mutable.Buffer[Check] = mutable.Buffer(
    element => checkTagName(element, this)
  )

  private val expectedChildrenBuffer: mutable.Buffer[ExpectedElement[N] | String] = mutable.Buffer()

  def checks: List[Check] = checksBuffer.toList

  def expectedChildren: List[ExpectedElement[N] | String] = expectedChildrenBuffer.toList

  def addCheck(check: Check): Unit = {
    checksBuffer.append(check)
  }

  def addExpectedChild(child: ExpectedElement[N] | String): Unit = {
    expectedChildrenBuffer.append(child)
  }

  def like(rules: Rule[N]*): ExpectedElement[N] = {
    rules.foreach(_.applyTo(this))
    this
  }
}

object ExpectedElement {

  def checkTagName[N <: Node[N]](element: dom.Element, expectedElement: ExpectedElement[N]): MaybeError = {
    if (element.tagName.toLowerCase != expectedElement.emptyVNode.sel.get) {
      Some(s"Element tag name is incorrect: actual ${repr(element.tagName.toLowerCase)}, expected ${repr(expectedElement.emptyVNode.sel)}")
    } else {
      None
    }
  }

  def withClue(clue: String, message: String): String = {
    s"[$clue]: $message"
  }

  def checkElement[N <: Node[N]](element: dom.Element, expectedElement: ExpectedElement[N], clue: String): ErrorList = {

    val checksErrors: List[String] = expectedElement.checks
      .flatMap(check => check(element))
      .map(withClue(clue, _))

    val actualNumChildren = element.childNodes.length
    val expectedNumChildren = expectedElement.expectedChildren.length

    val childErrors = if (actualNumChildren != expectedNumChildren) {
      List(
        withClue(clue = clue, s"Child nodes length mismatch: actual ${repr(actualNumChildren)}, expected ${repr(expectedNumChildren)}"),
        withClue(clue = clue, s"- Detailed comparison:\n    actual - ${repr(nodeListToList(element.childNodes))},\n  expected - ${repr(expectedElement.expectedChildren)}")
      )
    } else {
      expectedElement.expectedChildren.zipWithIndex.flatMap {
        // @TODO[Integrity] N is unchecked here. Grab it using ClassTag.
        case (expectedChildElement: ExpectedElement[N], index) =>
          checkChildElement(
            element.childNodes(index),
            expectedChildElement,
            childClue = s"$clue --- @$index"
          )
        case (expectedText, index) =>
          checkChildText(
            element.childNodes(index),
            expectedText.toString, // @TODO[Integrity] Assert that expectedText is already a string?
            childClue = s"$clue --- @$index"
          )
      }
    }

    checksErrors ++ childErrors
  }

  def checkChildElement[N <: Node[N]](childNode: dom.Node, expectedChildElement: ExpectedElement[N], childClue: String): ErrorList = {
    childNode match {
      case childElement: dom.Element =>
        checkElement(
          element = childElement,
          expectedElement = expectedChildElement,
          clue = childClue
        )
      case _ =>
        List(withClue(
          clue = childClue,
          s"Node type mismatch: actual node ${repr(childNode)}, expected an instance of dom.Element"
        ))
    }
  }

  def checkChildText(childNode: dom.Node, expectedText: String, childClue: String): ErrorList = {
    if (childNode.nodeType != dom.Node.TEXT_NODE) {
      List(withClue(
        clue = childClue,
        s"Node type mismatch: actual ${repr(childNode.nodeType)}, expected ${repr(dom.Node.TEXT_NODE)} (Text Node)"
      ))
    } else if (childNode.textContent != expectedText) {
      List(withClue(
        clue = childClue,
        s"Text node textContent mismatch: actual ${repr(childNode.textContent)}, expected ${repr(expectedText)}"
      ))
    } else {
      Nil
    }
  }

  def nodeListToList(nodeList: dom.NodeList): List[dom.Node] = {
    // @TODO[Polish] Move into JSUtils
    var result: List[dom.Node] = Nil
    var i = 0
    while (i < nodeList.length) {
      result = result :+ nodeList(i)
      i += 1
    }
    result
  }
}
