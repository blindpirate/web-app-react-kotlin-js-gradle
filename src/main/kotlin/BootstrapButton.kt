@file:JsModule("react-bootstrap/Button")
@file:JsNonModule

import react.RClass
import react.RProps

@JsName("default")
external val BootstrapButton: RClass<BootstrapButtonProps>

external interface BootstrapButtonProps : RProps {
    var variant: String
}

