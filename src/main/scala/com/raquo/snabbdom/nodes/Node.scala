package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

// @TODO make this a trait, not a class!?

@ScalaJSDefined
class Node[N <: Node[N, D], D <: NodeData[N, D]](tagName: js.UndefOr[String])(
  implicit builders: Builders[N, D]
) extends js.Object { self: N =>

  var elm: js.UndefOr[dom.Node] = js.undefined

  var sel: js.UndefOr[String] = tagName

  var key: js.UndefOr[String] = js.undefined

  var data: D = builders.nodeData() // @TODO[Perf] this initialization is excessive, but it saves a lot of boilerplate

  var text: js.UndefOr[String] = js.undefined

  @JSName("children")
  var maybeChildren: js.UndefOr[js.Array[N]] = js.undefined

  /** Apply the given modifiers (e.g. additional children, or new attributes) to the [[Node]]. */
  @JSName("applyModifiers")
  def apply(modifiers: Modifier[N, D]*): N = {
    // ugly while loop for speed
    var i = 0
    while (i < modifiers.length) {
      modifiers(i).applyTo(this)
      i += 1
    }
    this
  }

  def addChild(child: N): Unit = {
    // This `addChild` method used to have a bunch more logic to "optimize" text handling.
    // I think we're better off without it, so I will remove this now redundant method soon.
    addChildToList(child)
  }

  @inline private def addChildToList(child: N): Unit = {
    if (maybeChildren.isEmpty) {
      maybeChildren = new js.Array[N]()
    }
    maybeChildren.get.push(child)
  }

  def copy(): N = {
    // @TODO[Perf] Use object-assign somehow?
    val newNode = builders.node(tagName = sel)
    newNode.sel = sel
    newNode.data = data.copy()
    elm.foreach(_elm => newNode.elm = _elm)
    key.foreach(_key => newNode.key = _key)
    text.foreach(_text => newNode.text = _text)
    maybeChildren.foreach(children => newNode.maybeChildren = copyChildren(children))
    newNode
  }

  def copyChildren(children: js.Array[N]): js.Array[N] = {
    children.jsSlice()
  }
}
