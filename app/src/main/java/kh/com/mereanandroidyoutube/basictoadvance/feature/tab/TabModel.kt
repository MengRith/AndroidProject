package kh.com.mereanandroidyoutube.basictoadvance.feature.tab

import androidx.annotation.DrawableRes

data class TabModel(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int,
)
