package com.raquo.snabbdom.utils.testing

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.utils.testing.matching.MountOps
import org.scalatest.{BeforeAndAfterEach, Suite}

trait MountSpec[N <: Node[N, D], D <: NodeData[N, D]] extends BeforeAndAfterEach with MountOps[N, D] {
  this: Suite with Builders[N, D] =>

  override def doAssert(condition: Boolean, message: String): Unit = assert(condition, message)

  override def doFail(message: String): Nothing = fail(message)

  override def beforeEach(): Unit = {
    super.beforeEach()
    resetDocument()
  }

  override def afterEach(): Unit = {
    super.afterEach()
    clearDocument()
  }
}
