package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.VNode

/**
  * Contains HTML tags which are used less frequently. These are generally
  * imported individually as needed.
  */
trait Tags2[N <: VNode] { self: Builders[N] =>

  // Document Metadata

  /**
    * Defines the title of the document, shown in a browser's title bar or on the
    * page's tab. It can only contain text and any contained tags are not
    * interpreted.
    *
    * MDN
    */
  def title: N = vnode("title")

  /**
    * Used to write inline CSS.
    *
    *  MDN
    */
  def style: N = vnode("style")

  // Scripting

  /**
    * Defines alternative content to display when the browser doesn't support
    * scripting.
    *
    *  MDN
    */
  def noScript: N = vnode("noscript")

  // Sections

  /**
    * Represents a generic section of a document, i.e., a thematic grouping of
    * content, typically with a heading.
    *
    *  MDN
    */
  def section: N = vnode("section")

  /**
    * Represents a section of a page that links to other pages or to parts within
    * the page: a section with navigation links.
    *
    *  MDN
    */
  def nav: N = vnode("nav")

  /**
    * Defines self-contained content that could exist independently of the rest
    * of the content.
    *
    *  MDN
    */
  def article: N = vnode("article")

  /**
    * Defines some content loosely related to the page content. If it is removed,
    * the remaining content still makes sense.
    *
    *  MDN
    */
  def aside: N = vnode("aside")

  /**
    * Defines a section containing contact information.
    *
    *  MDN
    */
  def address: N = vnode("address")

  /**
    * Defines the main or important content in the document. There is only one
    * main element in the document.
    *
    *  MDN
    */
  def main: N = vnode("main")

  // Text level semantics

  /**
    * An inline quotation.
    *
    *  MDN
    */
  def q: N = vnode("q")

  /**
    * Represents a term whose definition is contained in its nearest ancestor
    * content.
    *
    *  MDN
    */
  def dfn: N = vnode("dfn")

  /**
    * An abbreviation or acronym; the expansion of the abbreviation can be
    * represented in the title attribute.
    *
    *  MDN
    */
  def abbr: N = vnode("abbr")

  /**
    * Associates to its content a machine-readable equivalent.
    *
    *  MDN
    */
  def data: N = vnode("data")

  /**
    * Represents a date and time value; the machine-readable equivalent can be
    * represented in the datetime attribetu
    *
    *  MDN
    */
  def time: N = vnode("time")

  /**
    * Represents a variable.
    *
    *  MDN
    */
  def `var`: N = vnode("var")

  /**
    * Represents the output of a program or a computer.
    *
    *  MDN
    */
  def samp: N = vnode("samp")

  /**
    * Represents user input, often from a keyboard, but not necessarily.
    *
    *  MDN
    */
  def kbd: N = vnode("kbd")

  /**
    * Defines a mathematical formula.
    *
    *  MDN
    */
  def math: N = vnode("math")

  /**
    * Represents text highlighted for reference purposes, that is for its
    * relevance in another context.
    *
    *  MDN
    */
  def mark: N = vnode("mark")

  /**
    * Represents content to be marked with ruby annotations, short runs of text
    * presented alongside the text. This is often used in conjunction with East
    * Asian language where the annotations act as a guide for pronunciation, like
    * the Japanese furigana .
    *
    *  MDN
    */
  def ruby: N = vnode("ruby")

  /**
    * Represents the text of a ruby annotation.
    *
    *  MDN
    */
  def rt: N = vnode("rt")

  /**
    * Represents parenthesis around a ruby annotation, used to display the
    * annotation in an alternate way by browsers not supporting the standard
    * display for annotations.
    *
    *  MDN
    */
  def rp: N = vnode("rp")

  /**
    * Represents text that must be isolated from its surrounding for bidirectional
    * text formatting. It allows embedding a span of text with a different, or
    * unknown, directionality.
    *
    *  MDN
    */
  def bdi: N = vnode("bdi")

  /**
    * Represents the directionality of its children, in order to explicitly
    * override the Unicode bidirectional algorithm.
    *
    *  MDN
    */
  def bdo: N = vnode("bdo")

  // Forms

  /**
    * A key-pair generator control.
    *
    *  MDN
    */
  def keyGen: N = vnode("keygen")

  /**
    * The result of a calculation
    *
    *  MDN
    */
  def output: N = vnode("output")

  /**
    * A progress completion bar
    *
    *  MDN
    */
  def progress: N = vnode("progress")

  /**
    * A scalar measurement within a known range.
    *
    *  MDN
    */
  def meter: N = vnode("meter")

  // Interactive elements

  /**
    * A widget from which the user can obtain additional information
    * or controls.
    *
    *  MDN
    */
  def details: N = vnode("details")

  /**
    * A summary, caption, or legend for a given details.
    *
    *  MDN
    */
  def summary: N = vnode("summary")

  /**
    * A command that the user can invoke.
    *
    *  MDN
    */
  def command: N = vnode("command")

  /**
    * A list of commands
    *
    *  MDN
    */
  def menu: N = vnode("menu")
}
