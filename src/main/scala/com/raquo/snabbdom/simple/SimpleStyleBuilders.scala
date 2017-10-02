package com.raquo.snabbdom.simple

import com.raquo.domtypes
import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.Modifier

trait SimpleStyleBuilders extends domtypes.generic.builders.StyleBuilders[Modifier[VNode, VNodeData]] {

  @inline override def build[V](key: String, cssKey: String): Style[V] = {
    new Style(key, cssKey)
  }

  @inline override def buildIntStyleSetter(style: Style[Int], value: Int): SimpleStyleSetter[Int] = {
    new SimpleStyleSetter(style, value)
  }

  @inline override def buildDoubleStyleSetter(style: Style[Double], value: Double): SimpleStyleSetter[Double] = {
    new SimpleStyleSetter(style, value)
  }

  @inline override def buildStringStyleSetter(style: Style[_], value: String): SimpleStringStyleSetter = {
    new SimpleStringStyleSetter(style, value)
  }
}
