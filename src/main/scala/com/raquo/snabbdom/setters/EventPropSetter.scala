package com.raquo.snabbdom.setters

import com.raquo.domtypes.generic.keys.EventProp
import com.raquo.snabbdom.Modifier
import com.raquo.snabbdom.nodes.{Node, NodeData}
import org.scalajs.dom

import scala.scalajs.js

class EventPropSetter[Ev <: dom.Event, N <: Node[N, D], D <: NodeData[N, D]](
  val key: EventProp[Ev],
  val value: js.Function1[Ev, Unit]
) extends Modifier[N, D] {

  override def apply(node: N): Unit = {
    if (node.data.on.isEmpty) {
      node.data.on = js.Dictionary[js.Function](key.name -> value)
    } else {
      node.data.on.get.update(key.name, value)
    }
  }
}
