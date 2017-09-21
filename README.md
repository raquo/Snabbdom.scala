# Snabbdom.scala – Virtual DOM for Scala.js

This is a [Scala.js](https://github.com/scala-js/scala-js) interface to [Snabbdom.js](https://github.com/snabbdom/snabbdom), a popular virtual DOM library with a focus on simplicity, modularity, powerful features and performance.

The main goal of Snabbdom is to provide an easily extensible foundation for building frontend libraries that need to manipulate DOM. Other than "you need a virtual DOM", Snabbdom doesn't have an opinion on how to structure your frontend code other than, it is rather low-level. It is well suited to be used in all kinds of UI libraries including those that work on Streams and Observables.

Many Javascript libraries use Snabbdom.js under the hood, for example [Vue.js](https://github.com/vuejs/vue), [Cycle.js](https://github.com/cyclejs/cyclejs/), [Kaiju](https://github.com/AlexGalays/kaiju).

In Scala.js world, [Outwatch](https://github.com/OutWatch/outwatch) uses Snabbdom.js (although not Snabbdom.scala).

## Basic Usage

```scala
import com.raquo.snabbdom
import com.raquo.snabbdom.attrs.size
import com.raquo.snabbdom.events.onChange
import com.raquo.snabbdom.Snabbdom
import com.raquo.snabbdom.styles.opacity
import com.raquo.snabbdom.tags.{div, input}
import org.scalajs.dom
 
val foo: dom.Event => Unit = ??? 
 
// Initialize snabbdom
val container = dom.document.getElementById("my-app-container")
val patch = Snabbdom.init(snabbdom.modules)
 
// Create a virtual node
val node = div(
  opacity := 0.5,
  "Please enter a value: ",
  input(
    size := 3,
    onChange := foo 
  )
)
 
// Mount the virtual node
patch(container, node)
 
// Update the virtual node with a different opacity
val newNode = node.copy()
newNode(opacity := 0.7)
 
// Apply the change to the DOM
patch(node, newNode)
```

## Status

Snabbdom.js is an established, well respected JS library with a long history.

Snabbdom.scala is a Scala.js interface to it. Although I've just released it, I have been working on it for quite some time now, and it is pretty much feature-complete. I've been using it internally with great results.

## Features

### Type-safe builders for virtual nodes

This part of the API is similar to [ScalaTags](https://github.com/lihaoyi/scalatags````). However, it does not depend on ScalaTags, but rather uses my own implementation of a similar interface, the primary reason being to provide more type safety. For example, in Snabbdom.scala you can't give an integer attribute a string value. 

### Extensible

Snabbdom.scala provides a type-safe way to extend core Snabbdom functionality.

* Write Snabbdom modules in Scala. A Snabbdom.scala module is simply an instance of `ModuleHooks` with pretty much the same API as native Snabbdom modules. 

* Extend `Node` and `NodeData` classes to provide any kind of logic you need. Snabbdom.scala itself gives you the canonical `VNode` and `VNodeData` which have no special logic in them. If you were building a UI library on top of Snabbdom or creating a Snabbdom module, you would instead create `MyNode extends Node` and `MyNodeData extends NodeData`.

* Use existing Snabbdom.js modules written in Javascript. Those should work as-is if they do not create or modify the virtual nodes themselves. This use case is not a priority for me right now, so I haven't tested this and don't plan to in the observable future.

Out of the box Snabbdom.scala supports the following Snabbdom.js modules: attrs, props, events, styles.

_I am currently wrapping up v0.1 of my FRP UI library which uses Snabbdom.scala, once I publish it in a few days you will see a good example of extending Snabbdom.scala._

### Testing Utils

Snabbdom.Scala comes with convenient testing utils. These are generic enough that you can use them to test your Snabbdom-based UI library by simply providing a couple type params.

@TODO: use the new generic [Scala DOM Test Utils](https://github.com/raquo/scala-dom-testutils) package which was based on this design

Example from Snabbdom.scala's own test suite:

```scala
val expectedTitle1 = randomString("title1_")
val expectedTitle2 = randomString("title2_")
val expectedText1 = randomString("text1_")
val expectedText2 = randomString("text2_")
val expectedColSpan = Random.nextInt(15)
val expectedRowSpan = 15 + Random.nextInt(7)
 
mount(
  td(
    colSpan := expectedColSpan,
    rowSpan := expectedRowSpan,
    span(
      title := expectedTitle1,
      expectedText1,
      span(
        expectedText2,
        title := expectedTitle2
      )
    ),
    span()
  )
)
 
expectNode(
  td like(
    colSpan is expectedColSpan,
    rowSpan is expectedRowSpan,
    title isEmpty,
    span like(
      title is expectedTitle1,
      colSpan isEmpty,
      rowSpan isEmpty,
      expectedText1,
      span like(
        title is expectedTitle2,
        colSpan isEmpty,
        rowSpan isEmpty,
        expectedText2
      )
    ),
    span
  )
)
```

In this example, `expectNode` verifies that the real DOM element produced by snabbdom (not the virtual node) matches the description provided to it.

Snabbdom's own tests run with ScalaTest, but the latter is not required to use the testing utils. 

## Differences from Snabbdom.js

* Snabbdom.scala does not provide an `h` function to build virtual nodes, and thus any logic that lives there is absent from Snabbdom.scala. You should use the type-safe node builders we provide instead.
* Snabbdom.scala does not store class names and IDs in `.sel` property of the node. However, there are performance advantages to using .sel for more than just tag name because Snabbdom's `sameVnode` method uses it to decide whether to patch or re-create DOM nodes. It is not yet clear to me which way is the best way. I'm not sure if shoving all classes into `.sel` is a good idea because in web application code it is common to toggle CSS classes just for styling (e.g. visibility).
* Snabbdom.scala does not use the `.text` property on nodes that have a `.sel`. Instead, we create an empty text node when given a string as a child. This makes things easier when using the builder pattern, and when you're updating the node with new children. 

## Author

Nikita Gazarov – [raquo.com](http://raquo.com)

## License

Snabbdom.scala is provided under MIT license.
