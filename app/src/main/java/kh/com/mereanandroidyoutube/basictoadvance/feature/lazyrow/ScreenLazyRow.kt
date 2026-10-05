package kh.com.mereanandroidyoutube.basictoadvance.feature.lazyrow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.exercise.model.general.MaterialComponentModel
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.feature.lazyColumn.ItemLazyColumn
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyRow(
    item: MaterialComponentModel,
    onBack: ()-> Unit
) {
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
                    Text(item.title)
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = "Setting"
                    )
                }
            )

        },
    ) { innerPadding ->
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RectangleShape)
                .padding(innerPadding),


        ) {
            items(names.size) {
                index ->
                ItemLazyColumn(index, names[index])
            }
        }

    }
}

@Composable
fun ItemLazyRow(index: Int, item: String){
    Row(
        modifier = Modifier
            .height(256.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "${index + 1}, $item"
        )
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            painter = painterResource(R.drawable.ic_build),
            contentDescription = ""
        )
    }
}


@Composable
@Preview(showBackground = true)
fun LazyRowPreview(){
    AppTheme() {
        ScreenLazyRow(
            item = MaterialComponentModel(
                1,
                "Lazy Row",
                "Lazy Row description",
                { " " },
                ""
            ),
            onBack = {}
        )
//        ItemLazyRow()
    }
}