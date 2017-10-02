package com.raquo.snabbdom

import com.raquo.domtypes.generic.defs.styles.{Styles, Styles2}
import com.raquo.domtypes.generic.keys.{Attr, EventProp, Prop, Style}
import com.raquo.domtypes.jsdom.builders.EventPropBuilder
import com.raquo.domtypes.generic.builders.{AttrBuilder, PropBuilder}
import com.raquo.domtypes.generic.defs.attrs.{Attrs, GlobalAttrs, InputAttrs}
import com.raquo.domtypes.generic.defs.props.Props
import com.raquo.domtypes.jsdom.defs.eventProps.{ClipboardEventProps, ErrorEventProps, FormEventProps, KeyboardEventProps, MouseEventProps}
import com.raquo.domtypes.generic.defs.sameRefTags.{DocumentTags, EmbedTags, FormTags, GroupingTags, MiscTags, SectionTags, TableTags, TextTags}
import com.raquo.snabbdom.keys.KeyKey

package object simple {

  // @TODO Add types that don't need [Attr]?

  /** Import `implicits._` to get access to composition methods := and TagSyntax.apply */
  object implicits extends syntax.Implicits[VNode, VNodeData]

  object attrs
    extends Attrs[Attr]
    with InputAttrs[Attr]
    with GlobalAttrs[Attr]
    with AttrBuilder

  object props
    extends Props[Prop]
    with PropBuilder // @TODO add more `with`?

  object events
    extends MouseEventProps[EventProp]
    with FormEventProps[EventProp]
    with KeyboardEventProps[EventProp]
    with ClipboardEventProps[EventProp]
    with ErrorEventProps[EventProp]
    with EventPropBuilder

  object tags
    extends DocumentTags[SimpleTag, VNode]
    with GroupingTags[SimpleTag, VNode]
    with TextTags[SimpleTag, VNode]
    with FormTags[SimpleTag, VNode]
    with SectionTags[SimpleTag, VNode]
    with EmbedTags[SimpleTag, VNode]
    with TableTags[SimpleTag, VNode]
    with SimpleTagBuilder

  object tags2
    extends MiscTags[SimpleTag, VNode]
    with SimpleTagBuilder

  object styles
    extends Styles[Modifier[VNode, VNodeData]]
    with SimpleStyleBuilders

  object styles2
    extends Styles2[Modifier[VNode, VNodeData]]
    with SimpleStyleBuilders

  val comment: () => VNode = () => new VNode("!")

  /** Setter of snabbdom's special key property */
  val key = new KeyKey
}
