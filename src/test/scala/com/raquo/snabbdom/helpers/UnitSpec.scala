package com.raquo.snabbdom.helpers

import com.raquo.snabbdom.helpers.matching.RuleImplicits
import org.scalatest.{FunSpec, Matchers}

trait UnitSpec extends FunSpec
  with Matchers
  with MountSpec
  with RuleImplicits
  with DomEventSimulatorSpec
  with RandomSpec
