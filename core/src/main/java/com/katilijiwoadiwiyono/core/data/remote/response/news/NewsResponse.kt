package com.katilijiwoadiwiyono.core.data.remote.response.news

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("id") val id: Int,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("contributorName") val contributorName: String,
    @SerialName("contributorAvatar") val contributorAvatar: String,
    @SerialName("title") val title: String,
    @SerialName("content") val content: String,
    @SerialName("contentThumbnail") val contentThumbnail: String,
    @SerialName("slideshow") val slideshow: List<Unit>,
)