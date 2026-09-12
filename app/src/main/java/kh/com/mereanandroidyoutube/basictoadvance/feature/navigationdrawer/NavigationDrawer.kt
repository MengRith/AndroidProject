package kh.com.mereanandroidyoutube.basictoadvance.feature.navigationdrawer

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Red40
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ScreenNavigationDrawer(
    onBack: () -> Unit
){
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    var selectIndex by remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val tabItem = listOf(
        NavigationItem(
            label = "Home",
            icon = R.drawable.ic_home,
        ),
        NavigationItem(
            label = "Settings",
            icon = R.drawable.ic_settings,
        ),
        NavigationItem(
            label = "Profiles",
            icon = R.drawable.ic_profile,
        ),
    )

    val drawerList = listOf(
        DrawerMenuItem(route = "A", label = "Profile", icon = R.drawable.ic_favorite)
    )


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    drawerList = drawerList,
                    scrollState = scrollState,
                    onBack = {item ->
                        println("====> ${item.route}")
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        }
    ) {

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
                        },

                        icon = {
                            Icon(
                                painter = painterResource(items.icon),
                                contentDescription = "Home"
                            )
                        },
                        label = {
                            Text(
                                text = items.label,
                                style = MaterialTheme.typography.labelMedium

                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                        )
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
            MainContent(
                selectIndex = selectIndex,
                onProfileClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )
        }
    }
    }

}

@Composable
fun DrawerContent(
    drawerList: List<DrawerMenuItem>,
    scrollState: ScrollState,
    onBack: (DrawerMenuItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.border(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
            ){
                 Image(
                     painter = painterResource(R.drawable.img_sherlock_kitties),
                     contentDescription = "User Profile",
                     modifier = Modifier
                         .size(72.dp)
                         .clip(CircleShape)
                 )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "General",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "General@example.com",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        HorizontalDivider()
        drawerList.forEach { item ->
            NavigationDrawerItem(
                modifier = Modifier.padding(vertical = 12.dp),
                label = {
                    Text(
                        text = item.label
                    )
                },
                selected = false,
                onClick = {
                    onBack(item)
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "Profile"
                    )
                },
                badge = {
                    Text(
                        color = Red40,
                        text = "New"
                    )
                }
            )
            HorizontalDivider()
        }
    }
}
@Composable
fun MainContent(
    selectIndex: Int,
    onProfileClick: () -> Unit = {}
){
    AnimatedContent(
        targetState = selectIndex,
        transitionSpec = {
            if (targetState> initialState){
                slideInHorizontally(
                    initialOffsetX = { it }
                ) + fadeIn() togetherWith slideOutHorizontally(
                    targetOffsetX = {-it}
                )+ fadeOut()
            }else{
                slideInHorizontally(
                    initialOffsetX = { -it }
                ) + fadeIn() togetherWith
                        slideOutHorizontally(
                            targetOffsetX = { it }
                        ) + fadeOut()
            }.using(SizeTransform(clip = false))
        },
        label = "BottomNavigationAnimation"
    ) {
        index ->
        when (index) {
            CONTENT_TYPE.HOME.value -> HomeScreen(
                onProfileClick = onProfileClick
            )
            CONTENT_TYPE.SETTING.value -> FavoriteScreen()
            CONTENT_TYPE.PROFILES.value -> SettingScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenNavigationDrawerPreview(){
    AppTheme() {
        ScreenNavigationDrawer {  }
    }
}
