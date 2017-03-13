package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.{EventCallback, VNode}
import com.raquo.snabbdom.setters.EventProp
import org.scalajs.dom.ErrorEvent

trait SharedEventProps[N <: VNode] { self: Builders[N] =>

  /**
    * Script to be run when an error occurs when the file is being loaded
    */
  lazy val onerror: EventProp[EventCallback[ErrorEvent], N] = eventProp("onerror")
}
