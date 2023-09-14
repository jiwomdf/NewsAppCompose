package com.katilijiwoadiwiyono.newsapp.utils

import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

fun String.toDateGlobalFormat(): Date? {
    val knownPatterns = ArrayList<SimpleDateFormat>()
    knownPatterns.add(SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.getDefault()))
    for (pattern in knownPatterns) {
        try {
            pattern.parse(this)?.let {
                return it
            }
        } catch (pe: Exception) {
            pe.printStackTrace()
        }
    }
    return null
}