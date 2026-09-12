package kh.com.mereanandroidyoutube.basictoadvance.someexercises.Youtube

import androidx.annotation.DrawableRes

data class YoutubeNavigationBottomItem(
    @DrawableRes val icon: Int,
    val text : String,
    val enabled: Boolean = true,
)
