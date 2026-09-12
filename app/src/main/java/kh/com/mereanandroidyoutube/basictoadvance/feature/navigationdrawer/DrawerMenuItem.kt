package kh.com.mereanandroidyoutube.basictoadvance.feature.navigationdrawer

import androidx.annotation.DrawableRes

data class DrawerMenuItem(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int,
    val badge: String? = null
)