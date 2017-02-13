package com.raquo.snabbdom.nodes

import com.raquo.interfaces.objectAssign
import com.raquo.snabbdom.Children

import scala.scalajs.js
import scala.scalajs.js.|

object VNodeOps {

  def copy(vnode: VNode): VNode = {
    // @TODO[NOW] Replace with two-level object-assign
    val newNode = new VNode(tagName = vnode.sel)
    newNode.sel = vnode.sel
    newNode.data = copyData(vnode.data)
    vnode.elm.foreach(elm => newNode.elm = elm)
    vnode.key.foreach(key => newNode.key = key)
    vnode.text.foreach(text => newNode.text = text)
    vnode.children.foreach(children => newNode.children = VNodeOps.copyChildren(children))
    newNode
  }

  def copyData(data: VNodeData): VNodeData = {
    val newData = new VNodeData {}
    data.attrs.foreach { attrs =>
      newData.attrs = objectAssign(js.Dictionary[Boolean | String](), attrs)
    }
    data.on.foreach { on =>
      newData.on = objectAssign(js.Dictionary[js.Function](), on)
    }
    data.props.foreach { props =>
      newData.props = objectAssign(js.Dictionary[Any](), props)
    }
    data.styles.foreach { styles =>
      newData.styles = objectAssign(js.Dictionary[Any](), styles)
    }
    data.hooks.foreach {
      hooks => newData.hooks = VNodeOps.copyHooks(hooks)
    }
    newData
  }

  def copyHooks(hooks: Hooks): Hooks = {
    new Hooks {
      init = hooks.init
      create = hooks.create
      insert = hooks.insert
      prePatch = hooks.prePatch
      update = hooks.update
      postPatch = hooks.postPatch
      destroy = hooks.destroy
      remove = hooks.remove
    }
  }

  def copyChildren(children: Children): Children = {
    children.jsSlice()
  }
}
