package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.setters.StringStyleSetter

class SimpleStringStyleSetter[V](key: Style[V], value: String)
  extends StringStyleSetter[V, VNode, VNodeData](key, value)
