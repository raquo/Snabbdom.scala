package com.raquo.snabbdom.simple

import com.raquo.domtypes.generic.keys.Style
import com.raquo.snabbdom.setters.StringStyleSetter

class SimpleStringStyleSetter(key: Style[_], value: String)
  extends StringStyleSetter[VNode, VNodeData](key, value)
