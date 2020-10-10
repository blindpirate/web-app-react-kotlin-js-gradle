@file:JsModule("react-bootstrap/Popover")
@file:JsNonModule

package common.ui.bootstrap

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapPopover: RClass<BootstrapPopoverProps>

external interface BootstrapPopoverProps : RProps {
    var id: String
}
