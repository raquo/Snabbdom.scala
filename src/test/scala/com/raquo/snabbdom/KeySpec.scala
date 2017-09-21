package com.raquo.snabbdom

import com.raquo.snabbdom.simple.implicits._
import com.raquo.snabbdom
import com.raquo.snabbdom.simple.tags.{div}

import scala.scalajs.js

class KeySpec extends UnitSpec {

  it("sets the key") {
    val emptyDiv = div()
    emptyDiv.key shouldBe js.undefined

    val divWithKey = div(snabbdom.simple.key := "yolo")
    divWithKey.key shouldBe "yolo"
  }

}
