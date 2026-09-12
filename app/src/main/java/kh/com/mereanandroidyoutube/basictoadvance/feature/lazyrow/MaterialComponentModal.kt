package kh.com.mereanandroidyoutube.basictoadvance.feature.lazyrow

data class MaterialComponentModal(
    val id: Int,
    val names: String,
    val description: String,
    val onClick: () -> String,
    val icon: String
)
