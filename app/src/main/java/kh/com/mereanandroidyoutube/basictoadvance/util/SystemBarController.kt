package kh.com.mereanandroidyoutube.basictoadvance.util

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun SystemBarController(
    useDarkStatusBarIcons: Boolean = true,
    useDarkNavigationBarIcons: Boolean = true
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = useDarkStatusBarIcons
            insetsController.isAppearanceLightNavigationBars = useDarkNavigationBarIcons
        }
    }
}
