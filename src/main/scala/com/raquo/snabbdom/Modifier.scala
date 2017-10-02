package com.raquo.snabbdom

import com.raquo.domtypes
import com.raquo.snabbdom.nodes.{Node, NodeData}

/**
  * Represents an operation that has a side effect on a Node.
  *
  * For example: `attrs.href := "http://example.com"` is a Modifier that sets an attribute to a specific value.
  */
trait Modifier[N <: Node[N, D], D <: NodeData[N, D]] extends domtypes.generic.Modifier[N]
