package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders

object Conversions {

  // @TODO add similar conversions for numbers and nulls – see what snabbdom supports
  def textToChildNode[N <: VNode](text: String)(implicit builders: Builders[N]): ChildNode[N] = {
    new ChildNode(VNode.createTextNode[N](text))
  }

  def nodeToChildNode[N <: VNode](vnode: N)(implicit builders: Builders[N]): ChildNode[N] = {
    new ChildNode(vnode)
  }

  def toIterableNode[N <: VNode](modifiers: Iterable[Modifier[N]]): IterableNode[N] = {
    new IterableNode(modifiers)
  }

  def toRichNode[N <: VNode](vnode: N): RichNode[N] = {
    new RichNode[N](vnode)
  }

  /** Represents lack of a modifier */
  private def noModifier[N <: VNode]: Modifier[N] = {
    new Modifier[N] {
      // @TODO Should this apply a Null child instead?
      @inline def applyTo(vnode: N): Unit = ()
    }
  }

  def optionToModifier[T, N <: VNode](maybeModifier: Option[T])(implicit toModifier: T => Modifier[N]): Modifier[N] = {
    // @TODO[API][Performance] Implicitception – does this harm compile or runtime performance?
    maybeModifier match {
      case Some(modifier) => modifier
      case None => noModifier
    }
  }
}
