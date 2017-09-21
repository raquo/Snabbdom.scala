package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.builders.TagBuilder

trait SimpleTagBuilder extends TagBuilder[SimpleTag, VNode] {

  @inline override def build[Ref <: VNode](
    tagName: String,
    void: Boolean
  ): SimpleTag[Ref] = {
    new SimpleTag(tagName, void)
  }
}
