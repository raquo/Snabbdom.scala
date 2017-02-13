package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.setters.{AttrSetter, EventPropSetter, PropSetter, StyleSetter}
import com.raquo.snabbdom.{Child, Children, Modifier}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

class RichNode(val thisNode: VNode) extends AnyVal {

  /**
    * Apply the given modifiers (e.g. additional children, or new attributes) to the [[VNode]].
    */
  @JSName("applyModifiers")
  def apply(modifiers: Modifier*): VNode = {
    // ugly while loop for speed
    var i = 0
    while (i < modifiers.length) {
      modifiers(i).applyTo(thisNode)
      i += 1
    }
    thisNode
  }

  private[snabbdom] def setAttr[V](attrModifier: AttrSetter[V]): Unit = {
    val attrKey = attrModifier.key.name
    val attrValue: Boolean | String = if (attrModifier.value.isInstanceOf[Boolean]) {
      attrModifier.value.asInstanceOf[Boolean]
    } else {
      attrModifier.value.toString
    }
    if (thisNode.data.attrs.isEmpty) {
      thisNode.data.attrs = js.Dictionary[Boolean | String](attrKey -> attrValue)
    } else {
      thisNode.data.attrs.get.update(attrKey, attrValue)
    }
  }

  private[snabbdom] def setEventProp[V <: js.Function](eventPropModifier: EventPropSetter[V]): Unit = {
    val eventKey = eventPropModifier.key.name
    val eventValue = eventPropModifier.value
    if (thisNode.data.on.isEmpty) {
      thisNode.data.on = js.Dictionary[js.Function](eventKey -> eventValue)
    } else {
      thisNode.data.on.get.update(eventKey, eventValue)
    }
  }

  private[snabbdom] def setProp[V](propModifier: PropSetter[V]): Unit = {
    val propKey = propModifier.key.name
    val propValue = propModifier.value
    if (thisNode.data.props.isEmpty) {
      thisNode.data.props = js.Dictionary[Any](propKey -> propValue)
    } else {
      thisNode.data.props.get.update(propKey, propValue)
    }
  }

  private[snabbdom] def setStyle[V](stylePropModifier: StyleSetter[V]): Unit = {
    val styleKey = stylePropModifier.key.name
    val styleValue = stylePropModifier.value
    if (thisNode.data.styles.isEmpty) {
      thisNode.data.styles = js.Dictionary[Any](styleKey -> styleValue)
    } else {
      thisNode.data.styles.get.update(styleKey, styleValue)
    }
  }

  private[snabbdom] def addChild(vnode: VNode): Unit = {
    if (thisNode.text.isDefined) {
      addChildToList(new TextNode(thisNode.text.get))
      thisNode.text = js.undefined
    }
    addChildToList(vnode)
  }

  private[snabbdom] def addTextChild(textNode: TextNode): Unit = {
    // @TODO avoid this string-concatenation magic, I think
    val hasChildren = thisNode.children.isDefined && thisNode.children.get.length > 0
    if (hasChildren) {
      addChildToList(textNode)
    } else if (thisNode.text.isEmpty) {
      thisNode.text = textNode.text
    } else {
      thisNode.text += textNode.text
    }
  }

  @inline private def addChildToList(child: Child): Unit = {
    if (thisNode.children.isEmpty) {
      thisNode.children = new Children()
    }
    thisNode.children.get.push(child)
  }
}
