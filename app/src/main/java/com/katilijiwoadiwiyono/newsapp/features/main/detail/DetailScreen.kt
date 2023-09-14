package com.katilijiwoadiwiyono.newsapp.features.main.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
import com.katilijiwoadiwiyono.newsapp.common.components.PageError
import com.katilijiwoadiwiyono.newsapp.common.components.TopBarDefault
import com.katilijiwoadiwiyono.newsapp.theme.BackgroundGrey500
import com.katilijiwoadiwiyono.newsapp.theme.Pink500
import com.katilijiwoadiwiyono.newsapp.utils.subStringContent

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(
        newsId = 0,
        viewModel = FakeDetailViewModel()
    )
}

@Composable
fun DetailScreen(
    newsId: Int,
    viewModel: IDetailViewModel,
) {

    val newsDetail by remember { viewModel.newsDetail }

    LaunchedEffect(Unit) {
        viewModel.getNewsDetail(newsId)
    }

    Scaffold(
        topBar = {
            TopBarDefault()
        }
    ) { padding ->
        newsDetail?.let {
            DetailContent(
                modifier = Modifier.padding(padding),
                newsModel = it
            )
        } ?: run {
            PageError(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            )
        }
    }

}

@Composable
fun DetailContent(modifier: Modifier, newsModel: NewsModel) {
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
            text = newsModel.createdAt,
            fontSize = 14.sp,
        )
        AsyncImage(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .background(BackgroundGrey500),
            model = ImageRequest.Builder(LocalContext.current)
                .data(newsModel.contentThumbnail)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop
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
                        color = Color.Black,
                        fontStyle = FontStyle.Italic
                    )
                ) {
                    append("Baca juga: ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Pink500,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Wah! Ternyata ini Kebiasaan Tidur Aneh di Anggota BTS")
                }
            },
            fontSize = 18.sp,
        )
    }
}