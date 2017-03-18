package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders

// @TODO[API] This is ugly. All these should be plain implicits, but I can't get Scala to pick them up

object Conversions {

  // @TODO add similar conversions for numbers and nulls – see what snabbdom supports
  def textToChildNode[N <: Node[N]](text: String)(implicit builders: Builders[N]): ChildNode[N] = {
    new ChildNode(Node.createTextNode[N](text))
  }

  def nodeToChildNode[N <: Node[N]](vnode: N)(implicit builders: Builders[N]): ChildNode[N] = {
    new ChildNode(vnode)
  }

  def toIterableNode[N <: Node[N]](modifiers: Iterable[Modifier[N]]): IterableNode[N] = {
    new IterableNode[N](modifiers)
  }

  /** Represents lack of a modifier */
  private def noModifier[N <: Node[N]]: Modifier[N] = {
    new Modifier[N] {
      // @TODO Should this apply a Null child instead?
      @inline def applyTo(vnode: N): Unit = ()
    }
  }

  def optionToModifier[T, N <: Node[N]](maybeModifier: Option[T])(implicit toModifier: T => Modifier[N]): Modifier[N] = {
    // @TODO[API][Performance] Implicitception – does this harm compile or runtime performance?
    maybeModifier match {
      case Some(modifier) => modifier
      case None => noModifier
    }
  }
}
