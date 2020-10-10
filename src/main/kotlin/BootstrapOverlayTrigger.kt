@file:JsModule("react-bootstrap/OverlayTrigger")
@file:JsNonModule

package common.ui.bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapOverlayTrigger: RClass<BootstrapOverlayTriggerProps>

external interface BootstrapOverlayTriggerProps : RProps {
    var defaultShow: Boolean
    var delay: Any
    var overlay: Any

    /*
    'auto-start' | 'auto' | 'auto-end' | 'top-start' |
     'top' | 'top-end' | 'right-start' | 'right' | 'right-end' |
     'bottom-end' | 'bottom' | 'bottom-start' | 'left-end' | 'left' | 'left-start'
     */
    var placement: String
    var trigger: String
}
