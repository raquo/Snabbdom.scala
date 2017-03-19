package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.EventProp

/**
  * Window Events
  */
trait WindowEventProps[N <: Node[N, D], D <: NodeData[N, D]] extends SharedEventProps[N, D] { self: Builders[N, D] =>

  /**
    * The load event fires at the end of the document loading process. At this
    * point, all of the objects in the document are in the DOM, and all the
    * images and sub-frames have finished loading.
    *
    * MDN
    */
  lazy val onLoad: EventProp[GenericEventCallback, N, D] = eventProp("onload")

  /**
    * Script to be run after the document is printed
    */
  lazy val onAfterPrint: EventProp[GenericEventCallback, N, D] = eventProp("onafterprint")

  /**
    * Script to be run before the document is printed
    */
  lazy val onBeforePrint: EventProp[GenericEventCallback, N, D] = eventProp("onbeforeprint")

  /**
    * Script to be run when the document is about to be unloaded
    */
  lazy val onBeforeUnload: EventProp[GenericEventCallback, N, D] = eventProp("onbeforeunload")

  /**
    * Script to be run when there has been changes to the anchor part of the a URL
    */
  lazy val onHashChange: EventProp[GenericEventCallback, N, D] = eventProp("onhashchange")

  /**
    * Script to be run when the message is triggered
    */
  lazy val onMessage: EventProp[GenericEventCallback, N, D] = eventProp("onmessage")

  /**
    * Script to be run when the browser starts to work offline
    */
  lazy val onOffline: EventProp[GenericEventCallback, N, D] = eventProp("onoffline")

  /**
    * Script to be run when the browser starts to work online
    */
  lazy val onOnline: EventProp[GenericEventCallback, N, D] = eventProp("ononline")

  /**
    * Script to be run when a user navigates away from a page
    */
  lazy val onPageHide: EventProp[GenericEventCallback, N, D] = eventProp("onpagehide")

  /**
    * Script to be run when a user navigates to a page
    */
  lazy val onPageShow: EventProp[GenericEventCallback, N, D] = eventProp("onpageshow")

  /**
    * Script to be run when the window's history changes
    */
  lazy val onPopState: EventProp[GenericEventCallback, N, D] = eventProp("onpopstate")

  /**
    * Fires when the browser window is resized
    */
  lazy val onResize: EventProp[GenericEventCallback, N, D] = eventProp("onresize")

  /**
    * Script to be run when a Web Storage area is updated
    */
  lazy val onStorage: EventProp[GenericEventCallback, N, D] = eventProp("onstorage")

  /**
    * Fires once a page has unloaded (or the browser window has been closed)
    */
  lazy val onUnload: EventProp[GenericEventCallback, N, D] = eventProp("onunload")
}
