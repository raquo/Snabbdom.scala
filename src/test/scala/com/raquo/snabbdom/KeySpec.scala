package com.raquo.snabbdom

import com.raquo.snabbdom
import com.raquo.snabbdom.allTags.{div, hr, p, span}

import scala.scalajs.js

class KeySpec extends UnitSpec {

  it("sets the key") {
    val emptyDiv = div()
    emptyDiv.key shouldBe js.undefined

    val divWithKey = div(snabbdom.key := "yolo")
    divWithKey.key shouldBe "yolo"
  }

}
