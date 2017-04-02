package com.raquo.snabbdom.utils.testing.matching

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.utils.testing.UtilSpec.repr
import org.scalajs.dom

import scala.collection.mutable

class ExpectedNode[N <: Node[N, D], D <: NodeData[N, D]](private val emptyVNode: N) {

  import ExpectedNode._

  // @TODO[Integrity] Write tests for this test util; it's quite complicated.
  // @TODO[Integrity] assert that no attrs / props / eventprops / etc. are defined because those won't be tested

  private val checksBuffer: mutable.Buffer[Check] = mutable.Buffer()

  private val expectedChildrenBuffer: mutable.Buffer[ExpectedNode[N, D]] = mutable.Buffer()

  def checks: List[Check] = checksBuffer.toList

  def expectedChildren: List[ExpectedNode[N, D]] = expectedChildrenBuffer.toList

  def addCheck(check: Check): Unit = {
    checksBuffer.append(check)
  }

  def addExpectedChild(child: ExpectedNode[N, D]): Unit = {
    expectedChildrenBuffer.append(child)
  }

  def like(rules: Rule[N, D]*): ExpectedNode[N, D] = {
    rules.foreach(_.applyTo(this))
    this
  }

  def checkTagName(actualNode: dom.Node): MaybeError = {
    val isComment = emptyVNode.sel.get == "!"
    val expectedNodeType = if (isComment) "dom.Comment" else "dom.Element"
    actualNode match {
      case element: dom.Element if !isComment =>
        if (element.tagName.toLowerCase != emptyVNode.sel.get) {
          Some(s"Element tag name is incorrect: actual ${repr(element.tagName.toLowerCase)}, expected ${repr(emptyVNode.sel)}")
        } else {
          None
        }
      case comment: dom.Comment if isComment => None
      case _ => Some(
        s"Node type mismatch: actual node ${repr(actualNode)}, expected an instance of ${repr(expectedNodeType)}"
      )
    }
  }

  def checkNode(node: dom.Node, clue: String): ErrorList = {
    val checksErrors: List[String] = checks
      .flatMap(check => check(node))
      .map(withClue(clue, _))
    val actualNumChildren = node.childNodes.length
    val expectedNumChildren = expectedChildren.length

    val childErrors = if (actualNumChildren != expectedNumChildren) {
      List(
        withClue(clue = clue, s"Child nodes length mismatch: actual ${repr(actualNumChildren)}, expected ${repr(expectedNumChildren)}"),
        withClue(clue = clue, s"- Detailed comparison:\n    actual - ${repr(nodeListToList(node.childNodes))},\n  expected - ${repr(expectedChildren)}")
      )
    } else {
      expectedChildren.zipWithIndex.flatMap {
        case (expectedChildElement, index) =>
          expectedChildElement.checkNode(
            node = node.childNodes(index),
            clue = s"$clue --- @$index"
          )
      }
    }

    checksErrors ++ childErrors
  }
}

object ExpectedNode {

  def withClue(clue: String, message: String): String = {
    s"[$clue]: $message"
  }

  def checkText(expectedText: String)(node: dom.Node): MaybeError = {
    if (node.nodeType != dom.Node.TEXT_NODE) {
      Some(s"Node type mismatch: actual ${repr(node.nodeType)}, expected ${repr(dom.Node.TEXT_NODE)} (Text Node)")
    } else if (node.textContent != expectedText) {
      Some(s"Text node textContent mismatch: actual ${repr(node.textContent)}, expected ${repr(expectedText)}")
    } else {
      None
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
