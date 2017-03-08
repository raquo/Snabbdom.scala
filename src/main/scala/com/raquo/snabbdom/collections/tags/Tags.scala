package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.VNode

/**
  * Trait that contains the contents of the `Tags` object, so they can be mixed
  * in to other objects if needed.
  */
trait Tags[N <: VNode] { self: Builders[N] =>

  /**
    * Represents the root of an HTML or XHTML document. All other elements must
    * be descendants of this element.
    *
    *  MDN
    */
  def html: N = vnode("html")

  /**
    * Represents a collection of metadata about the document, including links to,
    * or definitions of, scripts and style sheets.
    *
    *  MDN
    */
  def head: N = vnode("head")

  /**
    * Defines the base URL for relative URLs in the page.
    *
    *  MDN
    */
  def base: N = vnode("base")

  /**
    * Used to link JavaScript and external CSS with the current HTML document.
    *
    *  MDN
    */
  def link: N = vnode("link")

  /**
    * Defines metadata that can't be defined using another HTML element.
    *
    *  MDN
    */
  def meta: N = vnode("meta")

  /**
    * Defines either an internal script or a link to an external script. The
    * script language is JavaScript.
    *
    *  MDN
    */
  def script: N = vnode("script")

  /**
    * Represents the content of an HTML document. There is only one body
    *   element in a document.
    *
    *  MDN
    */
  def body: N = vnode("body")

  // Sections

  /**
    * Heading level 1
    *
    *  MDN
    */
  def h1: N = vnode("h1")

  /**
    * Heading level 2
    *
    *  MDN
    */
  def h2: N = vnode("h2")

  /**
    * Heading level 3
    *
    *  MDN
    */
  def h3: N = vnode("h3")

  /**
    * Heading level 4
    *
    *  MDN
    */
  def h4: N = vnode("h4")

  /**
    * Heading level 5
    *
    *  MDN
    */
  def h5: N = vnode("h5")

  /**
    * Heading level 6
    *
    *  MDN
    */
  def h6: N = vnode("h6")

  /**
    * Defines the header of a page or section. It often contains a logo, the
    * title of the Web site, and a navigational table of content.
    *
    *  MDN
    */
  def header: N = vnode("header")

  /**
    * Defines the footer for a page or section. It often contains a copyright
    * notice, some links to legal information, or addresses to give feedback.
    *
    *  MDN
    */
  def footer: N = vnode("footer")

  // Grouping content

  /**
    * Defines a portion that should be displayed as a paragraph.
    *
    *  MDN
    */
  def p: N = vnode("p")

  /**
    * Represents a thematic break between paragraphs of a section or article or
    * any longer content.
    *
    *  MDN
    */
  def hr: N = vnode("hr")

  /**
    * Indicates that its content is preformatted and that this format must be
    * preserved.
    *
    *  MDN
    */
  def pre: N = vnode("pre")

  /**
    * Represents a content that is quoted from another source.
    *
    *  MDN
    */
  def blockQuote: N = vnode("blockquote")

  /**
    * Defines an ordered list of items.
    *
    *  MDN
    */
  def ol: N = vnode("ol")

  /**
    * Defines an unordered list of items.
    *
    *  MDN
    */
  def ul: N = vnode("ul")

  /**
    * Defines an item of an list.
    *
    *  MDN
    */
  def li: N = vnode("li")

  /**
    * Defines a definition list; a list of terms and their associated definitions.
    *
    *  MDN
    */
  def dl: N = vnode("dl")

  /**
    * Represents a term defined by the next dd
    *
    *  MDN
    */
  def dt: N = vnode("dt")

  /**
    * Represents the definition of the terms immediately listed before it.
    *
    *  MDN
    */
  def dd: N = vnode("dd")

  /**
    * Represents a figure illustrated as part of the document.
    *
    *  MDN
    */
  def figure: N = vnode("figure")

  /**
    * Represents the legend of a figure.
    *
    *  MDN
    */
  def figCaption: N = vnode("figcaption")

  /**
    * Represents a generic container with no special meaning.
    *
    *  MDN
    */
  def div: N = vnode("div")

  // Text-level semantics

  /**
    * Represents a hyperlink, linking to another resource.
    *
    *  MDN
    */
  def a: N = vnode("a")

  /**
    * Represents emphasized text.
    *
    *  MDN
    */
  def em: N = vnode("em")

  /**
    * Represents especially important text.
    *
    *  MDN
    */
  def strong: N = vnode("strong")

  /**
    * Represents a side comment; text like a disclaimer or copyright, which is not
    * essential to the comprehension of the document.
    *
    *  MDN
    */
  def small: N = vnode("small")

  /**
    * Strikethrough element, used for that is no longer accurate or relevant.
    *
    *  MDN
    */
  def s: N = vnode("s")

  /**
    * Represents the title of a work being cited.
    *
    *  MDN
    */
  def cite: N = vnode("cite")

  /**
    * Represents computer code.
    *
    *  MDN
    */
  def code: N = vnode("code")

  /**
    * Subscript tag
    *
    *  MDN
    */
  def sub: N = vnode("sub")

  /**
    * Superscript tag.
    *
    *  MDN
    */
  def sup: N = vnode("sup")

