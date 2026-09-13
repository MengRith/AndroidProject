package kh.com.mereanandroidyoutube.basictoadvance.feature.tab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.R.drawable
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTab(
    onBack: () -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        TabModel(
            id = 0,
            title = "Home",
            icon = R.drawable.ic_home
        ),
        TabModel(
            id = 1,
            title = "Favorite",
            icon = R.drawable.ic_favorite
        ),
        TabModel(
            id = 2,
            title = "Setting",
            icon = R.drawable.ic_settings,
        )
    )

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
                        text = "Tab"
                    )
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            PrimaryTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = TabRowDefaults.primaryContentColor,
                indicator = {
                    TabRowDefaults.PrimaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(
                            selectedTabIndex = selectedTabIndex,
                            matchContentSize = true
                        ),
                        width = Dp.Unspecified,
                        height = 1.dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                divider = @Composable { HorizontalDivider() },
                tabs = {
                    tabs.forEachIndexed { index, tab ->
                        Tab(
                            selected = index == selectedTabIndex,
                            onClick = {
                                selectedTabIndex = index
                            },
                            enabled = true,
                            text = {
                                Text(tab.title)
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(tab.icon),
                                    contentDescription = "lala"
                                )
                            },
                            selectedContentColor = MaterialTheme.colorScheme.error,
                            unselectedContentColor = MaterialTheme.colorScheme.primary
                        )
                    }
                })

        }
    }
}

@Preview(showBackground = false)
@Composable
fun ScreenTabPreview(){
    AppTheme() {
        ScreenTab { }
    }
}