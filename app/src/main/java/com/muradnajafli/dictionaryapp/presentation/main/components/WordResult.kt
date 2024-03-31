package com.muradnajafli.dictionaryapp.presentation.main.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muradnajafli.dictionaryapp.domain.model.WordItem

@Composable
fun WordResult(
    wordItem: WordItem
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(
            vertical = 32.dp
        )
    ) {
        itemsIndexed(wordItem.meanings) { index, meaning ->
            MeaningItem(
                index = index,
                meaning = meaning
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }

}