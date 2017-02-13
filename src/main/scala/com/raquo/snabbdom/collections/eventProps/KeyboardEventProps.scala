package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.EventCallback
import com.raquo.snabbdom.collections.CollectionOps
import com.raquo.snabbdom.setters.EventProp
import org.scalajs.dom.KeyboardEvent

/**
  * Keyboard Events - triggered by user action son the keyboard or similar user actions
  */
trait KeyboardEventProps extends CollectionOps {

  /**
    * The keydown event is raised when the user presses a keyboard key.
    *
    * MDN
    */
  lazy val onKeyDown: EventProp[EventCallback[KeyboardEvent]] = eventProp("keydown")

  /**
    * The keyup event is raised when the user releases a key that's been pressed.
    *
    * MDN
    */
  lazy val onKeyUp: EventProp[EventCallback[KeyboardEvent]] = eventProp("keyup")

  /**
    * The keypress event should be raised when the user presses a key on the keyboard.
    * However, not all browsers fire keypress events for certain keys.
    *
    * Webkit-based browsers (Google Chrome and Safari, for example) do not fire keypress events on the arrow keys.
    * Firefox does not fire keypress events on modifier keys like SHIFT.
    *
    * MDN
    */
  lazy val onKeyPress: EventProp[EventCallback[KeyboardEvent]] = eventProp("keypress")
}
