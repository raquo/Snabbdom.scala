package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.keys.Prop
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.PropSetter

class PropSyntax[V, N <: Node[N, D], D <: NodeData[N, D]](val prop: Prop[V]) extends AnyVal {

  def := (value: V): PropSetter[V, N, D] = {
    new PropSetter[V, N, D](prop, value)
  }
}
