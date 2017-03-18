package com.raquo.snabbdom

import com.raquo.snabbdom.nodes.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Represents a value that can be nested within a [[Node]]. This can be
  * another [[Modifier]], but can also be a CSS style or HTML attribute binding,
  * which will add itself to the node's attributes but not appear in the final
  * `children` list.
  */
trait Modifier[N <: Node[N]] {
  /**
    * Applies this modifier to the specified [[Node]], such that when
    * rendering is complete the effect of adding this modifier can be seen.
    */
  def applyTo(vnode: N): Unit
}
