package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.builders.Tag

/** [[Ref]] type param is ignored in Snabbdom, it is only here for compatibility
  * with Scala DOM Types API where it provides distinction between various
  * HTML element types
  */
class SimpleTag[+Ref] (
  override val tagName: String,
  override val void: Boolean = false
) extends Tag[VNode] {

  override def build(): VNode = new VNode(tagName)
}
