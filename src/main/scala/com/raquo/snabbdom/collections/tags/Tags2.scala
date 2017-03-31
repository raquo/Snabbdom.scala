package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}

/**
  * Contains HTML tags which are used less frequently. These are generally
  * imported individually as needed.
  */
trait Tags2[N <: Node[N, D], D <: NodeData[N, D]] { self: Builders[N, D] =>

  /**
    * The Comment interface represents textual notations within markup; although
    * it is generally not visually shown, such comments are available to be read
    * in the source view.
    *
    * <!-- HTML comment -->
    *
    * MDN
    */
  def comment: N = node("!")

  // Document Metadata

  /**
    * Defines the title of the document, shown in a browser's title bar or on the
    * page's tab. It can only contain text and any contained tags are not
    * interpreted.
    *
    * MDN
    */
  def title: N = node("title")

  /**
    * Used to write inline CSS.
    *
    *  MDN
    */
  def style: N = node("style")

  // Scripting

  /**
    * Defines alternative content to display when the browser doesn't support
    * scripting.
    *
    *  MDN
    */
  def noScript: N = node("noscript")

  // Sections

  /**
    * Represents a generic section of a document, i.e., a thematic grouping of
    * content, typically with a heading.
    *
    *  MDN
    */
  def section: N = node("section")

  /**
    * Represents a section of a page that links to other pages or to parts within
    * the page: a section with navigation links.
    *
    *  MDN
    */
  def nav: N = node("nav")

  /**
    * Defines self-contained content that could exist independently of the rest
    * of the content.
    *
    *  MDN
    */
  def article: N = node("article")

  /**
    * Defines some content loosely related to the page content. If it is removed,
    * the remaining content still makes sense.
    *
    *  MDN
    */
  def aside: N = node("aside")

  /**
    * Defines a section containing contact information.
    *
    *  MDN
    */
  def address: N = node("address")

  /**
    * Defines the main or important content in the document. There is only one
    * main element in the document.
    *
    *  MDN
    */
  def main: N = node("main")

  // Text level semantics

  /**
    * An inline quotation.
    *
    *  MDN
    */
  def q: N = node("q")

  /**
    * Represents a term whose definition is contained in its nearest ancestor
    * content.
    *
    *  MDN
    */
  def dfn: N = node("dfn")

  /**
    * An abbreviation or acronym; the expansion of the abbreviation can be
    * represented in the title attribute.
    *
    *  MDN
    */
  def abbr: N = node("abbr")

  /**
    * Associates to its content a machine-readable equivalent.
    *
    *  MDN
    */
  def data: N = node("data")

  /**
    * Represents a date and time value; the machine-readable equivalent can be
    * represented in the datetime attribetu
    *
    *  MDN
    */
  def time: N = node("time")

  /**
    * Represents a variable.
    *
    *  MDN
    */
  def `var`: N = node("var")

  /**
    * Represents the output of a program or a computer.
    *
    *  MDN
    */
  def samp: N = node("samp")

  /**
    * Represents user input, often from a keyboard, but not necessarily.
    *
    *  MDN
    */
  def kbd: N = node("kbd")

  /**
    * Defines a mathematical formula.
    *
    *  MDN
    */
  def math: N = node("math")

  /**
    * Represents text highlighted for reference purposes, that is for its
    * relevance in another context.
    *
    *  MDN
    */
  def mark: N = node("mark")

  /**
    * Represents content to be marked with ruby annotations, short runs of text
    * presented alongside the text. This is often used in conjunction with East
    * Asian language where the annotations act as a guide for pronunciation, like
    * the Japanese furigana .
    *
    *  MDN
    */
  def ruby: N = node("ruby")

  /**
    * Represents the text of a ruby annotation.
    *
    *  MDN
    */
  def rt: N = node("rt")

  /**
    * Represents parenthesis around a ruby annotation, used to display the
    * annotation in an alternate way by browsers not supporting the standard
    * display for annotations.
    *
    *  MDN
    */
  def rp: N = node("rp")

  /**
    * Represents text that must be isolated from its surrounding for bidirectional
    * text formatting. It allows embedding a span of text with a different, or
    * unknown, directionality.
    *
    *  MDN
    */
  def bdi: N = node("bdi")

  /**
    * Represents the directionality of its children, in order to explicitly
    * override the Unicode bidirectional algorithm.
    *
    *  MDN
    */
  def bdo: N = node("bdo")

  // Forms

  /**
    * A key-pair generator control.
    *
    *  MDN
    */
  def keyGen: N = node("keygen")

  /**
    * The result of a calculation
    *
    *  MDN
    */
  def output: N = node("output")

  /**
    * A progress completion bar
    *
    *  MDN
    */
  def progress: N = node("progress")

  /**
    * A scalar measurement within a known range.
    *
    *  MDN
    */
  def meter: N = node("meter")

  // Interactive elements

  /**
    * A widget from which the user can obtain additional information
    * or controls.
    *
    *  MDN
    */
  def details: N = node("details")

  /**
    * A summary, caption, or legend for a given details.
    *
    *  MDN
    */
  def summary: N = node("summary")

  /**
    * A command that the user can invoke.
    *
    *  MDN
    */
  def command: N = node("command")

  /**
    * A list of commands
    *
    *  MDN
    */
  def menu: N = node("menu")
}
