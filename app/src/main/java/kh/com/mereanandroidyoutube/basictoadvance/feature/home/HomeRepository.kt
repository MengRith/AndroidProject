package kh.com.mereanandroidyoutube.basictoadvance.feature.home

import kh.com.exercise.model.BaseUiState
import kh.com.exercise.model.general.MaterialComponentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepository {
    fun getHomeData(): Flow<BaseUiState<List<MaterialComponentModel>>> = flow {
        emit(BaseUiState.Loading)
        val componentList = listOf(
            MaterialComponentModel(
                id = 1,
                title = "Button",
                description = "Buttons allow users to take actions, and make choices, with a single tap.",
                routeProvider = { "button" },
                icon = "https://developer.android.com/static/images/jetpack/compose/components/buttons.png"
            ),
            MaterialComponentModel(
                id = 2,
                title = "Badge",
                description = "A badge is a small visual indicator of a status or a numerical value.",
                routeProvider = { "badge" },
                icon = "https://developer.android.com/static/images/jetpack/compose/components/badges.png"
            ),
            MaterialComponentModel(
                id = 3,
                title = "Lazy Column",
                description = "A vertically scrolling list that only composes and lays out the currently visible items.",
                routeProvider = { "lazy_column" },
                icon = "https://developer.android.com/static/images/jetpack/compose/layout-lazy-column.png"
            ),
            MaterialComponentModel(
                id = 4,
                title = "Lazy Row",
                description = "A horizontally scrolling list that only composes and lays out the currently visible items.",
                routeProvider = { "lazy_row" },
                icon = "https://developer.android.com/static/images/jetpack/compose/layout-lazy-row.png"
            ),
        )
        emit(BaseUiState.Success(componentList))
    }
}
