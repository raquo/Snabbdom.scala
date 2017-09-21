package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.setters.StyleSetter

class SimpleStyleSetter[V](key: Style[V], value: V)
  extends StyleSetter[V, VNode, VNodeData](key, value)
