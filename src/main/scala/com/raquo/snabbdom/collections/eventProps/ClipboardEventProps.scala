package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.{GenericEventCallback, VNode}
import com.raquo.snabbdom.setters.EventProp

/**
  * Clipboard Events
  */
trait ClipboardEventProps[N <: VNode] { self: Builders[N] =>

  /**
    * Fires when the user copies the content of an element
    */
  lazy val onCopy: EventProp[GenericEventCallback, N] = eventProp("copy")

  /**
    * Fires when the user cuts the content of an element
    */
  lazy val onCut: EventProp[GenericEventCallback, N] = eventProp("cut")

  /**
    * Fires when the user pastes some content in an element
    */
  lazy val onPaste: EventProp[GenericEventCallback, N] = eventProp("paste")
}
