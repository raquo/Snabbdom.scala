package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.MouseEventCallback
import com.raquo.snabbdom.nodes.Node
import com.raquo.snabbdom.setters.EventProp

/**
  * Mouse Events: triggered by a mouse, or similar user actions.
  */
trait MouseEventProps[N <: Node[N]] { self: Builders[N] =>

  /**
    * The click event is raised when the user clicks on an element. The click
    * event will occur after the mousedown and mouseup events.
    *
    * MDN
    */
  lazy val onClick: EventProp[MouseEventCallback, N] = eventProp("click")

  /**
    * The dblclick event is fired when a pointing device button (usually a
    * mouse button) is clicked twice on a single element.
    *
    * MDN
    */
  lazy val onDblClick: EventProp[MouseEventCallback, N] = eventProp("dblclick")

  /**
    * Script to be run when an element is dragged
    */
  val onDrag: EventProp[MouseEventCallback, N] = eventProp("drag")

  /**
    * Script to be run at the end of a drag operation
    */
  lazy val onDragEnd: EventProp[MouseEventCallback, N] = eventProp("dragend")

  /**
    * Script to be run when an element has been dragged to a valid drop target
    */
  lazy val onDragEnter: EventProp[MouseEventCallback, N] = eventProp("dragenter")

  /**
    * Script to be run when an element leaves a valid drop target
    */
  lazy val onDragLeave: EventProp[MouseEventCallback, N] = eventProp("dragleave")

  /**
    * Script to be run when an element is being dragged over a valid drop target
    */
  lazy val onDragOver: EventProp[MouseEventCallback, N] = eventProp("dragover")

  /**
    * Script to be run at the start of a drag operation
    */
  lazy val onDragStart: EventProp[MouseEventCallback, N] = eventProp("dragstart")

  /**
    * Script to be run when dragged element is being dropped
    */
  lazy val onDrop: EventProp[MouseEventCallback, N] = eventProp("drop")

  /**
    * The mousedown event is raised when the user presses the mouse button.
    *
    * MDN
    */
  lazy val onMouseDown: EventProp[MouseEventCallback, N] = eventProp("mousedown")

  /**
    * The mousemove event is raised when the user moves the mouse.
    *
    * MDN
    */
  lazy val onMouseMove: EventProp[MouseEventCallback, N] = eventProp("mousemove")

  /**
    * The mouseout event is raised when the mouse leaves an element (e.g, when
    * the mouse moves off of an image in the web page, the mouseout event is
    * raised for that image element).
    *
    * MDN
    */
  lazy val onMouseOut: EventProp[MouseEventCallback, N] = eventProp("mouseout")

  /**
    * The mouseover event is raised when the user moves the mouse over a
    * particular element.
    *
    * MDN
    */
  lazy val onMouseOver: EventProp[MouseEventCallback, N] = eventProp("mouseover")

  /**
    * The mouseup event is raised when the user releases the mouse button.
    *
    * MDN
    */
  lazy val onMouseUp: EventProp[MouseEventCallback, N] = eventProp("mouseup")

  /**
    * Specifies the function to be called when the window is scrolled.
    *
    * MDN
    */
  lazy val onScroll: EventProp[MouseEventCallback, N] = eventProp("scroll")

  /**
    * Fires when the mouse wheel rolls up or down over an element
    */
  lazy val onWheel: EventProp[MouseEventCallback, N] = eventProp("wheel")
}
