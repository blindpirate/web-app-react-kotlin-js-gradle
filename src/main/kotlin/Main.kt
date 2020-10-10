import common.ui.bootstrap.BootstrapPopover
import common.ui.bootstrap.BootstrapPopoverTitle
import common.ui.bootstrap.BootstrapTooltip
import common.ui.bootstrap.BootstrapTooltipProps
import kotlinext.js.assign
import kotlinext.js.js
import kotlinext.js.jsObject
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.html.*
import kotlinx.html.js.onDragOverFunction
import kotlinx.html.js.onDragStartFunction
import kotlinx.html.js.onDropFunction
import org.w3c.dom.events.Event
import org.w3c.files.Blob
import react.*
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.render
import styled.css
import styled.styledDiv
import styled.styledImg
import kotlin.reflect.KClass

data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

class EventBus {
    fun addEventListener(type: String, callback: ((Event) -> Unit)) {
        window.addEventListener(type, callback)
    }

    //    fun addEventListener(type: String, callback: ((Event) -> Unit)?, options: dynamic = definedExternally)
//    fun removeEventListener(type: String, callback: EventListener?, options: dynamic = definedExternally)
//    fun removeEventListener(type: String, callback: ((Event) -> Unit)?, options: dynamic = definedExternally)
    fun dispatchEvent(event: Event): Boolean {
        return window.dispatchEvent(event)
    }
}

//class MyEvent : Event {
//    constructor() {
//        super("hahaha")
//    }
//}

//fun download(fileName:String, data:String) {
//    val blob = Blob(arrayOf(data))
//    val aTag = document.createElement("a")
//    aTag.setAttribute("")
//
//}

val divs = arrayOf("green", "red", "blue")

class DragTest : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        divs.forEachIndexed { index, name ->
            styledDiv {
                attrs.id = "div$index"
                attrs.draggable = Draggable.htmlTrue
                css {
                    width = 100.px
                    height = 20.px
                    border = "1px solid $name"
                }

                +name
                attrs.onDropFunction = {
                    val srcDivIndex: Int = it.asDynamic().dataTransfer.getData("divIndex")
                    if (srcDivIndex != index) {
                        val srcDiv = divs[srcDivIndex]
                        if (srcDivIndex > index) {
                            for (i in (index until srcDivIndex).reversed()) {
                                divs[i + 1] = divs[i]
                            }
                        } else {
                            for (i in srcDivIndex until index) {
                                divs[i] = divs[i + 1]
                            }
                        }

                        divs[index] = srcDiv
                        setState { }
                    }
                }
                attrs.onDragOverFunction = {
                    it.preventDefault()
                }
                attrs.onDragStartFunction = {
                    it.asDynamic().dataTransfer.setData("divIndex", index)
                }
            }
        }
    }
}

fun main() {
    render(document.getElementById("root")) {
        child(DragTest::class) {}
//        styledDiv {
//            attrs.id = "div1"
//            css {
//                width = 100.px
//                height = 100.px
//                padding = "10px"
//                border = "1px solid #aaaaaa"
//            }
//            attrs.onDropFunction = {
//                it.preventDefault()
//                val data = it.asDynamic().dataTransfer.getData("text")
//                it.target.asDynamic().appendChild(document.getElementById(data))
//            }
//            attrs.onDragOverFunction = {
//                it.preventDefault()
//            }
//        }
//
//        styledImg {
//            attrs.id = "drag1"
//            attrs.src = "https://www.w3schools.com/html/img_logo.gif"
//            attrs.draggable = Draggable.htmlTrue
//            attrs.onDragStartFunction = {
//                console.log("drag start!")
//                it.asDynamic().dataTransfer.setData("text", it.target.asDynamic().id)
//            }
//            attrs.width = "336"
//            attrs.height = "69"
//        }

    }
}

fun main4() {
    download("hahaha", "1.txt")
}

fun main3() {
    render(document.getElementById("root")) {
//        absoluteDiv(100, 100, 100, 100, 100) {
//            attrs.id = "test2"
//            +"test2"
//        }
//        absoluteDiv(0, 0, 100, 100, 0, "0") {
//            attrs.id = "test3"
//            +"test3"
//        }
        child(Container::class) {
        }
//        div {
//            attrs.id = "test1"
//            +"test1"
//        }

    }
}

