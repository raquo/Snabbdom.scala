package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.nodes.{Node, NodeData}

/**
  * Trait that contains the contents of the `Tags` object, so they can be mixed
  * in to other objects if needed.
  */
trait Tags[N <: Node[N, D], D <: NodeData[N, D]] { self: Builders[N, D] =>

  /**
    * Represents the root of an HTML or XHTML document. All other elements must
    * be descendants of this element.
    *
    *  MDN
    */
  def html: N = node("html")

  /**
    * Represents a collection of metadata about the document, including links to,
    * or definitions of, scripts and style sheets.
    *
    *  MDN
    */
  def head: N = node("head")

  /**
    * Defines the base URL for relative URLs in the page.
    *
    *  MDN
    */
  def base: N = node("base")

  /**
    * Used to link JavaScript and external CSS with the current HTML document.
    *
    *  MDN
    */
  def link: N = node("link")

  /**
    * Defines metadata that can't be defined using another HTML element.
    *
    *  MDN
    */
  def meta: N = node("meta")

  /**
    * Defines either an internal script or a link to an external script. The
    * script language is JavaScript.
    *
    *  MDN
    */
  def script: N = node("script")

  /**
    * Represents the content of an HTML document. There is only one body
    *   element in a document.
    *
    *  MDN
    */
  def body: N = node("body")

  // Sections

  /**
    * Heading level 1
    *
    *  MDN
    */
  def h1: N = node("h1")

  /**
    * Heading level 2
    *
    *  MDN
    */
  def h2: N = node("h2")

  /**
    * Heading level 3
    *
    *  MDN
    */
  def h3: N = node("h3")

  /**
    * Heading level 4
    *
    *  MDN
    */
  def h4: N = node("h4")

  /**
    * Heading level 5
    *
    *  MDN
    */
  def h5: N = node("h5")

  /**
    * Heading level 6
    *
    *  MDN
    */
  def h6: N = node("h6")

  /**
    * Defines the header of a page or section. It often contains a logo, the
    * title of the Web site, and a navigational table of content.
    *
    *  MDN
    */
  def header: N = node("header")

  /**
    * Defines the footer for a page or section. It often contains a copyright
    * notice, some links to legal information, or addresses to give feedback.
    *
    *  MDN
    */
  def footer: N = node("footer")

  // Grouping content

  /**
    * Defines a portion that should be displayed as a paragraph.
    *
    *  MDN
    */
  def p: N = node("p")

  /**
    * Represents a thematic break between paragraphs of a section or article or
    * any longer content.
    *
    *  MDN
    */
  def hr: N = node("hr")

  /**
    * Indicates that its content is preformatted and that this format must be
    * preserved.
    *
    *  MDN
    */
  def pre: N = node("pre")

  /**
    * Represents a content that is quoted from another source.
    *
    *  MDN
    */
  def blockQuote: N = node("blockquote")

  /**
    * Defines an ordered list of items.
    *
    *  MDN
    */
  def ol: N = node("ol")

  /**
    * Defines an unordered list of items.
    *
    *  MDN
    */
  def ul: N = node("ul")

  /**
    * Defines an item of an list.
    *
    *  MDN
    */
  def li: N = node("li")

  /**
    * Defines a definition list; a list of terms and their associated definitions.
    *
    *  MDN
    */
  def dl: N = node("dl")

  /**
    * Represents a term defined by the next dd
    *
    *  MDN
    */
  def dt: N = node("dt")

  /**
    * Represents the definition of the terms immediately listed before it.
    *
    *  MDN
    */
  def dd: N = node("dd")

  /**
    * Represents a figure illustrated as part of the document.
    *
    *  MDN
    */
  def figure: N = node("figure")

  /**
    * Represents the legend of a figure.
    *
    *  MDN
    */
  def figCaption: N = node("figcaption")

  /**
    * Represents a generic container with no special meaning.
    *
    *  MDN
    */
  def div: N = node("div")

  // Text-level semantics

  /**
    * Represents a hyperlink, linking to another resource.
    *
    *  MDN
    */
  def a: N = node("a")

  /**
    * Represents emphasized text.
    *
    *  MDN
    */
  def em: N = node("em")

  /**
    * Represents especially important text.
    *
    *  MDN
    */
  def strong: N = node("strong")

  /**
    * Represents a side comment; text like a disclaimer or copyright, which is not
    * essential to the comprehension of the document.
    *
    *  MDN
    */
  def small: N = node("small")

  /**
    * Strikethrough element, used for that is no longer accurate or relevant.
    *
    *  MDN
    */
  def s: N = node("s")

  /**
    * Represents the title of a work being cited.
    *
    *  MDN
    */
  def cite: N = node("cite")

  /**
    * Represents computer code.
    *
    *  MDN
    */
  def code: N = node("code")

  /**
    * Subscript tag
    *
    *  MDN
    */
  def sub: N = node("sub")

  /**
    * Superscript tag.
    *
    *  MDN
    */
  def sup: N = node("sup")

