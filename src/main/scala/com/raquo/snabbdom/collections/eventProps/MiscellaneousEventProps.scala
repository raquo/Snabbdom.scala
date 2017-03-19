package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.EventProp

/**
  * Miscellaneous Events
  */
trait MiscellaneousEventProps[N <: Node[N, D], D <: NodeData[N, D]] extends SharedEventProps[N, D] { self: Builders[N, D] =>

  /**
    * Fires when a <menu> element is shown as a context menu
    */
  lazy val onShow: EventProp[GenericEventCallback, N, D] = eventProp("show")
  /**
    * Fires when the user opens or closes the <details> element
    */
  lazy val onToggle: EventProp[GenericEventCallback, N, D] = eventProp("toggle")
}
