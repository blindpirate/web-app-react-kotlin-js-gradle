@file:JsModule("react-bootstrap/Overlay")
@file:JsNonModule

package common.ui.bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapOverlay: RClass<BootstrapOverlayProps>

external interface BootstrapOverlayProps : RProps {
    var container: Any
    var target: Any?
    var show: Boolean
    var placement: Any
}
