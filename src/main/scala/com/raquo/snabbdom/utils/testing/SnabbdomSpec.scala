package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.utils.testing.matching.RuleImplicits
import org.scalatest.Suite

trait SnabbdomSpec
  extends MountSpec
  with RuleImplicits
  with DomEventSimulatorSpec
  with UtilSpec { this: Suite => }
