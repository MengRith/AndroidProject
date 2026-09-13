package kh.com.mereanandroidyoutube.basictoadvance.feature.switchcomponent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.R.drawable
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSwitchComponent(
    onBack: () -> Unit
) {
    var isEnableNotification by remember { mutableStateOf(false) }
    var isLightMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { onBack() }
                    ) {
                        Icon(
                            painter = painterResource(drawable.ic_backarrow),
                            contentDescription = "Back",
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Switch Component"
                    )
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Enable/Disable Notification")
                Switch(
                    checked = isEnableNotification,
                    onCheckedChange = { enable ->
                        isEnableNotification = enable
                    },
                    thumbContent = {
                        if (isEnableNotification){
                            Icon(
                                painter = painterResource(R.drawable.ic_notifications),
                                contentDescription = "Notification"
                            )
                        }
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Light/Dark mode")
                Switch(
                    checked = isLightMode,
                    onCheckedChange = {isLight ->
                        isLightMode = isLight
                    },
                    thumbContent = {
                        if(isLightMode){
                            Icon(
                                painter = painterResource(R.drawable.ic_light_mode),
                                contentDescription = "Light mode"
                            )
                        }
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
                        checkedTrackColor = MaterialTheme.colorScheme.primary,
                        uncheckedThumbColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        uncheckedTrackColor = MaterialTheme.colorScheme.primaryContainer
                    )

                )
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenSwitchComponentPreview(){
    AppTheme() {
        ScreenSwitchComponent { }
    }
}