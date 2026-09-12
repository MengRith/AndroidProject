package kh.com.mereanandroidyoutube.basictoadvance.feature.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.test.isSelected
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.RadioButton
import kh.com.mereanandroidyoutube.basictoadvance.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadio(
    onBack: () -> Unit
){
    val scrollState = rememberScrollState()
    var selectedIndex by remember { mutableIntStateOf(0) }

    val coffeeOption = listOf(
        RadioModel(
            label = "Ice Latte",
        ),
        RadioModel(
            label = "Ice Espresso",
        ),
        RadioModel(
            label = "Ice Americano",
        ),
        RadioModel(
            label = "Hot Cappuccino",
        ),
        RadioModel(
            label = "Ice Mocha",
        )
    )
    val sizeOption = listOf(
        RadioModel(
            label = "Small",
        ),
        RadioModel(
            label = "Medium",
        ),
        RadioModel(
            label = "Large",
        )
    )
    val iceOption = listOf(
        RadioModel(
            label = "No ice",
        ),
        RadioModel(
            label = "Less ice",
        ),
        RadioModel(
            label = "Normal ice",
        ),
        RadioModel(
            label = "Ice outside",
        )
    )
    val milkOption = listOf(
        RadioModel(
            label = "No Milk",
        ),
        RadioModel(
            label = "Less Milk",
        ),
        RadioModel(
            label = "Normal Milk",
        ),
    )
    val sugarOption = listOf(
        RadioModel(
            label = "0%",
        ),
        RadioModel(
            label = "25%",
        ),
        RadioModel(
            label = "50%",
        ),
        RadioModel(
            label = "75%",
        ),
        RadioModel(
            label = "100%",
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.background.copy(0.5f),
                            contentColor = colorResource(R.color.black)
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_backarrow),
                            contentDescription = "Back",
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
                    Text(text = "Screen Radio")
                }
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {}
            ) {
                Text("Confirm Order")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pick coffee
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Pick coffee",
                list = coffeeOption
            )
            // Pick size
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Pick Size",
                list = sizeOption
            )
            // pick how much ice
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Pick ice",
                list = iceOption
            )
            // Pick Milk
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Pick Milk",
                list = milkOption
            )
            // Pick Sugar
            OrderSection(
                modifier = Modifier.padding(top = 16.dp),
                title = "Pick Sugar",
                list = sugarOption
            )
        }
    }
}


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    title: String,
    list: List<RadioModel> = emptyList()
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .then(modifier)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            style = MaterialTheme.typography.titleLarge
        )
        list.forEachIndexed { index, option ->
            Option(
                option = RadioModel(
                    label = option.label,
                ),
                isSelected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Composable
fun Option(
    option: RadioModel,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSelected,
                onClick = onClick,
                role = Role.RadioButton
            )
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier.size(48.dp),
            selected = isSelected,
            onClick = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = option.label
        )
    }
}

data class RadioModel(
    val label: String,
)
