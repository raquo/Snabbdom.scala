package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.VNode

/**
  * Contains HTML tags which are used less frequently. These are generally
  * imported individually as needed.
  */
trait Tags2 { self: Builders =>

  // Document Metadata

  /**
    * Defines the title of the document, shown in a browser's title bar or on the
    * page's tab. It can only contain text and any contained tags are not
    * interpreted.
    *
    * MDN
    */
  def title: VNode = vnode("title")

  /**
    * Used to write inline CSS.
    *
    *  MDN
    */
  def style: VNode = vnode("style")

  // Scripting

  /**
    * Defines alternative content to display when the browser doesn't support
    * scripting.
    *
    *  MDN
    */
  def noScript: VNode = vnode("noscript")

  // Sections

  /**
    * Represents a generic section of a document, i.e., a thematic grouping of
    * content, typically with a heading.
    *
    *  MDN
    */
  def section: VNode = vnode("section")

  /**
    * Represents a section of a page that links to other pages or to parts within
    * the page: a section with navigation links.
    *
    *  MDN
    */
  def nav: VNode = vnode("nav")

  /**
    * Defines self-contained content that could exist independently of the rest
    * of the content.
    *
    *  MDN
    */
  def article: VNode = vnode("article")

  /**
    * Defines some content loosely related to the page content. If it is removed,
    * the remaining content still makes sense.
    *
    *  MDN
    */
  def aside: VNode = vnode("aside")

  /**
    * Defines a section containing contact information.
    *
    *  MDN
    */
  def address: VNode = vnode("address")

  /**
    * Defines the main or important content in the document. There is only one
    * main element in the document.
    *
    *  MDN
    */
  def main: VNode = vnode("main")

  // Text level semantics

  /**
    * An inline quotation.
    *
    *  MDN
    */
  def q: VNode = vnode("q")

  /**
    * Represents a term whose definition is contained in its nearest ancestor
    * content.
    *
    *  MDN
    */
  def dfn: VNode = vnode("dfn")

  /**
    * An abbreviation or acronym; the expansion of the abbreviation can be
    * represented in the title attribute.
    *
    *  MDN
    */
  def abbr: VNode = vnode("abbr")

  /**
    * Associates to its content a machine-readable equivalent.
    *
    *  MDN
    */
  def data: VNode = vnode("data")

  /**
    * Represents a date and time value; the machine-readable equivalent can be
    * represented in the datetime attribetu
    *
    *  MDN
    */
  def time: VNode = vnode("time")

  /**
    * Represents a variable.
    *
    *  MDN
    */
  def `var`: VNode = vnode("var")

  /**
    * Represents the output of a program or a computer.
    *
    *  MDN
    */
  def samp: VNode = vnode("samp")

  /**
    * Represents user input, often from a keyboard, but not necessarily.
    *
    *  MDN
    */
  def kbd: VNode = vnode("kbd")

  /**
    * Defines a mathematical formula.
    *
    *  MDN
    */
  def math: VNode = vnode("math")

  /**
    * Represents text highlighted for reference purposes, that is for its
    * relevance in another context.
    *
    *  MDN
    */
  def mark: VNode = vnode("mark")

  /**
    * Represents content to be marked with ruby annotations, short runs of text
    * presented alongside the text. This is often used in conjunction with East
    * Asian language where the annotations act as a guide for pronunciation, like
    * the Japanese furigana .
    *
    *  MDN
    */
  def ruby: VNode = vnode("ruby")

  /**
    * Represents the text of a ruby annotation.
    *
    *  MDN
    */
  def rt: VNode = vnode("rt")

  /**
    * Represents parenthesis around a ruby annotation, used to display the
    * annotation in an alternate way by browsers not supporting the standard
    * display for annotations.
    *
    *  MDN
    */
  def rp: VNode = vnode("rp")

  /**
    * Represents text that must be isolated from its surrounding for bidirectional
    * text formatting. It allows embedding a span of text with a different, or
    * unknown, directionality.
    *
    *  MDN
    */
  def bdi: VNode = vnode("bdi")

  /**
    * Represents the directionality of its children, in order to explicitly
    * override the Unicode bidirectional algorithm.
    *
    *  MDN
    */
  def bdo: VNode = vnode("bdo")

  // Forms

  /**
    * A key-pair generator control.
    *
    *  MDN
    */
  def keyGen: VNode = vnode("keygen")

  /**
    * The result of a calculation
    *
    *  MDN
    */
  def output: VNode = vnode("output")

  /**
    * A progress completion bar
    *
    *  MDN
    */
  def progress: VNode = vnode("progress")

  /**
    * A scalar measurement within a known range.
    *
    *  MDN
    */
  def meter: VNode = vnode("meter")

  // Interactive elements

  /**
    * A widget from which the user can obtain additional information
    * or controls.
    *
    *  MDN
    */
  def details: VNode = vnode("details")

  /**
    * A summary, caption, or legend for a given details.
    *
    *  MDN
    */
  def summary: VNode = vnode("summary")

  /**
    * A command that the user can invoke.
    *
    *  MDN
    */
  def command: VNode = vnode("command")

  /**
    * A list of commands
    *
    *  MDN
    */
  def menu: VNode = vnode("menu")
}
