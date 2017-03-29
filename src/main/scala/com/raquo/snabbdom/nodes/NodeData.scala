package com.raquo.snabbdom.nodes

import com.raquo.interfaces.objectAssign
import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.hooks.NodeHooks

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

@ScalaJSDefined
class NodeData[N <: Node[N, D], D <: NodeData[N, D]](
  implicit builders: Builders[N, D]
) extends js.Object { self: D =>

  var attrs: js.UndefOr[js.Dictionary[Boolean | String]] = js.undefined

  var on: js.UndefOr[js.Dictionary[js.Function]] = js.undefined

  var props: js.UndefOr[js.Dictionary[Any]] = js.undefined

  @JSName("style")
  var styles: js.UndefOr[js.Dictionary[Any]] = js.undefined

  @JSName("hook")
  var hooks: js.UndefOr[NodeHooks[N, D]] = js.undefined

  @JSName("__scala_copy")
  def copy(): D = {
    val newData = builders.nodeData()
    attrs.foreach { _attrs =>
      newData.attrs = objectAssign(js.Dictionary[Boolean | String](), _attrs)
    }
    on.foreach { _on =>
      newData.on = objectAssign(js.Dictionary[js.Function](), _on)
    }
    props.foreach { _props =>
      newData.props = objectAssign(js.Dictionary[Any](), _props)
    }
    styles.foreach { _styles =>
      newData.styles = objectAssign(js.Dictionary[Any](), _styles)
    }
    hooks.foreach { _hooks =>
      newData.hooks = _hooks.copy()
    }
    newData
  }
}

