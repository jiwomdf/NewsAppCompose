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
            createdAt = "",
            contributorName = "",
            contributorAvatar = "",
            title = "",
            content = "",
            contentThumbnail = "",
            slideshow = listOf(),
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