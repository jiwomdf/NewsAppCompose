package com.katilijiwoadiwiyono.newsapp.features.main.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.newsapp.R
import com.katilijiwoadiwiyono.newsapp.common.components.PageError
import com.katilijiwoadiwiyono.newsapp.common.components.TopBarDefault
import com.katilijiwoadiwiyono.newsapp.theme.BackgroundGrey500
import com.katilijiwoadiwiyono.newsapp.theme.Pink500
import com.katilijiwoadiwiyono.newsapp.utils.toDateGlobalFormat
import com.katilijiwoadiwiyono.newsapp.utils.toString

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        newsModel = NewsModel(
            id = 1,
            createdAt = "2023-09-14T04:29:04.957Z",
            contributorName = "Hope Ward IV",
            contributorAvatar = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/760.jpg",
            title = "perspiciatis maxime molestiae",
            content = "Alias molestias recusandae molestiae labore itaque consequatur atque illum dolorem. Accusamus soluta ut neque nihil earum quae consectetur quibusdam. Tempora adipisci aut quam a impedit excepturi suscipit. Officiis cum ab. Ab quas animi hic iusto ipsum at.\\nVoluptas quibusdam perspiciatis debitis harum nobis quibusdam dolores voluptatum nobis. Ut fugit beatae corrupti maxime libero error quos dignissimos dolorem. Harum incidunt quia consectetur reprehenderit debitis veritatis voluptates repellendus reiciendis.\\nTotam recusandae corporis. Maxime consequatur a nulla accusamus. Iste sapiente vel placeat aperiam. Voluptates maiores quo tempore id praesentium itaque. Voluptatem iure cumque debitis officia iure sapiente.",
            contentThumbnail = "https://loremflickr.com/640/480",
            slideshow = listOf(
                "https://loremflickr.com/640/480",
                "https://loremflickr.com/640/480",
                "https://loremflickr.com/640/480"
            ),
        )
    )
}

@Composable
fun DetailScreen(
    newsModel: NewsModel?
) {
    Scaffold(
        topBar = {
            TopBarDefault()
        }
    ) { padding ->
        newsModel?.let {
            DetailContent(
                modifier = Modifier.padding(padding),
                newsModel = it
            )
        } ?: run {
            PageError(modifier = Modifier.padding(padding))
        }
    }

}

@Composable
fun DetailContent(modifier: Modifier, newsModel: NewsModel) {

    val context = LocalContext.current
    var displayImg = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp, start = 16.dp),
            text = newsModel.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(top = 32.dp, start = 16.dp),
            text = newsModel.contributorName,
            fontSize = 14.sp,
        )
        Text(
            modifier = Modifier.padding(
                top = 4.dp,
                start = 16.dp,
                bottom = 32.dp
            ),
            text = newsModel.createdAt
                .toDateGlobalFormat()
                ?.toString(f = "dd MMM yyyy") ?: "",
            fontSize = 14.sp,
        )
        AsyncImage(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .background(BackgroundGrey500),
            model = ImageRequest.Builder(LocalContext.current)
                .data(displayImg.value.ifEmpty { newsModel.contentThumbnail })
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        SlideShow(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            slideshow = newsModel.slideshow,
            onCLick =  {
                displayImg.value = it
            }
        )
        Text(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
            text = newsModel.content,
            fontSize = 18.sp,
        )
        Text(
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 32.dp
            ),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontStyle = FontStyle.Italic
                    )
                ) {
                    append(context.getString(R.string.more_info))
                }
                withStyle(
                    style = SpanStyle(
                        color = Pink500,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(" ${context.getString(R.string.more_info_content)}")
                }
            },
            fontSize = 18.sp,
        )
    }
}

@Composable
fun SlideShow(
    modifier: Modifier,
    slideshow: List<String>,
    onCLick: (url: String) -> Unit
) {

    LazyRow(
        modifier = modifier
    ) {
        items(slideshow.size) { idx ->
            val item = slideshow[idx]
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        onCLick.invoke(item)
                    },
                shape = RoundedCornerShape(8),
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(BackgroundGrey500),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}
