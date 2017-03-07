package com.raquo.snabbdom.collections.tags

import com.raquo.snabbdom.collections.Builders
import com.raquo.snabbdom.VNode

/**
  * Trait that contains the contents of the `Tags` object, so they can be mixed
  * in to other objects if needed.
  */
trait Tags { self: Builders =>

  /**
    * Represents the root of an HTML or XHTML document. All other elements must
    * be descendants of this element.
    *
    *  MDN
    */
  def html: VNode = vnode("html")

  /**
    * Represents a collection of metadata about the document, including links to,
    * or definitions of, scripts and style sheets.
    *
    *  MDN
    */
  def head: VNode = vnode("head")

  /**
    * Defines the base URL for relative URLs in the page.
    *
    *  MDN
    */
  def base: VNode = vnode("base")

  /**
    * Used to link JavaScript and external CSS with the current HTML document.
    *
    *  MDN
    */
  def link: VNode = vnode("link")

  /**
    * Defines metadata that can't be defined using another HTML element.
    *
    *  MDN
    */
  def meta: VNode = vnode("meta")

  /**
    * Defines either an internal script or a link to an external script. The
    * script language is JavaScript.
    *
    *  MDN
    */
  def script: VNode = vnode("script")

  /**
    * Represents the content of an HTML document. There is only one body
    *   element in a document.
    *
    *  MDN
    */
  def body: VNode = vnode("body")

  // Sections

  /**
    * Heading level 1
    *
    *  MDN
    */
  def h1: VNode = vnode("h1")

  /**
    * Heading level 2
    *
    *  MDN
    */
  def h2: VNode = vnode("h2")

  /**
    * Heading level 3
    *
    *  MDN
    */
  def h3: VNode = vnode("h3")

  /**
    * Heading level 4
    *
    *  MDN
    */
  def h4: VNode = vnode("h4")

  /**
    * Heading level 5
    *
    *  MDN
    */
  def h5: VNode = vnode("h5")

  /**
    * Heading level 6
    *
    *  MDN
    */
  def h6: VNode = vnode("h6")

  /**
    * Defines the header of a page or section. It often contains a logo, the
    * title of the Web site, and a navigational table of content.
    *
    *  MDN
    */
  def header: VNode = vnode("header")

  /**
    * Defines the footer for a page or section. It often contains a copyright
    * notice, some links to legal information, or addresses to give feedback.
    *
    *  MDN
    */
  def footer: VNode = vnode("footer")

  // Grouping content

  /**
    * Defines a portion that should be displayed as a paragraph.
    *
    *  MDN
    */
  def p: VNode = vnode("p")

  /**
    * Represents a thematic break between paragraphs of a section or article or
    * any longer content.
    *
    *  MDN
    */
  def hr: VNode = vnode("hr")

  /**
    * Indicates that its content is preformatted and that this format must be
    * preserved.
    *
    *  MDN
    */
  def pre: VNode = vnode("pre")

  /**
    * Represents a content that is quoted from another source.
    *
    *  MDN
    */
  def blockQuote: VNode = vnode("blockquote")

  /**
    * Defines an ordered list of items.
    *
    *  MDN
    */
  def ol: VNode = vnode("ol")

  /**
    * Defines an unordered list of items.
    *
    *  MDN
    */
  def ul: VNode = vnode("ul")

  /**
    * Defines an item of an list.
    *
    *  MDN
    */
  def li: VNode = vnode("li")

  /**
    * Defines a definition list; a list of terms and their associated definitions.
    *
    *  MDN
    */
  def dl: VNode = vnode("dl")

  /**
    * Represents a term defined by the next dd
    *
    *  MDN
    */
  def dt: VNode = vnode("dt")

  /**
    * Represents the definition of the terms immediately listed before it.
    *
    *  MDN
    */
  def dd: VNode = vnode("dd")

  /**
    * Represents a figure illustrated as part of the document.
    *
    *  MDN
    */
  def figure: VNode = vnode("figure")

  /**
    * Represents the legend of a figure.
    *
    *  MDN
    */
  def figCaption: VNode = vnode("figcaption")

  /**
    * Represents a generic container with no special meaning.
    *
    *  MDN
    */
  def div: VNode = vnode("div")

  // Text-level semantics

  /**
    * Represents a hyperlink, linking to another resource.
    *
    *  MDN
    */
  def a: VNode = vnode("a")

  /**
    * Represents emphasized text.
    *
    *  MDN
    */
  def em: VNode = vnode("em")

  /**
    * Represents especially important text.
    *
    *  MDN
    */
  def strong: VNode = vnode("strong")

  /**
    * Represents a side comment; text like a disclaimer or copyright, which is not
    * essential to the comprehension of the document.
    *
    *  MDN
    */
  def small: VNode = vnode("small")

  /**
    * Strikethrough element, used for that is no longer accurate or relevant.
    *
    *  MDN
    */
  def s: VNode = vnode("s")

  /**
    * Represents the title of a work being cited.
    *
    *  MDN
    */
  def cite: VNode = vnode("cite")

  /**
    * Represents computer code.
    *
    *  MDN
    */
  def code: VNode = vnode("code")

  /**
    * Subscript tag
    *
    *  MDN
    */
  def sub: VNode = vnode("sub")

  /**
    * Superscript tag.
    *
    *  MDN
    */
  def sup: VNode = vnode("sup")

