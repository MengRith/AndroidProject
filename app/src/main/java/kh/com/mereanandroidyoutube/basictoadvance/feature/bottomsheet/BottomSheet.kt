package kh.com.mereanandroidyoutube.basictoadvance.feature.bottomsheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R.drawable
import kh.com.mereanandroidyoutube.basictoadvance.feature.radio.OrderSection
import kh.com.mereanandroidyoutube.basictoadvance.feature.radio.RadioModel
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomSheet(
    onBack: () -> Unit
) {
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var showSheet by remember { mutableStateOf(false) }

    val coffeeOption = listOf(
        RadioModel(
            label = "Ice latte"
        ),
        RadioModel(
            label = "Ice espresso"
        ),
        RadioModel(
            label = "Ice Americano"
        ),
        RadioModel(
            label = "Ice Cappuccino"
        ),
        RadioModel(
            label = "Macha"
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
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
                        textAlign = TextAlign.Center,
                        text = "Bottom Sheet"
                    )
                },
            )

        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    showSheet = true
                }
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Open Bottom Sheet",
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        }
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showSheet = false
                },
                sheetState = sheetState,
                dragHandle = {
                    BottomSheetDefaults.DragHandle(
                        width = 48.dp,
                        height = 4.dp,
                    )
                },
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
//                scrimColor = Color.Black.copy(alpha = 0.6f)
                scrimColor = Color.Transparent
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    OrderSection(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Pick coffee",
                        list = coffeeOption
                    )
                    // Pick size
                    OrderSection(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Pick coffee",
                        list = coffeeOption
                    )
                    // pick how much ice
                    OrderSection(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Pick coffee",
                        list = coffeeOption
                    )
                    // Pick Milk
                    OrderSection(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Pick coffee",
                        list = coffeeOption
                    )
                    // Pick Sugar
                    OrderSection(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Pick coffee",
                        list = coffeeOption
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenBottomSheetPreview(){
    AppTheme() {
        ScreenBottomSheet {  }
    }
}