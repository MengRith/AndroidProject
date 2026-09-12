package kh.com.mereanandroidyoutube.basictoadvance.feature.navigationdrawer

import androidx.annotation.DrawableRes

data class NavigationItem(
    @DrawableRes val icon: Int,
    val label : String,
    val enabled: Boolean = true,
    val alwaysShowLabel: Boolean = true,
)
