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

package object snabbdom extends {

  type EventCallback[TEvent <: Event] = js.Function1[TEvent, Unit]

  type GenericEventCallback = EventCallback[Event]

  type MouseEventCallback = EventCallback[MouseEvent]

  implicit val vnodeBuilders = new VNodeBuilders {}

  object tags extends Tags[VNode] with VNodeBuilders

  object allTags extends Tags[VNode] with Tags2[VNode] with VNodeBuilders

  object attrs extends Attrs[VNode] with InputAttrs[VNode] with GlobalAttrs[VNode] with VNodeBuilders

  object props extends Props[VNode] with VNodeBuilders // @TODO add more `with`?

  object events extends MouseEventProps[VNode] with KeyboardEventProps[VNode] with ClipboardEventProps[VNode] with VNodeBuilders

  object styles extends Styles[VNode] with VNodeBuilders

  @inline implicit def textToChildNode(text: String): ChildNode[VNode] = {
    Conversions.textToChildNode(text)(vnodeBuilders)
  }

  @inline implicit def nodeToChildNode(vnode: VNode): ChildNode[VNode] = {
    Conversions.nodeToChildNode(vnode)(vnodeBuilders)
  }

  @inline implicit def toIterableNode(modifiers: Iterable[Modifier[VNode]]): IterableNode[VNode] = {
    Conversions.toIterableNode[VNode](modifiers)
  }

  @inline implicit def optionToModifier[T](maybeModifier: Option[T])(implicit toModifier: T => Modifier[VNode]): Modifier[VNode] = {
    Conversions.optionToModifier(maybeModifier)
  }
}
