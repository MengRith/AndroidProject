package kh.com.mereanandroidyoutube.basictoadvance.data.storage

import kh.com.exercise.model.general.MaterialComponentModel
import kh.com.mereanandroidyoutube.basictoadvance.navigation.NavKey

private fun icon(name: String, style: String = "color") =
    "https://img.icons8.com/$style/96/$name.png"

val componentList = listOf(
    MaterialComponentModel(
        1,
        "Badge",
        "A small circle that can contain a number or icon",
        NavKey::Badge,
        "https://img.icons8.com/color/96/badge.png",
    ),
    MaterialComponentModel(
        2,
        "Bottom Sheet",
        "A surface anchored to the bottom of the screen for secondary content",
        NavKey::BottomSheet,
        icon("bottom-sheet", "fluency")
    ),
    MaterialComponentModel(
        3,
        "Buttons",
        "Common button types that trigger actions",
        NavKey::Buttons,
        icon("button")
    ),
    MaterialComponentModel(
        4,
        "Cards",
        "Containers that group related content and actions",
        NavKey::Cards,
        icon("card-in-use")
    ),
    MaterialComponentModel(
        5,
        "Carousel",
        "Scrollable collection of items with snapping behavior",
        NavKey::Carousel,
        icon("carousel")
    ),
    MaterialComponentModel(
        6,
        "CheckBox",
        "Select one or more items from a set",
        NavKey::CheckBox,
        icon("checkbox")
    ),
    MaterialComponentModel(
        7,
        "Chip",
        "Compact elements for filters, inputs, or suggestions",
        NavKey::Chip,
        icon("tags")
    ),
    MaterialComponentModel(
        8,
        "Column",
        "Arranges children vertically",
        NavKey::ColumnScreen,
        icon("column")
    ),
    MaterialComponentModel(
        9,
        "Date Picker",
        "Pick a date from a calendar",
        NavKey::DatePicker,
        icon("calendar")
    ),
    MaterialComponentModel(
        10,
        "Dialog",
        "Prompts the user for a decision or information",
        NavKey::Dialog,
        icon("chat-message")
    ),
    MaterialComponentModel(
        11,
        "Full Screen Dialog",
        "A dialog that fills the entire screen for complex tasks",
        NavKey::FullScreenDialog,
        icon("fullscreen")
    ),
    MaterialComponentModel(
        12,
        "Elevated Button",
        "Button with a shadow to separate it from the surface",
        NavKey::ElevatedButton,
        icon("button")
    ),
    MaterialComponentModel(
        13,
        "Filled Tonal Button",
        "Medium-emphasis button with a tonal fill",
        NavKey::FilledTonalButton,
        icon("button")
    ),
    MaterialComponentModel(
        14,
        "Icon Button",
        "A button that displays only an icon",
        NavKey::IconButton,
        icon("touch-id")
    ),
    MaterialComponentModel(
        15,
        "LazyColumn",
        "Vertically scrolling list that composes only visible items",
        NavKey::ScreenLazyColumn,
        icon("list")
    ),
    MaterialComponentModel(
        16,
        "LazyRow",
        "Horizontally scrolling list that composes only visible items",
        NavKey::LazyRowScreen,
        icon("horizontal-timeline")
    ),
    MaterialComponentModel(
        17,
        "Menu",
        "Displays a list of choices on a temporary surface",
        NavKey::Menu,
        icon("menu")
    ),
    MaterialComponentModel(
        18,
        "Bottom Navigation Bar",
        "Navigate between top-level destinations",
        NavKey::BottomNavigationBar,
        icon("navigation-toolbar-bottom")
    ),
    MaterialComponentModel(
        19,
        "Navigation Drawer",
        "Side panel for app navigation",
        NavKey::NavigationDrawer,
        icon("menu-rounded")
    ),
    MaterialComponentModel(
        20,
        "Outline Button",
        "Medium-emphasis button with a border",
        NavKey::OutlineButton,
        icon("button")
    ),
    MaterialComponentModel(
        21,
        "Progress Indicator",
        "Shows the status of an ongoing operation",
        NavKey::ProgressIndicator,
        icon("progress-indicator")
    ),
    MaterialComponentModel(
        22,
        "Radio",
        "Select exactly one option from a set",
        NavKey::Radio,
        icon("radio-button")
    ),
    MaterialComponentModel(
        23,
        "Row",
        "Arranges children horizontally",
        NavKey::RowScreen,
        icon("row")
    ),
    MaterialComponentModel(
        24,
        "Scaffold",
        "Basic Material layout structure with slots",
        NavKey::ScaffoldScreen,
        icon("layout")
    ),
    MaterialComponentModel(
        25,
        "Multi-Choice Segmented Button",
        "Segmented buttons allowing multiple selections",
        NavKey::MultiChoiceSegmentButton,
        icon("checked-checkbox")
    ),
    MaterialComponentModel(
        26,
        "Single-Choice Segmented Button",
        "Segmented buttons allowing one selection",
        NavKey::SingleChoiceSegmentedButton,
        icon("toggle-on")
    ),
    MaterialComponentModel(
        27,
        "Slider",
        "Select a value from a range",
        NavKey::Slider,
        icon("slider")
    ),
    MaterialComponentModel(
        28,
        "SnackBar",
        "Brief messages about app processes at the bottom",
        NavKey::SnackBar,
        icon("sms")
    ),
    MaterialComponentModel(
        29,
        "Spacer",
        "Adds empty space between components",
        NavKey::SpacerScreen,
        icon("space")
    ),
    MaterialComponentModel(
        30,
        "Switch",
        "Toggle a single setting on or off",
        NavKey::Switch,
        icon("toggle-on")
    ),
    MaterialComponentModel(
        31,
        "Tabs",
        "Organize content across different views",
        NavKey::Tabs,
        icon("tabs")
    ),
    MaterialComponentModel(
        32,
        "Text Button",
        "Low-emphasis button without a container",
        NavKey::TextButton,
        icon("text")
    ),
    MaterialComponentModel(
        33,
        "TextField",
        "Lets users enter and edit text",
        NavKey::TextField,
        icon("text-box")
    ),
    MaterialComponentModel(
        34,
        "Time Picker",
        "Pick a time using a clock or input",
        NavKey::TimePicker,
        icon("clock")
    ),
    MaterialComponentModel(
        35,
        "Toolbar",
        "A bar of actions related to the current screen",
        NavKey::Toolbar,
        icon("toolbox")
    ),
    MaterialComponentModel(
        36,
        "ToolTips",
        "Short text explaining an element on hover or long-press",
        NavKey::ToolTips,
        icon("info")
    ),
    MaterialComponentModel(
        37,
        "Box",
        "Stacks children on top of each other",
        NavKey::BoxScreen,
        icon("box")
    ),
    MaterialComponentModel(
        38,
        "Top App Bar",
        "Title and actions at the top of a screen",
        NavKey::TopAppBarScreen,
        icon("navigation-toolbar-top")
    ),
    MaterialComponentModel(
        39,
        "State & ViewModel",
        "Manage UI state with a ViewModel",
        NavKey::StateViewModelScreen,
        icon("data-configuration")
    ),
)