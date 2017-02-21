package com.raquo.snabbdom

import com.raquo.snabbdom.props.{colSpan, href, rowSpan, disabled, rel}
import com.raquo.snabbdom.helpers.UnitSpec
import com.raquo.snabbdom.tags.{div, input, span, td}

import scala.util.Random

class PropSpec extends UnitSpec {

  // @TODO[Integrity] For some reason, these tests fail when running them in node.js/jsdom. Prop values return as strings instead of numbers.

  it("sets props") {
    val expectedRel = randomString("rel_")
    val expectedColSpan = Random.nextInt(15)
    val expectedRowSpan = 15 + Random.nextInt(7)

    mount("div", div(rel := expectedRel))
    expectElement(div like (rel is expectedRel))
    unmount()

    mount("td [colSpan, rowSpan]", td(
      colSpan := expectedColSpan,
      rowSpan := expectedRowSpan
    ))
    expectElement(
      td like(
        colSpan is expectedColSpan,
        rowSpan is expectedRowSpan,
        rel isEmpty
      )
    )
    unmount()
  }

  it("sets non-string props") {
    mount("input [disabled=false]", input(disabled := false))
    expectElement(input like(disabled is false, colSpan isEmpty))
    unmount()

    mount("input [disabled=true]", input(disabled := true))
    expectElement(input like(disabled is true, colSpan isEmpty))
    unmount()

    val expectedColSpan = Random.nextInt(10)
    mount("td [colSpan]", td(colSpan := expectedColSpan))
    expectElement(td like(colSpan is expectedColSpan, disabled isEmpty))
    unmount()
  }

  it("order of modifiers does not matter") {
    val expectedHref = randomString("href_")
    val expectedRel = randomString("rel_")
    val expectedText = randomString("text_")
    val expected = div like(
      href is expectedHref,
      rel is expectedRel,
      span like expectedText
    )

    val setHref = href := expectedHref
    val setRel = rel := expectedRel
    val addChild = span(expectedText)

    mount("[href], [rel], span", div(setHref, setRel, addChild))
    expectElement(expected)
    unmount()

    mount("[rel], [href], span", div(setRel, setHref, addChild))
    expectElement(expected)
    unmount()

    mount("[rel], span, [href]", div(setRel, addChild, setHref))
    expectElement(expected)
    unmount()

    mount("span, [rel], [href]", div(addChild, setRel, setHref))
    expectElement(expected)
    unmount()
  }

  it("sets props in nested elements") {
    val expectedRel1 = randomString("rel1_")
    val expectedRel2 = randomString("rel2_")
    val expectedText1 = randomString("text1_")
    val expectedText2 = randomString("text2_")
    val expectedColSpan = Random.nextInt(15)
    val expectedRowSpan = 15 + Random.nextInt(7)

    mount(
      td(
        colSpan := expectedColSpan,
        rowSpan := expectedRowSpan,
        span(
          rel := expectedRel1,
          expectedText1,
          span(
            expectedText2,
            rel := expectedRel2
          )
        ),
        span()
      )
    )
    expectElement(
      td like(
        colSpan is expectedColSpan,
        rowSpan is expectedRowSpan,
        rel isEmpty,
        span like(
          rel is expectedRel1,
          colSpan isEmpty,
          rowSpan isEmpty,
          expectedText1,
          span like(
            rel is expectedRel2,
            colSpan isEmpty,
            rowSpan isEmpty,
            expectedText2
          )
        ),
        span likeEmpty
      )
    )
  }
}
