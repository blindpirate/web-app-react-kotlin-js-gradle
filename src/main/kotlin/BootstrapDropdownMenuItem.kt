import common.ui.bootstrap.Dropdown
import react.RClass
import react.RProps

val DropdownMenu : RClass<DropdownMenuProps> = Dropdown.asDynamic().Menu

val DropdownItem : RClass<DropdownItemProps> = Dropdown.asDynamic().Item
val DropdownToggle : RClass<DropdownToggleProps> = Dropdown.asDynamic().Toggle

external interface DropdownMenuProps : RProps {
}

external interface DropdownItemProps : RProps {
    var href: String
}

external interface DropdownToggleProps : RProps {
    var id: String
    var variant: String
}
