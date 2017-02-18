package com.raquo.snabbdom

import com.raquo.snabbdom.allTags.{div, hr, p, span, article}

import com.raquo.snabbdom.helpers.UnitSpec

class ElementSpec extends UnitSpec {

  it("renders empty elements") {
    mount("empty <div>", div())
    expectElement(div likeEmpty)
    unmount()

    mount("empty <span>", span())
    expectElement(span likeEmpty)
    unmount()

    mount("empty <p>", p)
    expectElement(p likeEmpty)
    unmount()

    mount("empty <hr>", hr)
    expectElement(hr likeEmpty)
    unmount()
  }

  it("renders elements with text Content") {
    val text = randomString("text_")

    mount("span", span(text))
    expectElement(span like text)
    unmount()

    mount("article (fancy element from Tags2)", article(text))
    expectElement(article like text)
    unmount()

    // @TODO[Integrity] Test with two text nodes in one element once we fix that behaviour
  }

  it("renders nested elements") {
    val text1 = randomString("text1_")
    val text2 = randomString("text2_")
    val text3 = randomString("text3_")

    mount("div > span", div(span(text1)))
    expectElement(div like (span like text1))
    unmount()

    mount(
      "div > span, p",
      div(span(text1), p(text2))
    )
    expectElement(div like(span like text1, p like text2))
    unmount()

    mount(
      "div > span, p, p",
      div(span(text1), p(text2), p(text3))
    )
    expectElement(div like(span like text1, p like text2, p like text3))
    unmount()

    mount(
      "div > span, (p > #text, span, span), hr",
      div(span(text1), p(text2, span(text2), span(text3)), hr)
    )
    expectElement(div like(span like text1, p like (text2, span like text2, span like text3), hr likeEmpty))
    unmount()
  }

}
