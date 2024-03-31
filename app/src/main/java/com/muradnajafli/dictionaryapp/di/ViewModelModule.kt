package com.muradnajafli.dictionaryapp.di

import com.muradnajafli.dictionaryapp.domain.repository.DictionaryRepository
import com.muradnajafli.dictionaryapp.domain.usecase.GetWordsUseCase
import com.muradnajafli.dictionaryapp.domain.usecase.GetWordsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideGetWordsUseCase(
        dictionaryRepository: DictionaryRepository
    ): GetWordsUseCase {
        return GetWordsUseCaseImpl(dictionaryRepository)
    }
}