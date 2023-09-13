package com.katilijiwoadiwiyono.newsapp.features.dashboard.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.newsapp.theme.BackgroundGrey500
import com.katilijiwoadiwiyono.newsapp.theme.OutlineBoxGrey500
import com.katilijiwoadiwiyono.newsapp.theme.Pink500
import com.katilijiwoadiwiyono.newsapp.utils.subStringContent

@Preview
@Composable
fun ListCardNewsPreview() {
    ListCardNews(
        modifier = Modifier,
        NewsModel(
            id = 1,
            createdAt = "",
            contributorName = "",
            contributorAvatar = "",
            title = "",
            content = "",
            contentThumbnail = "",
            slideshow = listOf(),
        )
    )
}

@Composable
fun ListCardNews(
    modifier: Modifier,
    news: NewsModel
) {

    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .background(BackgroundGrey500),
            model = news.contentThumbnail,
            contentDescription = "",
            contentScale = ContentScale.Crop
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
            text = news.createdAt,
            fontSize = 14.sp,
        )
        Divider(
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
            color = OutlineBoxGrey500,
            thickness = 1.dp,
        )

    }

}