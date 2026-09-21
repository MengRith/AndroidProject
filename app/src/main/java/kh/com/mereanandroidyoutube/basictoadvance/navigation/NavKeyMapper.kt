package kh.com.mereanandroidyoutube.basictoadvance.navigation


import kh.com.mereanandroidyoutube.model.general.MaterialComponentModel
import kh.com.mereanandroidyoutube.model.general.route

fun MaterialComponentModel.toNavKey(): Any = when (route()) {
    "badge" -> NavKey.Badge(this)
    "button" -> NavKey.Buttons(this)
    "lazy_column" -> NavKey.ScreenLazyColumn(this)
    "lazy_row" -> NavKey.LazyRowScreen(this)
    // add one line per remaining NavKey, e.g.
    // "bottom_sheet" -> NavKey.BottomSheet(this)
    else -> error("No NavKey mapped for route ${route()}")
}