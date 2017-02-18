package com.raquo.snabbdom.helpers

import scala.util.Random

trait RandomSpec {

  def randomString(prefix: String = "", length: Int = 5): String = {
    prefix + Random.nextString(length)
  }
}
