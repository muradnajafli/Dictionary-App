package com.muradnajafli.dictionaryapp.di

import com.muradnajafli.dictionaryapp.data.repository.DictionaryRepositoryImpl
import com.muradnajafli.dictionaryapp.domain.repository.DictionaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindDictionaryRepository(
        dictionaryRepository: DictionaryRepositoryImpl
    ): DictionaryRepository

}