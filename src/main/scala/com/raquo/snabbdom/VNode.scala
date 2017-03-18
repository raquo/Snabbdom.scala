package com.raquo.snabbdom

import com.raquo.snabbdom.nodes.Node

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
class VNode(tagName: js.UndefOr[String]) extends Node[VNode](tagName)
