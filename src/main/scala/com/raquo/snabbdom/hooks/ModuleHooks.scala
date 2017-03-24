package com.raquo.snabbdom.hooks

import com.raquo.snabbdom.nodes.{Node, NodeData}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class ModuleHooks[N <: Node[N, D], D <: NodeData[N, D]] extends CommonHooks[N, D] { self =>

  type RawPreHook = js.Function0[Any]

  type RawPostHook = js.Function0[Any]

  /** the patch process begins - called right in the beginning of patch() */
  var pre: js.UndefOr[RawPreHook] = js.undefined

  /** the patch process is done - called right at the end of patch() */
  var post: js.UndefOr[RawPostHook] = js.undefined

  def addPreHook(hook: () => Any): this.type = {
    pre = js.defined(
      if (pre.isDefined) {
        val oldHook = pre.get
        () => {
          oldHook()
          hook()
        }
      } else {
        hook
      }
    )
    this
  }

  def addPostHook(hook: () => Any): this.type = {
    post = js.defined(
      if (post.isDefined) {
        val oldHook = post.get
        () => {
          oldHook()
          hook()
        }
      } else {
        hook
      }
    )
    this
  }
}
