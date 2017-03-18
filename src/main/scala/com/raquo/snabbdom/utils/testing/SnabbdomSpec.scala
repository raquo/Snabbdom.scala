package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.{VNodeBuilders, VNode}
import com.raquo.snabbdom.utils.testing.matching.RuleImplicits
import org.scalatest.Suite

trait SnabbdomSpec
  extends MountSpec[VNode]
  with VNodeBuilders
  with RuleImplicits[VNode]
  with DomEventSimulatorSpec
  with UtilSpec { this: Suite => }
