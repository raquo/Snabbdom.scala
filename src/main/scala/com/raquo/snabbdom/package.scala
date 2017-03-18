package com.raquo

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.collections.attrs.{Attrs, GlobalAttrs, InputAttrs}
import com.raquo.snabbdom.collections.eventProps.{ClipboardEventProps, KeyboardEventProps, MouseEventProps}
import com.raquo.snabbdom.collections.props.Props
import com.raquo.snabbdom.collections.styles.Styles
import com.raquo.snabbdom.collections.tags.{Tags, Tags2}
import com.raquo.snabbdom.nodes.{ChildNode, Conversions, IterableNode, Node}
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.raw.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

package object snabbdom extends {

  // @TODO[WTF] this should be in a separate file but it doesn't want to compile :(
  @ScalaJSDefined
  class VNode(tagName: js.UndefOr[String]) extends Node[VNode](tagName)

  type EventCallback[TEvent <: Event] = js.Function1[TEvent, Unit]

  type GenericEventCallback = EventCallback[Event]

  type MouseEventCallback = EventCallback[MouseEvent]

  // @TODO[WTF] this should be in a separate file but it doesn't want to compile :(
  trait VNodeBuilders extends Builders[VNode] {
    override def vnode(tagName: js.UndefOr[String]): VNode = {
      new VNode(tagName)
    }
  }

  val vnodeBuilders = new VNodeBuilders {}

  object tags extends Tags[VNode] with VNodeBuilders

  object allTags extends Tags[VNode] with Tags2[VNode] with VNodeBuilders

  object attrs extends Attrs[VNode] with InputAttrs[VNode] with GlobalAttrs[VNode] with VNodeBuilders

  object props extends Props[VNode] with VNodeBuilders // @TODO add more `with`?

  object events extends MouseEventProps[VNode] with KeyboardEventProps[VNode] with ClipboardEventProps[VNode] with VNodeBuilders

  object styles extends Styles[VNode] with VNodeBuilders


  // @TODO[API] This is probably avoidable, but I can't get generic versions of these implicit conversions to be picked up

  private implicit val builders: Builders[VNode] = vnodeBuilders

  @inline implicit def textToChildNode(text: String): ChildNode[VNode] = {
    Conversions.textToChildNode(text)
  }

  @inline implicit def nodeToChildNode(vnode: VNode): ChildNode[VNode] = {
    Conversions.nodeToChildNode(vnode)
  }

  @inline implicit def toIterableNode(modifiers: Iterable[Modifier[VNode]]): IterableNode[VNode] = {
    Conversions.toIterableNode[VNode](modifiers)
  }

  @inline implicit def optionToModifier[T](maybeModifier: Option[T])(implicit toModifier: T => Modifier[VNode]): Modifier[VNode] = {
    Conversions.optionToModifier(maybeModifier)
  }
}
