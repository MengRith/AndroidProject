package kh.com.mereanandroidyoutube.basictoadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.MultiChoiceSegmentedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.SingleChoiceSegmentedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.checkbox.ScreenCheckBox
import kh.com.mereanandroidyoutube.basictoadvance.feature.chip.ScreenChip
import kh.com.mereanandroidyoutube.basictoadvance.feature.dialog.ScreenDialog
import kh.com.mereanandroidyoutube.basictoadvance.feature.dialog.ScreenFullDialog
import kh.com.mereanandroidyoutube.basictoadvance.feature.lazyrow.MaterialComponentModal
import kh.com.mereanandroidyoutube.basictoadvance.feature.menu.ScreenMenu
import kh.com.mereanandroidyoutube.basictoadvance.feature.navigationbar.ScreenNavigationBar
import kh.com.mereanandroidyoutube.basictoadvance.feature.navigationdrawer.ScreenNavigationDrawer
import kh.com.mereanandroidyoutube.basictoadvance.feature.progressindicator.ScreenProgressIndicator
import kh.com.mereanandroidyoutube.basictoadvance.feature.radio.ScreenRadio
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.feature.scaffold.ScaffoldExample
import kh.com.mereanandroidyoutube.basictoadvance.feature.screendatepicker.ScreenDatePicker
import kh.com.mereanandroidyoutube.basictoadvance.feature.timepicker.ScreenTimePicker

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
                ScreenRadio {  }




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