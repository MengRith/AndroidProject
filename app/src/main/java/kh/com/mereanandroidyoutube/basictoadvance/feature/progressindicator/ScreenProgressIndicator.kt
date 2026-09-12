package kh.com.mereanandroidyoutube.basictoadvance.feature.progressindicator

import android.R.attr.onClick
import android.R.attr.strokeWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Violet80
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenProgressIndicator(
    onBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    //triggers recomposition of anything reading `progress`
    var linearProgress by remember { mutableFloatStateOf(0f) }
    var circularProgress by remember { mutableFloatStateOf(0f) }
//    var progress by remember { mutableFloatStateOf(0f) }
    // show a "done" dialog when progress completes

//    var isShowDialog by remember { mutableStateOf(false) }

    var linearJob : Job? by remember { mutableStateOf(null) }



    Scaffold(
        topBar = {
            LargeTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { onBack() },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.background.copy(0.5f),
                            contentColor = colorResource(R.color.black)
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Text("Screen Progress Indicator")
                }
            )
        },
        bottomBar = {
            Column(

            ) {

                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            loadProgress { value ->
                                linearProgress = value
                            }
                        }
                        linearJob?.cancel()
                        linearJob = scope.launch {
                            loadProgress { value -> linearProgress = value }
                        }
                    }
                ) {
                    Text("Linear indicator")
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onClick = {
//                        isShowDialog = false
//                        scope.launch {
//                            delay(2000.milliseconds)
//                            isShowDialog = false
//
//                        }
                        scope.launch {
                            loadProgress { value ->
                                circularProgress = value
                            }
                        }
                        linearJob?.cancel()
                        linearJob = scope.launch {
                            loadProgress { value -> linearProgress = value }
                        }
                    }
                ) {
                    Text("Circular indicator")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier
                    .height(16.dp)
                    .padding(top = 8.dp),
                color = colorResource(R.color.black),
                trackColor = colorResource(R.color.teal_700),
                progress = { linearProgress },

                )
            Text("${(linearProgress * 100).toInt()}%")

            HorizontalDivider(thickness = 16.dp)

            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = colorResource(R.color.black),
//                        strokeWidth = 8.dp,
                trackColor = Violet80,
                progress = { circularProgress }
            )
            Text("${(circularProgress * 100).toInt()}%")
        }
    }
}

    suspend fun loadProgress(updateProgress: (Float) -> Unit) {
        for (i in 1..100) {
            updateProgress((i / 100f))
            delay(100.milliseconds)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ScreenProgressIndicatorPreview() {
        AppTheme() {
            ScreenProgressIndicator { }
        }
    }