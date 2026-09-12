package kh.com.mereanandroidyoutube.basictoadvance.feature.navigationbar

import androidx.annotation.DrawableRes

data class NavigationBottomItem(
    @DrawableRes val icon: Int,
    val text : String,
    val enabled: Boolean = true,
)