  /**
    * Italicized text.
    *
    *  MDN
    */
  def i: VNode = vnode("i")

  /**
    * Bold text.
    *
    *  MDN
    */
  def b: VNode = vnode("b")

  /**
    * Underlined text.
    *
    *  MDN
    */
  def u: VNode = vnode("u")

  /**
    * Represents text with no specific meaning. This has to be used when no other
    * text-semantic element conveys an adequate meaning, which, in this case, is
    * often brought by global attributes like class, lang, or dir.
    *
    *  MDN
    */
  def span: VNode = vnode("span")

  /**
    * Represents a line break.
    *
    *  MDN
    */
  def br: VNode = vnode("br")

  /**
    * Represents a line break opportunity, that is a suggested point for wrapping
    * text in order to improve readability of text split on several lines.
    *
    *  MDN
    */
  def wbr: VNode = vnode("wbr")

  // Edits

  /**
    * Defines an addition to the document.
    *
    *  MDN
    */
  def ins: VNode = vnode("ins")

  /**
    * Defines a remodef from the document.
    *
    *  MDN
    */
  def del: VNode = vnode("del")

  // Embedded content

  /**
    * Represents an image.
    *
    *  MDN
    */
  def img: VNode = vnode("img")

  /**
    * Represents a nested browsing context, that is an embedded HTML document.
    *
    *  MDN
    */
  def iframe: VNode = vnode("iframe")

  /**
    * Represents a integration point for an external, often non-HTML, application
    * or interactive content.
    *
    *  MDN
    */
  def embed: VNode = vnode("embed")

  /**
    * Represents an external resource, which is treated as an image, an HTML
    * sub-document, or an external resource to be processed by a plug-in.
    *
    *  MDN
    */
  def `object`: VNode = vnode("object")

  /**
    * Defines parameters for use by plug-ins invoked by object elements.
    *
    *  MDN
    */
  def param: VNode = vnode("param")

  /**
    * Represents a video, and its associated audio files and captions, with the
    * necessary interface to play it.
    *
    *  MDN
    */
  def video: VNode = vnode("video")

  /**
    * Represents a sound or an audio stream.
    *
    *  MDN
    */
  def audio: VNode = vnode("audio")

  /**
    * Allows the authors to specify alternate media resources for media elements
    * like video or audio
    *
    *  MDN
    */
  def source: VNode = vnode("source")

  /**
    * Allows authors to specify timed text track for media elements like video or
    * audio
    *
    *  MDN
    */
  def track: VNode = vnode("track")

  /**
    * Represents a bitmap area that scripts can use to render graphics like graphs,
    * games or any visual images on the fly.
    *
    *  MDN
    */
  def canvas: VNode = vnode("canvas")

  /**
    * In conjunction with area, defines an image map.
    *
    *  MDN
    */
  def map: VNode = vnode("map")

  /**
    * In conjunction with map, defines an image map
    *
    *  MDN
    */
  def area: VNode = vnode("area")

  // Tabular data

  /**
    * Represents data with more than one dimension.
    *
    *  MDN
    */
  def table: VNode = vnode("table")

  /**
    * The title of a table.
    *
    *  MDN
    */
  def caption: VNode = vnode("caption")

  /**
    * A set of columns.
    *
    *  MDN
    */
  def colGroup: VNode = vnode("colgroup")

  /**
    * A single column.
    *
    *  MDN
    */
  def col: VNode = vnode("col")

  /**
    * The table body.
    *
    *  MDN
    */
  def tbody: VNode = vnode("tbody")

  /**
    * The table headers.
    *
    *  MDN
    */
  def thead: VNode = vnode("thead")

  /**
    * The table footer.
    *
    *  MDN
    */
  def tfoot: VNode = vnode("tfoot")

  /**
    * A single row in a table.
    *
    *  MDN
    */
  def tr: VNode = vnode("tr")

  /**
    * A single cell in a table.
    *
    *  MDN
    */
  def td: VNode = vnode("td")

  /**
    * A header cell in a table.
    *
    *  MDN
    */
  def th: VNode = vnode("th")

  // Forms

  /**
    * Represents a form, consisting of controls, that can be submitted to a
    * server for processing.
    *
    *  MDN
    */
  def form: VNode = vnode("form")

  /**
    * A set of fields.
    *
    *  MDN
    */
  def fieldSet: VNode = vnode("fieldset")

  /**
    * The caption for a fieldset.
    *
    *  MDN
    */
  def legend: VNode = vnode("legend")

  /**
    * The caption of a single field
    *
    *  MDN
    */
  def label: VNode = vnode("label")

  /**
    * A typed data field allowing the user to input data.
    *
    *  MDN
    */
  def input: VNode = vnode("input")

  /**
    * A button
    *
    *  MDN
    */
  def button: VNode = vnode("button")

  /**
    * A control that allows the user to select one of a set of options.
    *
    *  MDN
    */
  def select: VNode = vnode("select")

  /**
    * A set of predefined options for other controls.
    *
    *  MDN
    */
  def dataList: VNode = vnode("datalist")

  /**
    * A set of options, logically grouped.
    *
    *  MDN
    */
  def optGroup: VNode = vnode("optgroup")

  /**
    * An option in a select element.
    *
    *  MDN
    */
  def option: VNode = vnode("option")

  /**
    * A multiline text edit control.
    *
    *  MDN
    */
  def textArea: VNode = vnode("textarea")
}
