package com.katilijiwoadiwiyono.newsapp.features.main.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.newsapp.theme.BackgroundGrey500
import com.katilijiwoadiwiyono.newsapp.theme.OutlineBoxGrey500
import com.katilijiwoadiwiyono.newsapp.theme.Pink500
import com.katilijiwoadiwiyono.newsapp.utils.subStringContent
import com.katilijiwoadiwiyono.newsapp.utils.toDateGlobalFormat
import com.katilijiwoadiwiyono.newsapp.utils.toString

@Preview
@Composable
fun ListCardNewsPreview() {
    ListCardNews(
        modifier = Modifier,
        news = NewsModel(
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
    ) {}
}

@Composable
fun ListCardNews(
    modifier: Modifier,
    news: NewsModel,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .clickable {
                onClick.invoke()
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .background(BackgroundGrey500),
            model = ImageRequest.Builder(context)
                .data(news.contentThumbnail)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            imageLoader = ImageLoader.Builder(context)
                .respectCacheHeaders(false)
                .diskCache(null)
                .memoryCache(null)
                .build()
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = news.title,
            fontSize = 18.sp,
            color = Pink500
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = news.content.subStringContent(),
            fontSize = 28.sp,
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = news.createdAt.toDateGlobalFormat()?.toString(f = "dd MMM yyyy") ?: "",
            fontSize = 14.sp,
        )
        Divider(
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
            color = OutlineBoxGrey500,
            thickness = 1.dp,
        )

    }

}