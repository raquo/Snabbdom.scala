package com.raquo.snabbdom.collections

import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.setters.{Attr, EventProp, Prop, Style}

import scala.scalajs.js

// @TODO[Api] Do we need type params for other stuff? So far we only wanted to customize the nodes...
trait Builders[N <: VNode] {

  @inline def attr[Value](key: String): Attr[Value, N] = {
    new Attr[Value, N](key)
  }

  @inline def eventProp[Value <: js.Function](key: String): EventProp[Value, N] = {
    new EventProp[Value, N](key)
  }

  @inline def prop[Value](key: String): Prop[Value, N] = {
    new Prop[Value, N](key)
  }

  // @TODO[Integrity] we still use `new Style` in some places to support additional traits e.g. `with MarginAuto`
  @inline def style[Value](jsKey: String, cssKey: String): Style[Value, N] = {
    new Style[Value, N](jsKey, cssKey)
  }

  /** We don't actually have an [[N]]-agnostic implementation of this. See [[VNodeBuilders]] */
  @inline def vnode(tagName: js.UndefOr[String]): N
}
