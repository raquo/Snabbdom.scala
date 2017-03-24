package com.raquo.snabbdom

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait NativeModule extends js.Object

@JSImport("snabbdom/modules/attributes.js", JSImport.Default)
@js.native
object AttrsModule extends NativeModule

@JSImport("snabbdom/modules/eventlisteners.js", JSImport.Default)
@js.native
object EventsModule extends NativeModule

@JSImport("snabbdom/modules/props.js", JSImport.Default)
@js.native
object PropsModule extends NativeModule

@JSImport("snabbdom/modules/style.js", JSImport.Default)
@js.native
object StyleModule extends NativeModule
