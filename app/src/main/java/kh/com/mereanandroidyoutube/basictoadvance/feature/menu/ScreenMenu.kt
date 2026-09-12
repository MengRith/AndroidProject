package kh.com.mereanandroidyoutube.basictoadvance.feature.menu

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.Cyan80
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.GreenGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMenu(
    onBack: () -> Unit
){
    val context = LocalContext.current
    var expand by remember { mutableStateOf(false) }
    val items = listOf(
        MenuItemModal(
            text = "Profile",
            onClick = {},
            leadingIcon = R.drawable.ic_profile,
        ),
        MenuItemModal(
            text = "Setting",
            onClick = {},
            leadingIcon = R.drawable.ic_settings,
        ),
        MenuItemModal(
            text = "Theme",
            onClick = {},
            leadingIcon = R.drawable.ic_theme,
            trailingIcon = R.drawable.ic_small_right_arrow,
        ),
        MenuItemModal(
            text = "Upgrade",
            onClick = {},
            leadingIcon = R.drawable.ic_update,
        ),
        MenuItemModal(
            text = "Keyboard shortcuts",
            onClick = {},
            leadingIcon = R.drawable.ic_keyboard
        ),
        MenuItemModal(
            text = "Help center",
            onClick = {},
            leadingIcon = R.drawable.ic_help_center
        ),
        MenuItemModal(
            text = "Log out",
            onClick = {},
            leadingIcon = R.drawable.ic_logout
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
                    Text("Full Screen Dialog")
                },
                actions = {
                    IconButton(
                        onClick = {
                            expand = true
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_more_vert),
                            contentDescription = "More"
                        )
                    }
                    DropdownMenu(
                        expanded = expand,
                        onDismissRequest = { expand = false},
                        containerColor = Color.Transparent,
                        shadowElevation = 0.dp,
                        tonalElevation = 0.dp,
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Column(
                            modifier = Modifier
                        ) {
                            items.forEachIndexed { index, item ->
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .background(
                                            color = Cyan80,
                                            shape = RoundedCornerShape(
                                                topStart = if (index == 0) 16.dp else 0.dp,
                                                topEnd = if (index == 0) 16.dp else 0.dp,
                                                bottomStart = if (index == items.size - 1) 16.dp else 0.dp,
                                                bottomEnd = if (index == items.size - 1) 16.dp else 0.dp,
                                            )
                                        )
                                        .padding(horizontal = 16.dp),
                                    text = {
                                        Text(
                                            text = item.text
                                        )
                                    },
                                    onClick = {
                                        item.onClick
                                        expand = false
                                        val toast = Toast.makeText(context, "You click ${item.text}",
                                            Toast.LENGTH_SHORT)
                                        toast.show()
                                    },
                                    leadingIcon = {
                                        if (item.leadingIcon != null) {
                                            Icon(
                                                painter = painterResource(item.leadingIcon),
                                                contentDescription = item.leadingIcon.toString()
                                            )
                                        }
                                    },
                                    trailingIcon = {
                                        if (item.trailingIcon != null) {
                                            Icon(
                                                painter = painterResource(item.trailingIcon),
                                                contentDescription = item.trailingIcon.toString()
                                            )

                                        }
                                    },
                                    enabled = item.enabled,
                                    contentPadding = PaddingValues(16.dp),
                                    interactionSource = remember { MutableInteractionSource() }

                                )
                                if (item.text == "Upgrade"){
                                    HorizontalDivider(
                                        modifier = Modifier
                                            .background(MaterialTheme.colorScheme.background),
//                                            .padding(horizontal = 16.dp),
                                        thickness = 1.dp,
                                        color = MaterialTheme.colorScheme.outlineVariant
                                    )
                                }
                            }
                        }
                    }
                }

            )
        },
    ){ paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenMenuPreview(){
    AppTheme() {
        ScreenMenu {  }
    }
}