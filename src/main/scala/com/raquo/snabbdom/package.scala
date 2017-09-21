package com.raquo

import com.raquo.snabbdom.builders.Builders
import com.raquo.snabbdom.hooks.ModuleHooks
import com.raquo.snabbdom.nodes.{ChildNode, Conversions, IterableNode, Node, NodeData}
import com.raquo.snabbdom.simple.{VNode, VNodeBuilders, VNodeData}
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.raw.Event

import scala.scalajs.js
import scala.scalajs.js.|

package object snabbdom extends {

  type EventCallback[TEvent <: Event] = js.Function1[TEvent, Unit]

  type GenericEventCallback = EventCallback[Event]

  type MouseEventCallback = EventCallback[MouseEvent]

  implicit val vnodeBuilders = new VNodeBuilders {}

  /** These are snabbdom's built-in modules that Snabbdom.scala supports.
    * You may choose to pass more modules to [[Snabbdom.init]] (see [[ModuleHooks]]),
    * and you might want to subclass [[Node]], [[NodeData]] and [[Builders]] if you do that.
    * For an example of this approach, see my Laminar project.
    *
    * Note that if you fail to include any of the following built-in modules
    * in the init call, the types will NOT be adjusted to reflect their absence.
    */
  def builtInModules[N <: Node[N, D], D <: NodeData[N, D]]: js.Array[NativeModule | ModuleHooks[N, D]] = js.Array(
    AttrsModule,
    PropsModule,
    EventsModule,
    StyleModule
  )

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
