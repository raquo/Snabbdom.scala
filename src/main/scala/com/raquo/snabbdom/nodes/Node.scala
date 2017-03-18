package com.raquo.snabbdom.nodes

import com.raquo.interfaces.objectAssign
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

// @TODO make this a trait, not a class!

@ScalaJSDefined
class Node[N <: Node[N]](tagName: js.UndefOr[String]) extends js.Object { self: N =>

  var elm: js.UndefOr[dom.Node] = js.undefined

  var sel: js.UndefOr[String] = tagName

  var key: js.UndefOr[String] = js.undefined

  var data: NodeData[N] = new NodeData[N] {} // @TODO[Perf] this initialization is excessive, but it saves a lot of boilerplate

  var text: js.UndefOr[String] = js.undefined

  var children: js.UndefOr[js.Array[N]] = js.undefined

  /** Apply the given modifiers (e.g. additional children, or new attributes) to the [[Node]]. */
  @JSName("applyModifiers")
  def apply(modifiers: Modifier[N]*): N = {
    // ugly while loop for speed
    var i = 0
    while (i < modifiers.length) {
      modifiers(i).applyTo(this)
      i += 1
    }
    this
  }

  def addChild(child: N)(implicit builders: Builders[N]): Unit = {

    val addingTextNode = child.sel.isEmpty

    if (addingTextNode) {
      // @TODO avoid this string-concatenation magic, I think
      val hasChildren = children.isDefined && children.get.length > 0
      if (hasChildren) {
        addChildToList(child)
      } else if (text.isEmpty) {
        text = child.text.get // text
      } else {
        text += child.text.get // text
      }
    } else {
      if (text.isDefined) {
        addChildToList(Node.createTextNode[N](text.get))
        text = js.undefined
      }
      addChildToList(child)
    }
  }

  @inline private def addChildToList(child: N /*Child[N]*/): Unit = {
    if (children.isEmpty) {
      children = new js.Array[N]()
    }
    children.get.push(child)
  }

  def copy(builders: Builders[N]): N = {
    // @TODO[NOW] Replace with two-level object-assign
    val newNode = builders.vnode(tagName = sel)
    newNode.sel = sel
    newNode.data = copyData(data)
    elm.foreach(_elm => newNode.elm = _elm)
    key.foreach(_key => newNode.key = _key)
    text.foreach(_text => newNode.text = _text)
    children.foreach(_children => newNode.children = copyChildren(_children))
    newNode
  }

  def copyData(data: NodeData[N]): NodeData[N] = {
    val newData = new NodeData[N] {}
    data.attrs.foreach { attrs =>
      newData.attrs = objectAssign(js.Dictionary[Boolean | String](), attrs)
    }
    data.on.foreach { on =>
      newData.on = objectAssign(js.Dictionary[js.Function](), on)
    }
    data.props.foreach { props =>
      newData.props = objectAssign(js.Dictionary[Any](), props)
    }
    data.styles.foreach { styles =>
      newData.styles = objectAssign(js.Dictionary[Any](), styles)
    }
    data.hooks.foreach {
      hooks => newData.hooks = copyHooks(hooks)
    }
    newData
  }

  def copyHooks(hooks: Hooks[N]): Hooks[N] = {
    new Hooks[N] {
      init = hooks.init
      create = hooks.create
      insert = hooks.insert
      prePatch = hooks.prePatch
      update = hooks.update
      postPatch = hooks.postPatch
      destroy = hooks.destroy
      remove = hooks.remove
    }
  }

  def copyChildren(children: js.Array[N]): js.Array[N] = {
    children.jsSlice()
  }
}

object Node {

  def createTextNode[N <: Node[N]](text: String)(implicit builders: Builders[N]): N = {
    val textNode = builders.vnode(js.undefined)
    textNode.text = text
    textNode
  }
}
