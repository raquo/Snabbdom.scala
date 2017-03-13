package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders
import org.scalajs.dom.raw.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

class RichNode[N <: VNode](val vnode: N) extends AnyVal {

  /** Apply the given modifiers (e.g. additional children, or new attributes) to the [[VNode]]. */
  @JSName("applyModifiers")
  def apply(modifiers: Modifier[N]*): N = {
    // ugly while loop for speed
    var i = 0
    while (i < modifiers.length) {
      modifiers(i).applyTo(vnode)
      i += 1
    }
    vnode
  }

  def addChild(child: N)(implicit builders: Builders[N]): Unit = {

    val addingTextNode = child.sel.isEmpty

    if (addingTextNode) {
      // @TODO avoid this string-concatenation magic, I think
      val hasChildren = vnode.children.isDefined && vnode.children.get.length > 0
      if (hasChildren) {
        addChildToList(child)
      } else if (vnode.text.isEmpty) {
        vnode.text = child.text.get // text
      } else {
        vnode.text += child.text.get // text
      }
    } else {
      if (vnode.text.isDefined) {
        addChildToList(VNode.createTextNode[N](vnode.text.get))
        vnode.text = js.undefined
      }
      addChildToList(child)
    }
  }

  @inline private def addChildToList(child: N /*Child[N]*/): Unit = {
    if (vnode.children.isEmpty) {
      vnode.children = new js.Array[VNode]()
    }
    // @TODO
    vnode.children.get.push(child)
  }

}

@ScalaJSDefined
class VNode(tagName: js.UndefOr[String]) extends js.Object { self =>

  var elm: js.UndefOr[Node] = js.undefined

  var sel: js.UndefOr[String] = tagName

  var key: js.UndefOr[String] = js.undefined

  var data: VNodeData = new VNodeData {} // @TODO[Perf] this initialization is excessive, but it saves a lot of boilerplate

  var text: js.UndefOr[String] = js.undefined

  var children: js.UndefOr[js.Array[VNode]] = js.undefined
}

object VNode {

  def createTextNode[N <: VNode](text: String)(implicit builders: Builders[N]): N = {
    val textNode = builders.vnode(js.undefined)
    textNode.text = text
    textNode
  }
}
