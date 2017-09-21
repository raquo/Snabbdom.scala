package com.raquo.snabbdom.simple

import com.raquo.snabbdom.nodes.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class VNode(val tagName: js.UndefOr[String]) extends Node[VNode, VNodeData](tagName)
