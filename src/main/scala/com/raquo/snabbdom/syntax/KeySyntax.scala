package com.raquo.snabbdom.syntax

import com.raquo.snabbdom.keys.KeyKey
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.KeySetter

class KeySyntax[N <: Node[N, D], D <: NodeData[N, D]](val key: KeyKey) extends AnyVal {

  def := (value: String): KeySetter[N, D] = {
    new KeySetter[N, D](key, value)
  }
}
