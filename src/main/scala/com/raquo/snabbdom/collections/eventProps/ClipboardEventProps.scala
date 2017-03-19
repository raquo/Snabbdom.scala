package com.raquo.snabbdom.collections.eventProps

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.GenericEventCallback
import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.setters.EventProp

/**
  * Clipboard Events
  */
trait ClipboardEventProps[N <: Node[N, D], D <: NodeData[N, D]] { self: Builders[N, D] =>

  /**
    * Fires when the user copies the content of an element
    */
  lazy val onCopy: EventProp[GenericEventCallback, N, D] = eventProp("copy")

  /**
    * Fires when the user cuts the content of an element
    */
  lazy val onCut: EventProp[GenericEventCallback, N, D] = eventProp("cut")

  /**
    * Fires when the user pastes some content in an element
    */
  lazy val onPaste: EventProp[GenericEventCallback, N, D] = eventProp("paste")
}
