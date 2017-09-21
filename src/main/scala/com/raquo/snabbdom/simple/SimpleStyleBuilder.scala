package com.raquo.snabbdom.simple

import com.raquo.domtypes
import com.raquo.domtypes.generic.keys.Style

trait SimpleStyleBuilder extends domtypes.generic.builders.StyleBuilder[SimpleStyleSetter, SimpleStringStyleSetter] {

  override def build[V](key: String, cssKey: String): Style[V] = {
    new Style(key, cssKey)
  }

  override def buildSetter[V](style: Style[V], value: V): SimpleStyleSetter[V] = {
    new SimpleStyleSetter(style, value)
  }

  override def buildStringSetter[V](style: Style[V], value: String): SimpleStringStyleSetter[V] = {
    new SimpleStringStyleSetter(style, value)
  }
}
