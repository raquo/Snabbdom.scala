package com.raquo

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.collections.attrs.{Attrs, GlobalAttrs, InputAttrs}
import com.raquo.snabbdom.collections.eventProps.{ClipboardEventProps, KeyboardEventProps, MouseEventProps}
import com.raquo.snabbdom.collections.props.Props
import com.raquo.snabbdom.collections.styles.Styles
import com.raquo.snabbdom.collections.tags.{Tags, Tags2}
import com.raquo.snabbdom.nodes.{IterableNode, RichNode, TextNode, VNode}
import org.scalajs.dom.MouseEvent
import org.scalajs.dom.raw.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

package object snabbdom {

  type VNode = nodes.VNode

  type Child = VNode | TextNode

  type Children = js.Array[Child]

  type EventCallback[TEvent <: Event] = js.Function1[TEvent, Unit]

  type GenericEventCallback = EventCallback[Event]

  type MouseEventCallback = EventCallback[MouseEvent]

  object tags extends Tags with Builders

  object allTags extends Tags with Tags2 with Builders

  object attrs extends Attrs with InputAttrs with GlobalAttrs with Builders

  object props extends Props with Builders // @TODO add more `with`?

  object events extends MouseEventProps with KeyboardEventProps with ClipboardEventProps with Builders

  object styles extends Styles with Builders

  /**
    * Represents lack of a modifier
    */
  @ScalaJSDefined
  object NoModifier extends Modifier {
    // @TODO Should this apply a Null child instead?
    @inline def applyTo(vnode: VNode): Unit = ()
  }

  implicit def optionToModifier[T](maybeModifier: Option[T])(implicit toModifier: T => Modifier): Modifier = {
    // @TODO[API][Performance] Implicitception – does this harm compile or runtime performance?
    maybeModifier match {
      case Some(modifier) => modifier
      case None => NoModifier
    }
  }

  implicit def toTextNode(text: String): TextNode = {
    new TextNode(text)
  }

  implicit def toIterableNode(modifiers: Iterable[Modifier]): IterableNode = {
    new IterableNode(modifiers)
  }

  implicit def toRichNode(vnode: VNode): RichNode = {
    new RichNode(vnode)
  }
}
