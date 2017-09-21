package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.builders.Tag
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}

class TagSyntax[N <: Node[N, D], D <: NodeData[N, D]](val tag: Tag[N]) extends AnyVal {

  def apply(modifiers: Modifier[N, D]*): N = {
    val element = tag.build()
    modifiers.foreach(_.applyTo(element))
    element
  }
}
