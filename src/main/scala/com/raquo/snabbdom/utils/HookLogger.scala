package com.raquo.snabbdom.utils

import com.raquo.snabbdom.nodes.{Node, NodeData}
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
    logDOMNode: Boolean = false,
    logNode: Boolean = false,
    logDOMNodeFn: Option[dom.Node => Any] = None,
    logNodeFn: Option[N => Any] = None
  ): NodeHooks[N, D] = {

    // @TODO[Convenience] Provide an easy way to add HookLogger to an existing VNode
    // @TODO[Convenience] Optionally propagate hook logger to new nodes

    new NodeHooks[N, D] {
      if (enabled) {
        addInitHook { (node: N) =>
          logger(prefix + ":hook:init")
          log(logger, "node:", node)
        }
        addCreateHook { (emptyNode: js.Object, node: N) =>
          logger(prefix + ":hook:create")
          log(logger, "node:", node)
        }
        addInsertHook { (node: N) =>
          logger(prefix + ":hook:insert")
          log(logger, "node:", node)
        }
        addPrePatchHook { (oldNode: N, node: N) =>
          logger(prefix + ":hook:prePatch")
          log(logger, "old node:", oldNode)
          log(logger, "node:", node)
        }
        addUpdateHook { (oldNode: N, node: N) =>
          logger(prefix + ":hook:udpate")
          log(logger, "old node:", oldNode)
          log(logger, "node:", node)
        }
        addPostPatchHook { (oldNode: N, node: N) =>
          logger(prefix + ":hook:postPatch")
          log(logger, "old node:", oldNode)
          log(logger, "node:", node)
        }
        addDestroyHook { (node: N) =>
          logger(prefix + ":hook:destroy")
          log(logger, "node:", node)
        }
        addRemoveHook { (node: N, removeNode: js.Function0[Any]) =>
          logger(prefix + ":hook:remove")
          log(logger, "node:", node)
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
    node: N,
    logDOMNode: Boolean = false,
    logNode: Boolean = false,
    logDOMNodeFn: Option[dom.Node => Any] = None,
    logNodeFn: Option[N => Any] = None
  ): Unit = {
    if (message.nonEmpty && (logDOMNode || logNode || logDOMNodeFn.isDefined || logNodeFn.isDefined)) {
      logger(message)
    }
    if (logDOMNode) {
      logger(node.elm)
    }
    logDOMNodeFn.foreach { domNodeFn =>
      node.elm.toOption.foreach(elm =>
        logger(domNodeFn(elm))
      )
    }
    if (logNode) {
      logger(node)
    }
    logNodeFn.foreach { nodeFn =>
      logger(nodeFn(node))
    }
  }

  // @TODO this should in some util
  @inline def consoleLog(msg: Any): Unit = {
    dom.console.log(msg.asInstanceOf[js.Any])
  }
}
