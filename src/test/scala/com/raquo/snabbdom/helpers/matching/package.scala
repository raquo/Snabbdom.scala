package com.raquo.snabbdom.helpers

import org.scalajs.dom

package object matching {

  type MaybeError = Option[String]

  type ErrorList = List[String]

  type Check = dom.Element => MaybeError
}
