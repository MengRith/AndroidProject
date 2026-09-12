package kh.com.mereanandroidyoutube.basictoadvance.feature.navigationbar

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material3.OpenOnPhoneDialogDefaults.text
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.feature.menu.ScreenMenu
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ScreenNavigationBar(
    onBack: () -> Unit
){
    var selectIndex by remember { mutableIntStateOf(0) }
    var selectTab by remember { mutableStateOf(SwitchTab.Home) }

    val tabItem = listOf(
        NavigationBottomItem(
            text = "Home",
            icon = R.drawable.ic_home,
        ),
        NavigationBottomItem(
            text = "Shorts",
            icon = R.drawable.ic_reel,
        ),
        NavigationBottomItem(
            text = "Add",
            icon = R.drawable.ic_add,
        ),
        NavigationBottomItem(
            text = "Subscription",
            icon = R.drawable.ic_subscriptions,
        ),
        NavigationBottomItem(
            text = "Profiles",
            icon = R.drawable.ic_profile,
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
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
                    Text("Navigation Bar")
                },
            )
        },
        bottomBar = {
            NavigationBar {
                tabItem.forEachIndexed { index, items ->
                    NavigationBarItem(
                        selected = index == selectIndex,
                        alwaysShowLabel = true,
                        onClick = {
                            selectIndex = index
                            selectTab = SwitchTab.entries[index]
                        },

                        icon = {
                            Icon(
                                painter = painterResource(items.icon),
                                contentDescription = items.text
                            )
                        },
                        label = {
                            Text(
                                text = items.text,

                            )
                        }
                    )
                }
            }
        }

    ){ paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            when(selectTab){
                SwitchTab.Home -> Text("Home")
                SwitchTab.Shorts -> Text("Shorts")
                SwitchTab.Add -> Text("Post")
                SwitchTab.Subscription -> Text("Pay me")
                SwitchTab.Profiles -> Text("Look at me!!")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationBarPreview(){
    AppTheme() {
        ScreenNavigationBar {  }
    }
}
