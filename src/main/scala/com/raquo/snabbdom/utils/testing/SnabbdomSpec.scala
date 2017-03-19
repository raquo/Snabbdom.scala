package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.{VNode, VNodeBuilders, VNodeData}
import com.raquo.snabbdom.utils.testing.matching.RuleImplicits
import org.scalatest.Suite

trait SnabbdomSpec
  extends MountSpec[VNode, VNodeData]
  with VNodeBuilders
  with RuleImplicits[VNode, VNodeData]
  with DomEventSimulatorSpec { this: Suite => }
