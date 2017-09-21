package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.{StringStyleSetter, StyleSetter}

class StyleSyntax[V, N <: Node[N, D], D <: NodeData[N, D]](val style: Style[V]) extends AnyVal {

  def := (value: V): StyleSetter[V, N, D] = {
    new StyleSetter[V, N, D](style, value)
  }

  def := (value: String): StringStyleSetter[V, N, D] = {
    new StringStyleSetter[V, N, D](style, value)
  }
}
