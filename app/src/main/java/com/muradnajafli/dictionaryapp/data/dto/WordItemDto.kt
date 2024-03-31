package com.muradnajafli.dictionaryapp.data.dto


import com.google.gson.annotations.SerializedName

data class WordItemDto(
    @SerializedName("meanings")
    val meanings: List<MeaningDto>?,
    @SerializedName("sourceUrls")
    val sourceUrls: List<String>?,
    @SerializedName("word")
    val word: String?,
    @SerializedName("phonetic")
    val phonetic: String?
)