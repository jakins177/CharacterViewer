package com.sample.simpsonsviewer.util

fun parseName(example: String): String {
    val delimiter = " - "
    val splitString = example.split(delimiter)
    return if (splitString.size > 1) {
        splitString[0].trim()
    } else {
        return ""
    }
}