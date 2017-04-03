package com.raquo.snabbdom.nodes

import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.collections.Builders

// @TODO[API] This is ugly. All these should be plain implicits, but I can't get Scala to pick them up

object Conversions {

  // @TODO add similar conversions for numbers and nulls – see what snabbdom supports
  def textToChildNode[N <: Node[N, D], D <: NodeData[N, D]](
    text: String
  )(
    implicit builders: Builders[N, D]
  ): ChildNode[N, D] = {
    new ChildNode[N, D](builders.textNode(text))
  }

  def nodeToChildNode[N <: Node[N, D], D <: NodeData[N, D]](
    node: N
  )(
    implicit builders: Builders[N, D]
  ): ChildNode[N, D] = {
    new ChildNode[N, D](node)
  }

  def toIterableNode[N <: Node[N, D], D <: NodeData[N, D]](
    modifiers: Iterable[Modifier[N, D]]
  ): IterableNode[N, D] = {
    new IterableNode[N, D](modifiers)
  }

  /** Represents lack of a modifier */
  private def noModifier[N <: Node[N, D], D <: NodeData[N, D]]: Modifier[N, D] = {
    new Modifier[N, D] {
      // @TODO Should this apply a Null child instead?
      @inline def applyTo(node: N): Unit = ()
    }
  }

  def optionToModifier[T, N <: Node[N, D], D <: NodeData[N, D]](maybeModifier: Option[T])(implicit toModifier: T => Modifier[N, D]): Modifier[N, D] = {
    // @TODO[API][Performance] Implicitception – does this harm compile or runtime performance?
    maybeModifier match {
      case Some(modifier) => modifier
      case None => noModifier
    }
  }
}
