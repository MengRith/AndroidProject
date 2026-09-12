package kh.com.mereanandroidyoutube.basictoadvance.feature.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import kh.com.mereanandroidyoutube.basictoadvance.R
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.OutlinedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.lazyrow.MaterialComponentModal
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Amber40
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Orange80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Red80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.RedGrey80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Teal80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Yellow80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.YellowGrey40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenButton(
    item: MaterialComponentModal,
    onBack: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
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
                    Text(
                        text = "Top Button"
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            IconButton(
                onClick = {
                    println("====> You click icon Button")
                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.background,
                    disabledContentColor = Orange80,
                    disabledContainerColor = Red80,
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_download),
                    contentDescription = "download",
                    tint = MaterialTheme.colorScheme.background
                )
            }

            HorizontalDivider(thickness = 2.dp, color = RedGrey80)

            FilledTonalButton(
                onClick = {
                    println("====> You click filled tonal button")
                }
            ) {
                Text("Remind me later")
            }
            HorizontalDivider(thickness = 2.dp, color = Yellow80)


            OutlinedButton(
                onClick = {
                    println("====> You click outlined button")
                },
                shape = RoundedCornerShape(8.dp)

            ) {
                Text(
                    text = "Skip",
                    color = Amber40
                )

            }
            HorizontalDivider(thickness = 2.dp, color = YellowGrey40)

            ElevatedButton(
                onClick = {
                    println("====> You click elevated button")
                },
/*                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = colorResource(R.color.purple_700),
                    contentColor = Teal80
                ),*/
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp
                )

            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = "share"
                    )
                    Text("Share")
                }
            }
            HorizontalDivider(thickness = 2.dp, color = YellowGrey40)
            TextButton(
                onClick = {
                    println("===> You click text button")
                }
            ) {
                Text("Payment")
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ScreenButtonPreview(){
    AppTheme() {
        ScreenButton(
            item = MaterialComponentModal(
                1,
                "Button",
                "Button description",
                { "" },
                ""
            ),
            onBack = {}
        )
    }
}
