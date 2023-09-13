package com.katilijiwoadiwiyono.newsapp.utils

fun String.subStringContent(maxLength: Int = 70): String {
    return this.substring(0, maxLength) + "..."
}