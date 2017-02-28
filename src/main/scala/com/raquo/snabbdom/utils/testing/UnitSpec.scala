package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.utils.testing.matching.RuleImplicits
import org.scalatest.{FunSpec, Matchers}

trait UnitSpec extends FunSpec
  with Matchers
  with MountSpec
  with RuleImplicits
  with DomEventSimulatorSpec
  with UtilSpec
