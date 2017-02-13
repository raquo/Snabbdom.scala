package com.raquo.interfaces

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// @TODO[Elegance] Extract this out of my snabbdom package, or don't use it at all

@js.native
@JSImport("object-assign", JSImport.Default)
object objectAssign extends js.Object {
  def apply(obj: js.Object*): js.Object = js.native
  def apply[V](obj: js.Dictionary[V]*): js.Dictionary[V] = js.native
}
