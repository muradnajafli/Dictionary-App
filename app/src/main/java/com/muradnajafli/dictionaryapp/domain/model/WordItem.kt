package com.muradnajafli.dictionaryapp.domain.model

data class WordItem(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
    val sourceUrls: List<String>,
)