package com.muradnajafli.dictionaryapp.domain.repository

import com.muradnajafli.dictionaryapp.domain.model.WordItem
import com.muradnajafli.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}