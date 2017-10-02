package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.StringStyleSetter

class StringStyleSyntax[N <: Node[N, D], D <: NodeData[N, D]](val style: Style[String]) extends AnyVal {

  def := (value: String): StringStyleSetter[N, D] = {
    new StringStyleSetter[N, D](style, value)
  }
}
