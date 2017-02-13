package com.raquo.snabbdom.collections

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.{Attr, EventProp, Prop, Style}

import scala.scalajs.js

trait CollectionOps {

  @inline def attr[Value](key: String): Attr[Value] = {
    new Attr[Value](key)
  }

  @inline def eventProp[Value <: js.Function](key: String): EventProp[Value] = {
    new EventProp[Value](key)
  }

  @inline def prop[Value](key: String): Prop[Value] = {
    new Prop[Value](key)
  }

  @inline def style[Value](jsKey: String, cssKey: String): Style[Value] = {
    new Style[Value](jsKey, cssKey)
  }

  @inline def vnode(tagName: String): VNode = {
    new VNode(tagName)
  }
}
