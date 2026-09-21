package kh.com.mereanandroidyoutube.basictoadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kh.com.mereanandroidyoutube.basictoadvance.feature.scaffold.ScaffoldExample
import kh.com.mereanandroidyoutube.basictoadvance.feature.snackbar.ScreenSnackBar
import kh.com.mereanandroidyoutube.basictoadvance.feature.switchcomponent.ScreenSwitchComponent
import kh.com.mereanandroidyoutube.basictoadvance.feature.tab.ScreenTab
import kh.com.mereanandroidyoutube.basictoadvance.feature.textfield.ScreenTextField
import kh.com.mereanandroidyoutube.basictoadvance.navigation.BaseNavigation
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.util.LoadingUtil
import kh.com.mereanandroidyoutube.model.BaseUiState


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = android.graphics.Color.TRANSPARENT,
                darkScrim = android.graphics.Color.TRANSPARENT,
            ),
            navigationBarStyle = SystemBarStyle.auto(
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

@Preview
@Composable
fun AppPreview() {
    AppTheme {
    }
}