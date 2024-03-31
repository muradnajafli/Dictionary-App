package com.muradnajafli.dictionaryapp.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.dictionaryapp.domain.model.Meaning

@Composable
fun MeaningItem(
    index: Int,
    meaning: Meaning
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        MeaningHeader(index = index, partOfSpeech = meaning.partOfSpeech)
        MeaningDetail(title = "Definition: ", detail = meaning.definition.definition)
        MeaningDetail(title = "Example:   ", detail = meaning.definition.example)
        MeaningList(title = "Synonyms: ", items = meaning.definition.synonyms)
        MeaningList(title = "Antonyms: ", items = meaning.definition.antonyms)
    }
}

@Composable
private fun MeaningHeader(index: Int, partOfSpeech: String) {
    Text(
        text = "${index + 1}. $partOfSpeech",
        fontSize = 17.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                        Color.Transparent
                    )
                )
            )
            .padding(top = 4.dp, bottom = 4.dp, start = 12.dp, end = 12.dp)
    )
}

@Composable
private fun MeaningDetail(title: String, detail: String) {
    if (detail.isNotEmpty()) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = detail,
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
private fun MeaningList(title: String, items: List<Any?>) {
    if (items.isNotEmpty()) {
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.padding(horizontal = 4.dp)
        ) {
            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = items.joinToString(", "),
                fontSize = 17.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}