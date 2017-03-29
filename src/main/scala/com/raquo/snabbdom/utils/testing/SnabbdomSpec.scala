package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom
import com.raquo.snabbdom.hooks.ModuleHooks
import com.raquo.snabbdom.{NativeModule, VNode, VNodeBuilders, VNodeData}
import com.raquo.snabbdom.utils.testing.matching.RuleImplicits
import org.scalatest.Suite

import scala.scalajs.js
import scala.scalajs.js.|

trait SnabbdomSpec
  extends MountSpec[VNode, VNodeData]
  with VNodeBuilders
  with RuleImplicits[VNode, VNodeData]
  with DomEventSimulatorSpec
{ this: Suite =>

  override val snabbdomModules: js.Array[NativeModule | ModuleHooks[VNode, VNodeData]] = snabbdom.modules
}