  /**
    * Italicized text.
    *
    *  MDN
    */
  def i: N = vnode("i")

  /**
    * Bold text.
    *
    *  MDN
    */
  def b: N = vnode("b")

  /**
    * Underlined text.
    *
    *  MDN
    */
  def u: N = vnode("u")

  /**
    * Represents text with no specific meaning. This has to be used when no other
    * text-semantic element conveys an adequate meaning, which, in this case, is
    * often brought by global attributes like class, lang, or dir.
    *
    *  MDN
    */
  def span: N = vnode("span")

  /**
    * Represents a line break.
    *
    *  MDN
    */
  def br: N = vnode("br")

  /**
    * Represents a line break opportunity, that is a suggested point for wrapping
    * text in order to improve readability of text split on several lines.
    *
    *  MDN
    */
  def wbr: N = vnode("wbr")

  // Edits

  /**
    * Defines an addition to the document.
    *
    *  MDN
    */
  def ins: N = vnode("ins")

  /**
    * Defines a remodef from the document.
    *
    *  MDN
    */
  def del: N = vnode("del")

  // Embedded content

  /**
    * Represents an image.
    *
    *  MDN
    */
  def img: N = vnode("img")

  /**
    * Represents a nested browsing context, that is an embedded HTML document.
    *
    *  MDN
    */
  def iframe: N = vnode("iframe")

  /**
    * Represents a integration point for an external, often non-HTML, application
    * or interactive content.
    *
    *  MDN
    */
  def embed: N = vnode("embed")

  /**
    * Represents an external resource, which is treated as an image, an HTML
    * sub-document, or an external resource to be processed by a plug-in.
    *
    *  MDN
    */
  def `object`: N = vnode("object")

  /**
    * Defines parameters for use by plug-ins invoked by object elements.
    *
    *  MDN
    */
  def param: N = vnode("param")

  /**
    * Represents a video, and its associated audio files and captions, with the
    * necessary interface to play it.
    *
    *  MDN
    */
  def video: N = vnode("video")

  /**
    * Represents a sound or an audio stream.
    *
    *  MDN
    */
  def audio: N = vnode("audio")

  /**
    * Allows the authors to specify alternate media resources for media elements
    * like video or audio
    *
    *  MDN
    */
  def source: N = vnode("source")

  /**
    * Allows authors to specify timed text track for media elements like video or
    * audio
    *
    *  MDN
    */
  def track: N = vnode("track")

  /**
    * Represents a bitmap area that scripts can use to render graphics like graphs,
    * games or any visual images on the fly.
    *
    *  MDN
    */
  def canvas: N = vnode("canvas")

  /**
    * In conjunction with area, defines an image map.
    *
    *  MDN
    */
  def map: N = vnode("map")

  /**
    * In conjunction with map, defines an image map
    *
    *  MDN
    */
  def area: N = vnode("area")

  // Tabular data

  /**
    * Represents data with more than one dimension.
    *
    *  MDN
    */
  def table: N = vnode("table")

  /**
    * The title of a table.
    *
    *  MDN
    */
  def caption: N = vnode("caption")

  /**
    * A set of columns.
    *
    *  MDN
    */
  def colGroup: N = vnode("colgroup")

  /**
    * A single column.
    *
    *  MDN
    */
  def col: N = vnode("col")

  /**
    * The table body.
    *
    *  MDN
    */
  def tbody: N = vnode("tbody")

  /**
    * The table headers.
    *
    *  MDN
    */
  def thead: N = vnode("thead")

  /**
    * The table footer.
    *
    *  MDN
    */
  def tfoot: N = vnode("tfoot")

  /**
    * A single row in a table.
    *
    *  MDN
    */
  def tr: N = vnode("tr")

  /**
    * A single cell in a table.
    *
    *  MDN
    */
  def td: N = vnode("td")

  /**
    * A header cell in a table.
    *
    *  MDN
    */
  def th: N = vnode("th")

  // Forms

  /**
    * Represents a form, consisting of controls, that can be submitted to a
    * server for processing.
    *
    *  MDN
    */
  def form: N = vnode("form")

  /**
    * A set of fields.
    *
    *  MDN
    */
  def fieldSet: N = vnode("fieldset")

  /**
    * The caption for a fieldset.
    *
    *  MDN
    */
  def legend: N = vnode("legend")

  /**
    * The caption of a single field
    *
    *  MDN
    */
  def label: N = vnode("label")

  /**
    * A typed data field allowing the user to input data.
    *
    *  MDN
    */
  def input: N = vnode("input")

  /**
    * A button
    *
    *  MDN
    */
  def button: N = vnode("button")

  /**
    * A control that allows the user to select one of a set of options.
    *
    *  MDN
    */
  def select: N = vnode("select")

  /**
    * A set of predefined options for other controls.
    *
    *  MDN
    */
  def dataList: N = vnode("datalist")

  /**
    * A set of options, logically grouped.
    *
    *  MDN
    */
  def optGroup: N = vnode("optgroup")

  /**
    * An option in a select element.
    *
    *  MDN
    */
  def option: N = vnode("option")

  /**
    * A multiline text edit control.
    *
    *  MDN
    */
  def textArea: N = vnode("textarea")
}
