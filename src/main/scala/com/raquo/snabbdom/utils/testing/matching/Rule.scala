package com.raquo.snabbdom.utils.testing.matching

trait Rule {
  def applyTo(testNode: ExpectedElement): Unit
}
