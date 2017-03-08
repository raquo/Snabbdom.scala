package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.setters.EventProp

/**
  * Clipboard Events
  */
trait ClipboardEventProps { self: Builders[_] =>

  /**
    * Fires when the user copies the content of an element
    */
  lazy val onCopy: EventProp[GenericEventCallback] = eventProp("copy")

  /**
    * Fires when the user cuts the content of an element
    */
  lazy val onCut: EventProp[GenericEventCallback] = eventProp("cut")

  /**
    * Fires when the user pastes some content in an element
    */
  lazy val onPaste: EventProp[GenericEventCallback] = eventProp("paste")
}
