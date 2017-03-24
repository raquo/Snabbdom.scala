package com.raquo.snabbdom.utils

import com.raquo.snabbdom.nodes.{Node, NodeData}
import com.raquo.snabbdom.VNode
import com.raquo.snabbdom.hooks.NodeHooks
import org.scalajs.dom

import scala.scalajs.js
import scala.util.Random

object HookLogger {

  def apply[N <: Node[N, D], D <: NodeData[N, D]](
    callRemoveNode: Boolean,
    enabled: Boolean = true,
    prefix: String = Random.nextInt(99).toString,
    logger: Any => Unit = consoleLog,
    logNode: Boolean = false,
    logVNode: Boolean = false,
    logNodeFn: Option[dom.Node => Any] = None,
    logVNodeFn: Option[VNode => Any] = None
  ): NodeHooks[N, D] = {

    // @TODO[Convenience] Provide an easy way to add HookLogger to an existing VNode
    // @TODO[Convenience] Optionally propagate hook logger to new nodes

    new NodeHooks[N, D] {
      if (enabled) {
        addInitHook { (vnode: N) =>
          logger(prefix + ":hook:init")
          log(logger, "node:", vnode)
        }
        addCreateHook { (emptyVNode: N, vnode: N) =>
          logger(prefix + ":hook:create")
          log(logger, "empty node:", emptyVNode)
          log(logger, "node:", vnode)
        }
        addInsertHook { (vnode: N) =>
          logger(prefix + ":hook:insert")
          log(logger, "node:", vnode)
        }
        addPrePatchHook { (oldVNode: N, vnode: N) =>
          logger(prefix + ":hook:prePatch")
          log(logger, "old node:", oldVNode)
          log(logger, "node:", vnode)
        }
        addUpdateHook { (oldVNode: N, vnode: N) =>
          logger(prefix + ":hook:udpate")
          log(logger, "old node:", oldVNode)
          log(logger, "node:", vnode)
        }
        addPostPatchHook { (oldVNode: N, vnode: N) =>
          logger(prefix + ":hook:postPatch")
          log(logger, "old node:", oldVNode)
          log(logger, "node:", vnode)
        }
        addDestroyHook { (vnode: N) =>
          logger(prefix + ":hook:destroy")
          log(logger, "node:", vnode)
        }
        addRemoveHook { (vnode: N, removeNode: js.Function0[Any]) =>
          logger(prefix + ":hook:remove")
          log(logger, "node:", vnode)
          if (callRemoveNode) {
            removeNode()
          }
        }
      }
    }
  }

  // @TODO[API,Sanity] Use existential types more often to cut down on irrelevant types
  def log[N <: Node[N, _]](
    logger: Any => Unit,
    message: String,
    vnode: N,
    logNode: Boolean = false,
    logVNode: Boolean = false,
    logNodeFn: Option[dom.Node => Any] = None,
    logVNodeFn: Option[N => Any] = None
  ): Unit = {
    if (message.nonEmpty && (logNode || logVNode || logNodeFn.isDefined || logVNodeFn.isDefined)) {
      logger(message)
    }
    if (logNode) {
      logger(vnode.elm)
    }
    logNodeFn.foreach { nodeFn =>
      vnode.elm.toOption.foreach(elm =>
        logger(nodeFn(elm))
      )
    }
    if (logVNode) {
      logger(vnode)
    }
    logVNodeFn.foreach { vnodeFn =>
      logger(vnodeFn(vnode))
    }
  }

  // @TODO this should in some util
  @inline def consoleLog(msg: Any): Unit = {
    dom.console.log(msg.asInstanceOf[js.Any])
  }
}
