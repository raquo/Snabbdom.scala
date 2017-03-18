package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.Node
import com.raquo.snabbdom.setters.EventProp

/**
  * Window Events
  */
trait WindowEventProps[N <: Node[N]] extends SharedEventProps[N] { self: Builders[N] =>

  /**
    * The load event fires at the end of the document loading process. At this
    * point, all of the objects in the document are in the DOM, and all the
    * images and sub-frames have finished loading.
    *
    * MDN
    */
  lazy val onLoad: EventProp[GenericEventCallback, N] = eventProp("onload")

  /**
    * Script to be run after the document is printed
    */
  lazy val onAfterPrint: EventProp[GenericEventCallback, N] = eventProp("onafterprint")

  /**
    * Script to be run before the document is printed
    */
  lazy val onBeforePrint: EventProp[GenericEventCallback, N] = eventProp("onbeforeprint")

  /**
    * Script to be run when the document is about to be unloaded
    */
  lazy val onBeforeUnload: EventProp[GenericEventCallback, N] = eventProp("onbeforeunload")

  /**
    * Script to be run when there has been changes to the anchor part of the a URL
    */
  lazy val onHashChange: EventProp[GenericEventCallback, N] = eventProp("onhashchange")

  /**
    * Script to be run when the message is triggered
    */
  lazy val onMessage: EventProp[GenericEventCallback, N] = eventProp("onmessage")

  /**
    * Script to be run when the browser starts to work offline
    */
  lazy val onOffline: EventProp[GenericEventCallback, N] = eventProp("onoffline")

  /**
    * Script to be run when the browser starts to work online
    */
  lazy val onOnline: EventProp[GenericEventCallback, N] = eventProp("ononline")

  /**
    * Script to be run when a user navigates away from a page
    */
  lazy val onPageHide: EventProp[GenericEventCallback, N] = eventProp("onpagehide")

  /**
    * Script to be run when a user navigates to a page
    */
  lazy val onPageShow: EventProp[GenericEventCallback, N] = eventProp("onpageshow")

  /**
    * Script to be run when the window's history changes
    */
  lazy val onPopState: EventProp[GenericEventCallback, N] = eventProp("onpopstate")

  /**
    * Fires when the browser window is resized
    */
  lazy val onResize: EventProp[GenericEventCallback, N] = eventProp("onresize")

  /**
    * Script to be run when a Web Storage area is updated
    */
  lazy val onStorage: EventProp[GenericEventCallback, N] = eventProp("onstorage")

  /**
    * Fires once a page has unloaded (or the browser window has been closed)
    */
  lazy val onUnload: EventProp[GenericEventCallback, N] = eventProp("onunload")
}
