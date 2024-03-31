package com.muradnajafli.dictionaryapp.data.mapper

import com.muradnajafli.dictionaryapp.data.dto.DefinitionDto
import com.muradnajafli.dictionaryapp.data.dto.MeaningDto
import com.muradnajafli.dictionaryapp.data.dto.WordItemDto
import com.muradnajafli.dictionaryapp.domain.model.Definition
import com.muradnajafli.dictionaryapp.domain.model.Meaning
import com.muradnajafli.dictionaryapp.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem(
    meanings = meanings?.map { it.toMeaning() } ?: emptyList(),
    sourceUrls = sourceUrls ?: emptyList(),
    word = word ?: "",
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning (
    definition = definitionDtoToDefinition(
        definitions?.get(0)
    ),
    partOfSpeech = partOfSpeech ?: ""
)

fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition (
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: "",
    synonyms = definitionDto?.synonyms ?: emptyList(),
    antonyms = definitionDto?.antonyms ?: emptyList()
)