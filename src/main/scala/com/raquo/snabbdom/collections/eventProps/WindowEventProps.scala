package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.setters.Prop

/**
  * Window Events
  *
  */
trait WindowEventProps extends SharedEventProps { self: Builders[_] =>

  /**
    * The load event fires at the end of the document loading process. At this
    * point, all of the objects in the document are in the DOM, and all the
    * images and sub-frames have finished loading.
    *
    * MDN
    */
  lazy val onLoad: Prop[GenericEventCallback] = prop("onload")

  /**
    * Script to be run after the document is printed
    */
  lazy val onAfterPrint: Prop[GenericEventCallback] = prop("onafterprint")

  /**
    * Script to be run before the document is printed
    */
  lazy val onBeforePrint: Prop[GenericEventCallback] = prop("onbeforeprint")

  /**
    * Script to be run when the document is about to be unloaded
    */
  lazy val onBeforeUnload: Prop[GenericEventCallback] = prop("onbeforeunload")

  /**
    * Script to be run when there has been changes to the anchor part of the a URL
    */
  lazy val onHashChange: Prop[GenericEventCallback] = prop("onhashchange")

  /**
    * Script to be run when the message is triggered
    */
  lazy val onMessage: Prop[GenericEventCallback] = prop("onmessage")

  /**
    * Script to be run when the browser starts to work offline
    */
  lazy val onOffline: Prop[GenericEventCallback] = prop("onoffline")

  /**
    * Script to be run when the browser starts to work online
    */
  lazy val onOnline: Prop[GenericEventCallback] = prop("ononline")

  /**
    * Script to be run when a user navigates away from a page
    */
  lazy val onPageHide: Prop[GenericEventCallback] = prop("onpagehide")

  /**
    * Script to be run when a user navigates to a page
    */
  lazy val onPageShow: Prop[GenericEventCallback] = prop("onpageshow")

  /**
    * Script to be run when the window's history changes
    */
  lazy val onPopState: Prop[GenericEventCallback] = prop("onpopstate")

  /**
    * Fires when the browser window is resized
    */
  lazy val onResize: Prop[GenericEventCallback] = prop("onresize")

  /**
    * Script to be run when a Web Storage area is updated
    */
  lazy val onStorage: Prop[GenericEventCallback] = prop("onstorage")

  /**
    * Fires once a page has unloaded (or the browser window has been closed)
    */
  lazy val onUnload: Prop[GenericEventCallback] = prop("onunload")
}