class Container : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        containerFillingDiv(block = {
            attrs.id = "test1"
        })
//        absoluteDiv(100, 100, 100, 100) {
//            attrs.id = "test2"
//        }
    }
}

@Suppress("UnsafeCastFromDynamic")
fun RBuilder.containerFillingDiv(block: RDOMBuilder<DIV>.() -> Unit = {}) {
    absoluteDiv(0, 0, 100, 100, block = block)
}


@Suppress("UnsafeCastFromDynamic")
fun RBuilder.absoluteDiv(
    left: Int, top: Int, width: Int, height: Int,
    styleBuilder: dynamic.() -> Unit = {},
    block: RDOMBuilder<DIV>.() -> Unit = {}
) {
    div {
        attrs {

//            style = js(styleBuilder) {
//                position = "absolute"
//                this.left = "${left}px"
//                this.top = "${top}px"
//                this.width = "${width}px"
//                this.height = "${height}px"
////                this.zIndex = zIndex.toString()
////                this.opacity = opacity
//            }
            block()
        }
    }
}


fun main2() {
    render(document.getElementById("root")) {
        BootstrapPopover {
            attrs.id = "popover-basic"
            BootstrapPopoverTitle {
                +"Right"
            }
            BootstrapPopoverTitle {
                +"xxxx!"
            }

        }

        BootstrapTooltip {
            attrs.id = "my-tooltip"
            attrs.placement = "right"
            attrs.style = js {
                position = "absolute"
                top = "100px"
                left = "100px"
                opacity = "1"
            }

            val arrowStyle = js {
                position = "absolute"
                top = "8px"
                left = "0"
                opacity = "1"
            }
            attrs.arrowProps = js {
//                style = arrowStyle
            }
            +"aaaaaaaaaaaaaaa!"
        }
//        BootstrapOverlayTrigger {
//            attrs.trigger = "click"
//            attrs.placement = "right"
//            attrs.overlay = popover
//            BootstrapButton {
//                +"Click to see"
//            }
//        }
//        BootstrapOverlayTrigger {
//            attrs.placement = "right"
//            attrs.delay = mapOf("show" to 250, "hide" to 400)
//            attrs.overlay = renderTooltip
//            BootstrapButton {
//                attrs.variant = "success"
//                +"hover me to see"
//            }
//        }
    }
}

val renderTooltip = functionalComponent<BootstrapTooltipProps> { props ->
    BootstrapTooltip {
        console.log(props, props.arrowProps)
        attrs.id = "button-tooltip"
        attrs.arrowProps = props.arrowProps
        attrs.placement = "right"
        attrs.popper = props.popper
        attrs.show = props.show
        attrs.bsPrefix = props.bsPrefix
        +"Tooltip"
    }
}

val popover = functionalComponent<RProps> { props ->
    BootstrapPopover {
        attrs.id = "popover-basic"
//        console.log(props)
//        console.log(props.asDynamic().style)
//        attrs.asDynamic().style = props.asDynamic().style
        BootstrapPopoverTitle {
            +"Right"
        }
        BootstrapPopoverTitle {
            +"xxxx!"
        }

    }
}

//val example = functionalComponent<RProps> {
//    val (show, setShow) = useState(false)
//
//    val target = useRef(null)
//
//    button {
//        ref = target
//        attrs.onClickFunction = {
//            setShow(!show)
//        }
//    }
//
//    BootstrapOverlay {
//        attrs.target = target.current
//        attrs.show = show
//        attrs.placement = "right"
//
//        styledDiv {
//            css {
//                backgroundColor = rgba(255, 100, 100, 0.85)
//                padding = "2px 10px"
//                color = Color.white
//            }
//
//            +"Simple tooltip"
//        }
//    }
//
////    useEffect {
////        console.log("useEffect $count")
////    }
////    +"count $count"
////    button {
////        attrs {
////            onClickFunction = {
////                setCount(count + 1)
////            }
////        }
////    }
//}

/*

 */

interface ZIndexed {
    var zIndex: Int
}

