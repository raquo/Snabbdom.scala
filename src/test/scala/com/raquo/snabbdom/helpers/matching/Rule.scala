package com.raquo.snabbdom.helpers.matching

trait Rule {
  def applyTo(testNode: ExpectedElement): Unit
}
