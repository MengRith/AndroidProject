package kh.com.mereanandroidyoutube.basictoadvance.feature.button

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
import kh.com.mereanandroidyoutube.basictoadvance.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceSegmentedButton(
    onBack: () -> Unit
){
    var selectedIndex by remember { mutableIntStateOf(0) }
    var transactionFilter by remember { mutableStateOf<List<TransactionModel>>(transactionList) }
    
    val list = listOf<TransactionType>(
        TransactionType.TRANSFER,
        TransactionType.KHQR,
        TransactionType.MOBILE_TOPUP,
        TransactionType.BILL_PAYMENT
    )
    fun onFilter(){
        val filteredList = transactionList.filter { it.type == list[selectedIndex] }
        transactionFilter = filteredList
    }
    
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
                title = {
                    Text("Single Choice Segment")
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    transactionFilter = transactionList
                }
            ) { Text("Clear")}
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ){
            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.padding(16.dp)
            ) { 
                list.forEachIndexed { index, item ->
                    SegmentedButton(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                            onFilter()
                        },
                        shape = RoundedCornerShape(
                            topStart = if (index == 0) 16.dp else 0.dp,
                            topEnd = if (index == list.size - 1) 16.dp else 0.dp,
                            bottomStart = if (index == 0) 16.dp else 0.dp,
                            bottomEnd = if (index == list.size - 1) 16.dp else 0.dp
                        ),
                        label = {
                            Text(item.type)
                        }
                    )
                }
            }
            transactionFilter.forEachIndexed { index, model ->
                Row(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Text("${model.id} - ${model.title}")
                }
                HorizontalDivider()
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun SingleChoiceSegmentedPreview(){
    AppTheme() {
        SingleChoiceSegmentedButton(
            onBack = {}
        )
    }
}