interface ZIndexedProps : RProps, ZIndexed {

}

fun <PARENT : ZIndexedProps, CHILD : ZIndexedProps> RElementBuilder<PARENT>.zIndexedChild(
    props: PARENT,
    klazz: KClass<out Component<CHILD, *>>,
    handler: RHandler<CHILD> = {}
): ReactElement {
    return child(klazz) {
        attrs.zIndex = props.zIndex

        handler()
    }
}


abstract class ZIndexedComponent<P : ZIndexedProps, S : RState> : RComponent<P, S>() {
//    fun <P : ZIndexedProps> RElementBuilder<P>.zIndexedChild(
//
//        klazz: KClass<out Component<P, *>>,
//        handler: RHandler<P> = {}
//    ): ReactElement {
//        return child(klazz) {
//            attrs.zIndex = props.zIndex
//
//            handler()
//        }
//    }


//    override fun componentWillReceiveProps(nextProps: P) {
//        super.componentWillReceiveProps(nextProps)
//        props.zIndex = nextProps.zIndex
//    }
}

fun RBuilder.gameContainer(block: RElementBuilder<GameContainerProps>.() -> Unit): ReactElement {
    return child(GameContainer::class, block)
//    {
//        block()
//    }
}

interface GameContainerProps : ZIndexedProps {
    var top: Int
    var left: Int
}

interface MyDivProps : ZIndexedProps

class MyDiv : ZIndexedComponent<MyDivProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                zIndex = props.zIndex
            }
            +"ABC"
        }
    }
}

class GameContainer : ZIndexedComponent<GameContainerProps, RState>() {
    override fun RBuilder.render() {
//        Children.forEachElement(props.children) {
//            it.asDynamic().props = jsObject {
//                zIndex = 123
//            }
////            console.log(it, it.props)
////            console.log("zIndex: ${props.zIndex}")
////            window.asDynamic().props = it.props
////            window.asDynamic().props.zIndex = props.zIndex
////            console.log("${it.props}")
////            console.log("${window.asDynamic().props}")
////            it.props.asDynamic().zIndex = props.zIndex
////            css {
////                zIndex = props.zIndex
////            }
//        }
        styledDiv {
            css {
                position = Position.absolute
                top = props.top.px
                left = props.left.px
            }

            children()
        }
    }

}
//
//data class Item(val text: String, val id: String)
//interface TodoListState : RState {
//    var items: List<Item>
//    var loading: Boolean
//}
//
//var counter = 0
//
//class TodoList : RComponent<RProps, TodoListState>() {
//    init {
//        window.setTimeout({
//            setState {
//                loading = true
//            }
//        }, 5000)
//    }
//
//    override fun TodoListState.init() {
//        items = listOf(
//            Item("111", "1"),
//            Item("222", "2"),
//            Item("333", "3")
//        )
//        loading = false
//    }
//
//    override fun RBuilder.render() {
//        TransitionGroup {
//            attrs.className = "todo-list"
//            if (state.loading) {
//                CSSTransition {
//                    counter++
//                    attrs.key = counter.toString()
//                    attrs.timeout = 1000
//                    attrs.classNames = "item"
//
//                    styledDiv {
//                        css {
//                            width = 100.vw
//                            height = 100.vh
//                            backgroundColor = Color.red
//                        }
//                    }
//                }
//            } else {
//                CSSTransition {
//                    counter++
//                    attrs.key = counter.toString()
//                    attrs.timeout = 1000
//                    attrs.classNames = "item"
//
//                    styledDiv {
//                        css {
//                            width = 100.vw
//                            height = 100.vh
//                            backgroundColor = Color.green
//                        }
//                    }
//                }
//            }
//
//
//            state.items.forEach { thisItem ->
//
////                CSSTransition {
////                    attrs.key = thisItem.id
////                    attrs.timeout = 1000
////                    attrs.classNames = "item"
////
////                    li {
////                        button {
////                            +"x"
////                            attrs.onClickFunction = {
////                                setState {
////                                    val newItems = items.filter { it != thisItem }
////                                    items = newItems
////                                }
////                            }
////                        }
////
////                        +thisItem.text
////                    }
////                }
//            }
//        }
//    }
//}
