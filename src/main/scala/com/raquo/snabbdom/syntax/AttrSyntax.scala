package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.keys.Attr
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.AttrSetter

class AttrSyntax[V, N <: Node[N, D], D <: NodeData[N, D]](val attr: Attr[V]) extends AnyVal {

  def := (value: V): AttrSetter[V, N, D] = {
    new AttrSetter[V, N, D](attr, value)
  }
}
