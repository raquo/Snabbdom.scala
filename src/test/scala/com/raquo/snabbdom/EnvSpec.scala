package com.raquo.snabbdom

import com.raquo.snabbdom.utils.testing.UnitSpec
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

import scala.util.Random

/**
  * Sanity checks on the testing environment.
  * This does not use Laminar library at all.
  */
class EnvSpec extends UnitSpec {

  it("renders elements with attributes") {
    val spanId = "spanId_" + Random.nextString(5)
    val span = dom.document.createElement("span")
    span.setAttribute("id", spanId)
    dom.document.body.appendChild(span)

    span.id shouldBe spanId
  }

  it("handles click events") {
    var callbackCount = 0

    def testEvent(ev: MouseEvent): Unit = {
      callbackCount += 1
    }

    val div = dom.document.createElement("div")
    val div2 = dom.document.createElement("div")
    val span = dom.document.createElement("span")

    div.addEventListener[MouseEvent]("click", testEvent _)

    div.appendChild(span)
    dom.document.body.appendChild(div)
    dom.document.body.appendChild(div2)

    // Direct hit
    simulateClick(div)
    callbackCount shouldBe 1

    // Click event should bubble up
    simulateClick(span)
    callbackCount shouldBe 2

    // Click should not be counted on unrelated div
    simulateClick(div2)
    callbackCount shouldBe 2
  }
}
