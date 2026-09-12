//package kh.com.mereanandroidyoutube.basictoadvance.feature.carousel
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.IconButtonDefaults
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
//import androidx.compose.material3.carousel.CarouselDefaults
//import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
//import androidx.compose.material3.carousel.rememberCarouselState
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.wear.compose.material3.MaterialTheme
//import kh.com.mereanandroidyoutube.basictoadvance.R
//import kh.com.mereanandroidyoutube.basictoadvance.ui.theme.AppTheme
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ScreenCarousel(
//    onBack: () -> Unit
//){
////    val list = listOf(
////        CarouselItem(
////            title = "Title 1",
////            image = R.drawable.,
////            description = "Description 1",
////        ),
////        CarouselItem(
////            title = "Title 2",
////            image = R.drawable.image_2,
////            description = "Description 2",
////        ),
////        CarouselItem(
////            title = "Title 3",
////            image = R.drawable.image_3,
////            description = "Description 3",
////        ),
////        CarouselItem(
////            title = "Title 4",
////            image = R.drawable.image_4,
////            description = "Description 4",
////        ),
////        CarouselItem(
////            title = "Title 5",
////            image = R.drawable.image_5,
////            description = "Description 5",
////        ),
////        CarouselItem(
////            title = "Title 6",
////            image = R.drawable.image_2,
////            description = "Description 6",
////        ),
////        CarouselItem(
////            title = "Title 7",
////            image = R.drawable.image_3,
////            description = "Description 7",
////        ),
////        CarouselItem(
////            title = "Title 8",
////            image = R.drawable.image_4,
////            description = "Description 8",
////        ),
////        CarouselItem(
////            title = "Title 9",
////            image = R.drawable.image_5,
////            description = "Description 9",
////        ),
////        CarouselItem(
////            title = "Title 10",
////            image = R.drawable.img_1,
////            description = "Description 10",
////        ),
////    )
//
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            onBack()
//                        },
//                        colors = IconButtonDefaults.iconButtonColors(
//                            containerColor = MaterialTheme.colorScheme.background.copy(0.5f),
//                            contentColor = colorResource(R.color.black)
//                        )
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.ic_backarrow),
//                            contentDescription = "Back",
//                        )
//                    }
//                },
//                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primary,
//                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
//                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
//                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
//                ),
//                title = {
//                    Text("Carousel Screen")
//                }
//            )
//        }
//    ) {
//        paddingValues ->
//        LazyColumn(
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            item {
//                HorizontalMultiBrowseCarousel(
//                    state = rememberCarouselState { list.size},
//                    preferredItemWidth = 200.dp,
//                    modifier = Modifier,
//                    itemSpacing = 16.dp,
//                    flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(
////                        state = rememberCarouselState { list.size },
////                    ),
//                    userScrollEnabled = true,
//                    minSmallItemWidth = CarouselDefaults.MinSmallItemSize,
//                    maxSmallItemWidth = CarouselDefaults.MaxSmallItemSize,
//                    contentPadding = PaddingValues(16.dp),
//
//                    ) { index ->
//                    val item = list[index]
//                    Box(
//                        modifier = Modifier
//                            .background(colorResource(R.color.white))
////                            .aspectRatio(1f)
//                    ) {
//                        Image(
//                            modifier = Modifier
//                                .clip(RoundedCornerShape(16.dp)),
//                            painter = painterResource(item.image),
//                            contentDescription = ""
//                        )
//                        Text(
//                            text = item.title,
//                            style = MaterialTheme.typography.titleMedium,
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .align(Alignment.BottomCenter)
//                                .background(
//                                    color = colorResource(R.color.white),
//                                    shape = RoundedCornerShape(16.dp)
//                                )
//                        )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//@Preview(showBackground = true)
//fun ScreenCarouselPreview(){
//    AppTheme() {
//        ScreenCarousel{ }
//    }
//}