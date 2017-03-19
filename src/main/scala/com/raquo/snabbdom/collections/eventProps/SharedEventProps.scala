package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.EventCallback
import com.raquo.snabbdom.setters.EventProp
import org.scalajs.dom.ErrorEvent

trait SharedEventProps[N <: Node[N, D], D <: NodeData[N, D]] { self: Builders[N, D] =>

  /**
    * Script to be run when an error occurs when the file is being loaded
    */
  lazy val onerror: EventProp[EventCallback[ErrorEvent], N, D] = eventProp("onerror")
}
