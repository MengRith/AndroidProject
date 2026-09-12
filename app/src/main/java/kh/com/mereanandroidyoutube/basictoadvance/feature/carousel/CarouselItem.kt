package kh.com.mereanandroidyoutube.basictoadvance.feature.carousel

import androidx.annotation.DrawableRes

data class CarouselItem(
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
)
