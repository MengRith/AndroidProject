package kh.com.mereanandroidyoutube.basictoadvance.feature.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberRangeSliderState
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.R.drawable
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSlider(
    onBack: () -> Unit
) {
    val sliderState = rememberSliderState(value = 0f)
    val rangeSliderState = rememberRangeSliderState(
        activeRangeStart = 1f,
        activeRangeEnd = 19f,
        valueRange = 1f..20f,
        steps = 4,
        onValueChangeFinished = {}
    )

    var sliderValue by remember { mutableFloatStateOf(0f) }
    var sliderStep by remember { mutableFloatStateOf(0f) }
    var sliderRange by remember { mutableStateOf(0f..100f) }

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
                        textAlign = TextAlign.Center,
                        text = "Slider"
                    )
                },
            )

        },

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Slider no slider state",
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Slider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp, 16.dp),
                    value = sliderValue,
                    onValueChange = { value ->
                        sliderValue = value
                    }
                )
                Text(
                    text = "${(sliderValue * 100).roundToInt()}",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            // Slider with steps
            Text(
                text = "Step slider",
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Slider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    value = sliderStep,
                    onValueChange = { value ->
                        sliderStep = value
                    },
                    steps = 4
                )
                Text(
                    text = "${(sliderStep * 100).roundToInt()}",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            // Slider with Range
            Text(
                text = "Range slider",
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RangeSlider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp, end = 16.dp),
                    value = sliderRange,
                    onValueChange = { value ->
                        sliderRange = value
                    },
                    steps = 6
                )
            }
            Text(
                text = "$sliderRange",
                style = MaterialTheme.typography.titleMedium
            )
            HorizontalDivider()
            //Slider with state
            Text(
                text = "Slider within state",
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Slider(
                    modifier = Modifier.weight(1f),
                    state = sliderState
                )
                Text(
                    modifier = Modifier.width(96.dp),
                    text = "${(sliderState.value * 100).roundToInt()} %",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ScreenSliderPreview() {
    AppTheme() {
        ScreenSlider { }
    }
}