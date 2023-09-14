package com.katilijiwoadiwiyono.newsapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.subStringContent(maxLength: Int = 70): String {
    return this.substring(0, maxLength) + "..."
}

fun Date.toString(f: String): String? {
    return try {
        val simpleDateFormat = SimpleDateFormat(f, Locale.getDefault())
        simpleDateFormat.format(this)
    } catch (ex: Exception) {
        null
    }
}