  /**
    * Italicized text.
    *
    *  MDN
    */
  def i: N = node("i")

  /**
    * Bold text.
    *
    *  MDN
    */
  def b: N = node("b")

  /**
    * Underlined text.
    *
    *  MDN
    */
  def u: N = node("u")

  /**
    * Represents text with no specific meaning. This has to be used when no other
    * text-semantic element conveys an adequate meaning, which, in this case, is
    * often brought by global attributes like class, lang, or dir.
    *
    *  MDN
    */
  def span: N = node("span")

  /**
    * Represents a line break.
    *
    *  MDN
    */
  def br: N = node("br")

  /**
    * Represents a line break opportunity, that is a suggested point for wrapping
    * text in order to improve readability of text split on several lines.
    *
    *  MDN
    */
  def wbr: N = node("wbr")

  // Edits

  /**
    * Defines an addition to the document.
    *
    *  MDN
    */
  def ins: N = node("ins")

  /**
    * Defines a remodef from the document.
    *
    *  MDN
    */
  def del: N = node("del")

  // Embedded content

  /**
    * Represents an image.
    *
    *  MDN
    */
  def img: N = node("img")

  /**
    * Represents a nested browsing context, that is an embedded HTML document.
    *
    *  MDN
    */
  def iframe: N = node("iframe")

  /**
    * Represents a integration point for an external, often non-HTML, application
    * or interactive content.
    *
    *  MDN
    */
  def embed: N = node("embed")

  /**
    * Represents an external resource, which is treated as an image, an HTML
    * sub-document, or an external resource to be processed by a plug-in.
    *
    *  MDN
    */
  def `object`: N = node("object")

  /**
    * Defines parameters for use by plug-ins invoked by object elements.
    *
    *  MDN
    */
  def param: N = node("param")

  /**
    * Represents a video, and its associated audio files and captions, with the
    * necessary interface to play it.
    *
    *  MDN
    */
  def video: N = node("video")

  /**
    * Represents a sound or an audio stream.
    *
    *  MDN
    */
  def audio: N = node("audio")

  /**
    * Allows the authors to specify alternate media resources for media elements
    * like video or audio
    *
    *  MDN
    */
  def source: N = node("source")

  /**
    * Allows authors to specify timed text track for media elements like video or
    * audio
    *
    *  MDN
    */
  def track: N = node("track")

  /**
    * Represents a bitmap area that scripts can use to render graphics like graphs,
    * games or any visual images on the fly.
    *
    *  MDN
    */
  def canvas: N = node("canvas")

  /**
    * In conjunction with area, defines an image map.
    *
    *  MDN
    */
  def map: N = node("map")

  /**
    * In conjunction with map, defines an image map
    *
    *  MDN
    */
  def area: N = node("area")

  // Tabular data

  /**
    * Represents data with more than one dimension.
    *
    *  MDN
    */
  def table: N = node("table")

  /**
    * The title of a table.
    *
    *  MDN
    */
  def caption: N = node("caption")

  /**
    * A set of columns.
    *
    *  MDN
    */
  def colGroup: N = node("colgroup")

  /**
    * A single column.
    *
    *  MDN
    */
  def col: N = node("col")

  /**
    * The table body.
    *
    *  MDN
    */
  def tbody: N = node("tbody")

  /**
    * The table headers.
    *
    *  MDN
    */
  def thead: N = node("thead")

  /**
    * The table footer.
    *
    *  MDN
    */
  def tfoot: N = node("tfoot")

  /**
    * A single row in a table.
    *
    *  MDN
    */
  def tr: N = node("tr")

  /**
    * A single cell in a table.
    *
    *  MDN
    */
  def td: N = node("td")

  /**
    * A header cell in a table.
    *
    *  MDN
    */
  def th: N = node("th")

  // Forms

  /**
    * Represents a form, consisting of controls, that can be submitted to a
    * server for processing.
    *
    *  MDN
    */
  def form: N = node("form")

  /**
    * A set of fields.
    *
    *  MDN
    */
  def fieldSet: N = node("fieldset")

  /**
    * The caption for a fieldset.
    *
    *  MDN
    */
  def legend: N = node("legend")

  /**
    * The caption of a single field
    *
    *  MDN
    */
  def label: N = node("label")

  /**
    * A typed data field allowing the user to input data.
    *
    *  MDN
    */
  def input: N = node("input")

  /**
    * A button
    *
    *  MDN
    */
  def button: N = node("button")

  /**
    * A control that allows the user to select one of a set of options.
    *
    *  MDN
    */
  def select: N = node("select")

  /**
    * A set of predefined options for other controls.
    *
    *  MDN
    */
  def dataList: N = node("datalist")

  /**
    * A set of options, logically grouped.
    *
    *  MDN
    */
  def optGroup: N = node("optgroup")

  /**
    * An option in a select element.
    *
    *  MDN
    */
  def option: N = node("option")

  /**
    * A multiline text edit control.
    *
    *  MDN
    */
  def textArea: N = node("textarea")
}
