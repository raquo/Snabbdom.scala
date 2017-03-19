package com.raquo

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.collections.attrs.{Attrs, GlobalAttrs, InputAttrs}
import com.raquo.snabbdom.collections.eventProps.{ClipboardEventProps, KeyboardEventProps, MouseEventProps}
import com.raquo.snabbdom.collections.props.Props
import com.raquo.snabbdom.collections.styles.Styles
import com.raquo.snabbdom.collections.tags.{Tags, Tags2}
import com.raquo.snabbdom.nodes.{ChildNode, Conversions, IterableNode, Node, NodeData}
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.raw.Event

import scala.scalajs.js

package object snabbdom extends {

  type EventCallback[TEvent <: Event] = js.Function1[TEvent, Unit]

  type GenericEventCallback = EventCallback[Event]

  type MouseEventCallback = EventCallback[MouseEvent]

  implicit val vnodeBuilders = new VNodeBuilders {}

  object tags extends Tags[VNode, VNodeData] with VNodeBuilders

  object allTags extends Tags[VNode, VNodeData] with Tags2[VNode, VNodeData] with VNodeBuilders

  object attrs extends Attrs[VNode, VNodeData] with InputAttrs[VNode, VNodeData] with GlobalAttrs[VNode, VNodeData] with VNodeBuilders

  object props extends Props[VNode, VNodeData] with VNodeBuilders // @TODO add more `with`?

  object events extends MouseEventProps[VNode, VNodeData] with KeyboardEventProps[VNode, VNodeData] with ClipboardEventProps[VNode, VNodeData] with VNodeBuilders

  object styles extends Styles[VNode, VNodeData] with VNodeBuilders

  @inline implicit def textToChildNode(
    text: String
  ): ChildNode[VNode, VNodeData] = {
    Conversions.textToChildNode[VNode, VNodeData](text)(vnodeBuilders)
  }

  @inline implicit def nodeToChildNode(
    vnode: VNode
  ): ChildNode[VNode, VNodeData] = {
    Conversions.nodeToChildNode[VNode, VNodeData](vnode)(vnodeBuilders)
  }

  @inline implicit def toIterableNode(
    modifiers: Iterable[Modifier[VNode, VNodeData]]
  ): IterableNode[VNode, VNodeData] = {
    Conversions.toIterableNode[VNode, VNodeData](modifiers)
  }

  @inline implicit def optionToModifier[T](
    maybeModifier: Option[T]
  )(
    implicit toModifier: T => Modifier[VNode, VNodeData]
  ): Modifier[VNode, VNodeData] = {
    Conversions.optionToModifier[T, VNode, VNodeData](maybeModifier)
  }
}
