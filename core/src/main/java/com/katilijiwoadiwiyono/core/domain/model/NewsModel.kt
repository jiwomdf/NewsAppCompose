package com.katilijiwoadiwiyono.core.domain.model

import com.katilijiwoadiwiyono.core.data.remote.response.news.NewsResponse

data class NewsModel(
    val id: Int,
    val createdAt: String,
    val contributorName: String,
    val contributorAvatar: String,
    val title: String,
    val content: String,
    val contentThumbnail: String,
    val slideshow: List<Unit>,
) {
    companion object {
        fun mapNewsModel(newsResponse: List<NewsResponse>): List<NewsModel> {
            return newsResponse.map {
                NewsModel(
                    id = it.id,
                    createdAt = it.createdAt,
                    contributorName = it.contributorName,
                    contributorAvatar = it.contributorAvatar,
                    title = it.title,
                    content = it.content,
                    contentThumbnail = it.contentThumbnail,
                    slideshow = it.slideshow,
                )
            }
        }
    }
}