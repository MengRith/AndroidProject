package kh.com.mereanandroidyoutube.basictoadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kh.com.mereanandroidyoutube.basictoadvance.feature.scaffold.ScaffoldExample
import kh.com.mereanandroidyoutube.basictoadvance.feature.snackbar.ScreenSnackBar
import kh.com.mereanandroidyoutube.basictoadvance.feature.switchcomponent.ScreenSwitchComponent
import kh.com.mereanandroidyoutube.basictoadvance.feature.tab.ScreenTab
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
//                ScaffoldExample()
                /*ScreenButton(
                    item = MaterialComponentModal(
                        1,
                        "Button",
                        "Button description",
                        { "" },
                        ""
                    ),
                    onBack = {}
                )*/
                /*SingleChoiceSegmentedButton(
                    onBack = {}
                )*/
//                MultiChoiceSegmentedButton {  }
//                ScreenCheckBox {  }
//                ScreenChip {}
//                ScreenDatePicker {  }
//                ScreenTimePicker {  }
//                ScreenDialog {  }
//                ScreenProgressIndicator {  }
//                ScreenFullDialog { }
//                ScreenMenu { }
//                ScreenNavigationBar{ }
//                ScreenNavigationDrawer { }
//                ScreenRadio {  }
//                ScreenBottomSheet {  }
//                ScreenSlider {  }
//                ScreenSnackBar {  }
//                ScreenSwitchComponent {  }
                ScreenTab {  }

            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AppTheme {
        ScaffoldExample()
    }
}