package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.CollectionOps
import com.raquo.snabbdom.EventCallback
import com.raquo.snabbdom.setters.EventProp
import org.scalajs.dom.ErrorEvent

trait SharedEventProps extends CollectionOps {

  /**
    * Script to be run when an error occurs when the file is being loaded
    */
  lazy val onerror: EventProp[EventCallback[ErrorEvent]] = eventProp("onerror")
}
