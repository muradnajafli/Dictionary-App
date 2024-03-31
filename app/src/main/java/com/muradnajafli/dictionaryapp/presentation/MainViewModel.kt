package com.muradnajafli.dictionaryapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muradnajafli.dictionaryapp.domain.usecase.GetWordsUseCase
import com.muradnajafli.dictionaryapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWordsUseCase: GetWordsUseCase
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    private var searchJob: Job? = null

    fun onEvent(events: MainUiEvents) {
        when (events) {
            is MainUiEvents.OnSearchWordSubmitted -> {
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    loadWordResult(mainState.value.searchWord)
                }
            }
            is MainUiEvents.OnSearchWordChanged -> {
                _mainState.update {
                    it.copy(
                        searchWord = events.searchWord.lowercase()
                    )
                }
            }
        }
    }

    private fun loadWordResult(word: String) {
        viewModelScope.launch {
            getWordsUseCase(word).collect { result ->
                when (result) {
                    is Result.Error -> Unit
                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _mainState.update {
                                it.copy(
                                    wordItem = wordItem
                                )
                            }
                        }
                    }
                    is Result.Loading -> {
                        result.isLoading.let { isLoading ->
                            _mainState.update {
                                it.copy(
                                    isLoading = isLoading
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}