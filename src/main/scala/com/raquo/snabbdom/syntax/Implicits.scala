package com.raquo.snabbdom.syntax

import com.raquo.domtypes.generic.builders.Tag
import com.raquo.domtypes.generic.keys.{Attr, EventProp, Prop, Style}
import com.raquo.snabbdom.keys.KeyKey
import com.raquo.snabbdom.nodes.{Node, NodeData}
import org.scalajs.dom

trait Implicits[N <: Node[N, D], D <: NodeData[N, D]] {

  implicit def tagToSyntax(tag: Tag[N]): TagSyntax[N, D] = new TagSyntax[N, D](tag)

  implicit def attrToSyntax[V](attr: Attr[V]): AttrSyntax[V, N, D] = new AttrSyntax[V, N, D](attr)

  implicit def eventPropToSyntax[Ev <: dom.Event](eventProp: EventProp[Ev]): EventPropSyntax[Ev, N, D] = new EventPropSyntax[Ev, N, D](eventProp)

  implicit def keyToSyntax[V](key: KeyKey): KeySyntax[N, D] = new KeySyntax[N, D](key)

  implicit def propToSyntax[V](prop: Prop[V]): PropSyntax[V, N, D] = new PropSyntax[V, N, D](prop)

  implicit def intStyleToSyntax(style: Style[Int]): StyleSyntax[Int, N, D] = new StyleSyntax[Int, N, D](style)

  implicit def doubleStyleToSyntax(style: Style[Double]): StyleSyntax[Double, N, D] = new StyleSyntax[Double, N, D](style)

  implicit def stringStyleToSyntax[V](style: Style[String]): StringStyleSyntax[N, D] = new StringStyleSyntax[N, D](style)
}
