package com.raquo.snabbdom.collections

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.{Attr, EventProp, Prop, Style}

import scala.scalajs.js

trait Builders {

  @inline def attr[Value](key: String): Attr[Value] = {
    new Attr[Value](key)
  }

  @inline def eventProp[Value <: js.Function](key: String): EventProp[Value] = {
    new EventProp[Value](key)
  }

  @inline def prop[Value](key: String): Prop[Value] = {
    new Prop[Value](key)
  }

  // @TODO[Integrity] we still use `new Style` in some places to support additional traits e.g. `with MarginAuto`
  @inline def style[Value](jsKey: String, cssKey: String): Style[Value] = {
    new Style[Value](jsKey, cssKey)
  }

  @inline def vnode(tagName: String): VNode = {
    new VNode(tagName)
  }
}
