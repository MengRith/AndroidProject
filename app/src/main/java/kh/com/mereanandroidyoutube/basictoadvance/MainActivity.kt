package kh.com.mereanandroidyoutube.basictoadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.com.mereanandroidyoutube.basictoadvance.navigation.BaseNavigation
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.util.LoadingUtil

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT,
            ),
        )

        setContent {
            AppTheme {
                LoadingUtil.LoadingDialog()
                BaseNavigation()
            }
        }
    }
}
