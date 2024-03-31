package com.muradnajafli.dictionaryapp.domain.usecase

import com.muradnajafli.dictionaryapp.domain.model.WordItem
import com.muradnajafli.dictionaryapp.domain.repository.DictionaryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.muradnajafli.dictionaryapp.util.Result


class GetWordsUseCaseImpl @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) : GetWordsUseCase {
    override suspend fun invoke(word: String): Flow<Result<WordItem>> {
        return dictionaryRepository.getWordResult(word)
    }
}
interface GetWordsUseCase {
    suspend operator fun invoke(word: String): Flow<Result<WordItem>>
}
