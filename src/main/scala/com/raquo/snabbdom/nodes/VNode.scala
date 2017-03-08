package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.{Child, Children, Modifier}
import org.scalajs.dom.raw.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

@ScalaJSDefined
class VNode(tagName: String) extends Modifier {

  import VNode.addChildToList

  var elm: js.UndefOr[Node] = js.undefined

  var sel: String = tagName

  var key: js.UndefOr[String] = js.undefined

  var data: VNodeData = new VNodeData {} // @TODO[Perf] this initialization is excessive, but it saves a lot of boilerplate

  var text: js.UndefOr[String] = js.undefined

  var children: js.UndefOr[Children] = js.undefined

  override def applyTo(vnode: VNode): Unit = {
    if (text.isDefined) {
      addChildToList(parent = vnode, child = new TextNode(text.get))
      text = js.undefined
    }
    addChildToList(parent = vnode, child = this)
  }

  /** Apply the given modifiers (e.g. additional children, or new attributes) to the [[VNode]]. */
  @JSName("applyModifiers")
  def apply(modifiers: Modifier*): VNode = {
    // ugly while loop for speed
    var i = 0
    while (i < modifiers.length) {
      modifiers(i).applyTo(this)
      i += 1
    }
    this
  }
}

object VNode {

  @inline private[snabbdom] def addChildToList(parent: VNode, child: Child): Unit = {
    if (parent.children.isEmpty) {
      parent.children = new Children()
    }
    parent.children.get.push(child)
  }
}
