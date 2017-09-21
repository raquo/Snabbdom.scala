package com.raquo.snabbdom

import com.raquo.snabbdom.simple.implicits._
import com.raquo.snabbdom.simple.tags.div

import scala.scalajs.js

class NodeSpec extends UnitSpec {

  /** Carrying over the node's element to a copied node does not make sense.
    * What do you expect snabbdom to do with it? You don't even know that
    * said element is still attached to the DOM.
    * Also, Laminar uses this behaviour to track which nodes have been mounted.
    */
  it("does not copy element") {
    val node = div()
    mount(node)

    withClue("element should be defined after mounting") {
      node.elm.isDefined shouldBe true
    }

    val nodeCopy = node.copy()
    withClue("element should be empty in copied node") {
      nodeCopy.elm shouldBe js.undefined
    }

    withClue("element should be defined after mounting copied node") {
      patchMounted(nodeCopy)
      nodeCopy.elm.isDefined shouldBe true
    }
  }
}
