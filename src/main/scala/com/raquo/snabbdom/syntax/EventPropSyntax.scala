package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.keys.EventProp
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.EventPropSetter
import org.scalajs.dom

class EventPropSyntax[Ev <: dom.Event, N <: Node[N, D], D <: NodeData[N, D]](val eventProp: EventProp[Ev]) extends AnyVal {

  def := (value: Ev => Unit): EventPropSetter[Ev, N, D] = {
    new EventPropSetter[Ev, N, D](eventProp, value)
  }

  // @TODO[Performance] Check how much function wrapping is happening here (there's also "value _" in user code)
  def := (value: () => Unit): EventPropSetter[Ev, N, D] = {
    new EventPropSetter[Ev, N, D](eventProp, (_: Ev) => value())
  }
}

