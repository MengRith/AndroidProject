package kh.com.mereanandroidyoutube.basictoadvance.feature.snackbar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R.drawable
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSnackBar(
    onBack: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

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
                        text = "Snack Bar"
                    )
                },
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        bottomBar = {
            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center
            ) {
                Button(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "Item deleted",
                                actionLabel = "Undo",
                                withDismissAction = true,
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                ) {
                    Text("Delete")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        }
//        Button(
//            modifier = Modifier.fillMaxWidth(),
//            onClick = {
//                scope.launch {
//                    snackbarHostState.showSnackbar(
//                        message = "Item deleted",
//                        actionLabel = "Undo",
//                        withDismissAction = true
//                    )
//                }
//            }
//        ) {
//            Text("Delete")
//        }
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenSnackBarPreview() {
    AppTheme() {
        ScreenSnackBar { }
    }
}