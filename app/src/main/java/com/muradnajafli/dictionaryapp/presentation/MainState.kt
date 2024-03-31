package com.muradnajafli.dictionaryapp.presentation

import com.muradnajafli.dictionaryapp.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",

    val wordItem: WordItem? = null
)