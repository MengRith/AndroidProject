package kh.com.mereanandroidyoutube.basictoadvance.feature.menu

import androidx.compose.ui.graphics.Color

data class MenuItemModal(
    val text: String,
    val onClick: () -> Unit,
    val leadingIcon: Int? = null,
    val trailingIcon: Int? = null,
    val enabled: Boolean = true,
    val backgroundColor: Color? = null,
)
