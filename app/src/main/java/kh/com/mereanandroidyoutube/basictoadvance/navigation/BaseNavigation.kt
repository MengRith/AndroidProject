package kh.com.mereanandroidyoutube.basictoadvance.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kh.com.mereanandroidyoutube.basictoadvance.feature.Box.ScreenBox
import kh.com.mereanandroidyoutube.basictoadvance.feature.badge.ScreenBadge
import kh.com.mereanandroidyoutube.basictoadvance.feature.bottomsheet.ScreenBottomSheet
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.MultiChoiceSegmentedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenElevatedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenFilledTonalButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenOutlineButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.ScreenTextButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.button.SingleChoiceSegmentedButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.card.ScreenCard
import kh.com.mereanandroidyoutube.basictoadvance.feature.carousel.ScreenCarousel
import kh.com.mereanandroidyoutube.basictoadvance.feature.checkbox.ScreenCheckBox
import kh.com.mereanandroidyoutube.basictoadvance.feature.chip.ScreenChip
import kh.com.mereanandroidyoutube.basictoadvance.feature.column.ScreenColumn
import kh.com.mereanandroidyoutube.basictoadvance.feature.dialog.ScreenDialog
import kh.com.mereanandroidyoutube.basictoadvance.feature.dialog.ScreenFullDialog
import kh.com.mereanandroidyoutube.basictoadvance.feature.home.ScreenHome
import kh.com.mereanandroidyoutube.basictoadvance.feature.iconbutton.ScreenIconButton
import kh.com.mereanandroidyoutube.basictoadvance.feature.lazyColumn.ScreenLazyColumn
import kh.com.mereanandroidyoutube.basictoadvance.feature.lazyrow.ScreenLazyRow
import kh.com.mereanandroidyoutube.basictoadvance.feature.menu.ScreenMenu
import kh.com.mereanandroidyoutube.basictoadvance.feature.navigationbar.ScreenNavigationBar
import kh.com.mereanandroidyoutube.basictoadvance.feature.navigationdrawer.ScreenNavigationDrawer
import kh.com.mereanandroidyoutube.basictoadvance.feature.notification.ScreenNotificationList
import kh.com.mereanandroidyoutube.basictoadvance.feature.progressindicator.ScreenProgressIndicator
import kh.com.mereanandroidyoutube.basictoadvance.feature.radio.ScreenRadio
import kh.com.mereanandroidyoutube.basictoadvance.feature.row.ScreenRow
import kh.com.mereanandroidyoutube.basictoadvance.feature.scraffold.ScreenScaffold
import kh.com.mereanandroidyoutube.basictoadvance.feature.screendatepicker.ScreenDatePicker
import kh.com.mereanandroidyoutube.basictoadvance.feature.slider.ScreenSlider
import kh.com.mereanandroidyoutube.basictoadvance.feature.snackbar.ScreenSnackBar
import kh.com.mereanandroidyoutube.basictoadvance.feature.spacer.ScreenSpacer
import kh.com.mereanandroidyoutube.basictoadvance.feature.stateviewmodel.ScreenStateViewModel
import kh.com.mereanandroidyoutube.basictoadvance.feature.switchcomponent.ScreenSwitchComponent
import kh.com.mereanandroidyoutube.basictoadvance.feature.tab.ScreenTab
import kh.com.mereanandroidyoutube.basictoadvance.feature.textfield.ScreenTextField
import kh.com.mereanandroidyoutube.basictoadvance.feature.timepicker.ScreenTimePicker
import kh.com.mereanandroidyoutube.basictoadvance.feature.toolbar.ScreenToolbar
import kh.com.mereanandroidyoutube.basictoadvance.feature.tooltip.ScreenToolTips
import kh.com.mereanandroidyoutube.basictoadvance.feature.topappbar.ScreenTopAppBar


private const val ANIMATION_DURATION = 300

@Composable
fun BaseNavigation() {
    val backStack = remember { mutableStateListOf<Any>(NavKey.Home) }

    fun onBack() {
        backStack.removeLastOrNull()
    }

    NavDisplay(
        backStack = backStack,
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = ANIMATION_DURATION),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth / 3 },
                animationSpec = tween(durationMillis = ANIMATION_DURATION),
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 3 },
                animationSpec = tween(durationMillis = ANIMATION_DURATION),
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = ANIMATION_DURATION),
            )
        },
        onBack = {
            onBack()
        },
        entryProvider = entryProvider {
            entry<NavKey.Home> {
                ScreenHome(
                    onClick = { item -> backStack.add(item.toNavKey()) },
                    onClickNotification = { title -> backStack.add(NavKey.NotificationList(title)) }
                )
            }

            entry<NavKey.Badge> { key ->
                ScreenBadge(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.BottomSheet> { key ->
                ScreenBottomSheet(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Buttons> { key ->
                ScreenButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Cards> { key ->
                ScreenCard(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Carousel> { key ->
                ScreenCarousel(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.CheckBox> { key ->
                ScreenCheckBox(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Chip> { key ->
                ScreenChip(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ColumnScreen> { key ->
                ScreenColumn(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.DatePicker> { key ->
                ScreenDatePicker(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Dialog> { key ->
                ScreenDialog(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.FullScreenDialog> { key ->
                ScreenFullDialog(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ElevatedButton> { key ->
                ScreenElevatedButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.FilledTonalButton> { key ->
                ScreenFilledTonalButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.IconButton> { key ->
                ScreenIconButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ScreenLazyColumn> { key ->
                ScreenLazyColumn(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.LazyRowScreen> { key ->
                ScreenLazyRow(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Menu> { key ->
                ScreenMenu(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.BottomNavigationBar> { key ->
                ScreenNavigationBar(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.NavigationDrawer> { key ->
                ScreenNavigationDrawer(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.OutlineButton> { key ->
                ScreenOutlineButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ProgressIndicator> { key ->
                ScreenProgressIndicator(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Radio> { key ->
                ScreenRadio(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.RowScreen> { key ->
                ScreenRow(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ScaffoldScreen> { key ->
                ScreenScaffold(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.MultiChoiceSegmentButton> { key ->
                MultiChoiceSegmentedButton(
                    item = key.data,
                    onBack = { onBack() },
                )
            }

            entry<NavKey.SingleChoiceSegmentedButton> { key ->
                SingleChoiceSegmentedButton(
                    item = key.data,
                    onBack = { onBack() },
                )
            }

            entry<NavKey.Slider> { key ->
                ScreenSlider(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.SnackBar> { key ->
                ScreenSnackBar(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.SpacerScreen> { key ->
                ScreenSpacer(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Switch> { key ->
                ScreenSwitchComponent(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Tabs> { key ->
                ScreenTab(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.TextButton> { key ->
                ScreenTextButton(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.TextField> { key ->
                ScreenTextField(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.TimePicker> { key ->
                ScreenTimePicker(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.Toolbar> { key ->
                ScreenToolbar(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.ToolTips> { key ->
                ScreenToolTips(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.BoxScreen> { key ->
                ScreenBox(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.TopAppBarScreen> { key ->
                ScreenTopAppBar(
                    item = key.data,
                    onBack = { onBack() }
                )
            }

            entry<NavKey.NotificationList> { key ->
                ScreenNotificationList(
                    title = key.title,
                    onBack = { onBack() }
                )
            }
            entry<NavKey.StateViewModelScreen> { key ->
                ScreenStateViewModel(
                    item = key.data,
                    onBack = { onBack() }
                )
            }


        }
    )
}


@Composable
private fun NavigationNotFound(
    onBack: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Unknown route")
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBack
            ) {
                Text("Back")
            }
        }
    }
}