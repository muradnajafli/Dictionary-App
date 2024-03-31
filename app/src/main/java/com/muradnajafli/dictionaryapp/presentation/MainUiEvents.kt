package com.muradnajafli.dictionaryapp.presentation

sealed class MainUiEvents {
    data class OnSearchWordChanged(
        val searchWord: String
    ) : MainUiEvents()
    data object OnSearchWordSubmitted : MainUiEvents()
}