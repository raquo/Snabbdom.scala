package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.{GenericEventCallback, VNode}
import com.raquo.snabbdom.setters.EventProp

trait FormEventProps[N <: VNode] { self: Builders[N] =>

  /**
    * The blur event is raised when an element loses focus.
    *
    * MDN
    */
  lazy val onBlur: EventProp[GenericEventCallback, N] = eventProp("blur")

  /**
    * The change event is fired for input, select, and textarea elements
    * when a change to the element's value is committed by the user.
    *
    * MDN
    */
  lazy val onChange: EventProp[GenericEventCallback, N] = eventProp("change")

  /**
    * The focus event is raised when the user sets focus on the given element.
    *
    * MDN
    */
  lazy val onFocus: EventProp[GenericEventCallback, N] = eventProp("focus")

  /**
    * The select event only fires when text inside a text input or textarea is
    * selected. The event is fired after the text has been selected.
    *
    * MDN
    */
  lazy val onSelect: EventProp[GenericEventCallback, N] = eventProp("select")

  /**
    * The submit event is raised when the user clicks a submit button in a form
    * (<input type="submit"/>).
    *
    * MDN
    */
  lazy val onSubmit: EventProp[GenericEventCallback, N] = eventProp("submit")

  /**
    * The reset event is fired when a form is reset.
    *
    * MDN
    */
  lazy val onReset: EventProp[GenericEventCallback, N] = eventProp("reset")

  /**
    * Script to be run when a context menu is triggered
    */
  lazy val onContextMenu: EventProp[GenericEventCallback, N] = eventProp("contextmenu")

  /**
    * Script to be run when an element gets user input
    */
  lazy val onInput: EventProp[GenericEventCallback, N] = eventProp("input")

  /**
    * Script to be run when an element is invalid
    */
  lazy val onInvalid: EventProp[GenericEventCallback, N] = eventProp("invalid")

  /**
    * Fires when the user writes something in a search field (for <input="search">)
    */
  lazy val onSearch: EventProp[GenericEventCallback, N] = eventProp("search")
}
