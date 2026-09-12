package kh.com.mereanandroidyoutube.basictoadvance.feature.lazyColumn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kh.com.mereanandroidyoutube.basictoadvance.R
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenLazyColumn(
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
                    Text(item.title)
                }
            )

        },
        bottomBar = {

        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
        ) {
            itemsIndexed(
                names,
                key = { _, item -> item }
            ) { index, item ->
                ItemLazyColumn(index, item)
            }
        }
    }
}
@Composable
fun ItemLazyColumn(index: Int, item: String) {
    Row (
        modifier = Modifier
            .height(96.dp)
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
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = Icons.Filled.Build,
            contentDescription = ""
        )
    }
}

data class MaterialComponentModal(
    val id: Int,
    val title: String,
    val description: String,
    val onClick: () -> String,
    val icon: String
)


@Composable
@Preview(showBackground = true)
fun LazyColumnPreview(){
    AppTheme() {
        ScreenLazyColumn(
            item = MaterialComponentModal(
                1,
                "Lazy Column",
                "Lazy Column description",
                { "" },
                ""
            ),
            onBack = {}
        )
    }
}