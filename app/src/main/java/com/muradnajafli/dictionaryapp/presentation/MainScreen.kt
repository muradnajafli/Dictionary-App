package com.muradnajafli.dictionaryapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.dictionaryapp.presentation.main.components.WordResult

@Composable
fun MainScreen(
    mainState: MainState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        InitialWordInfo(mainState = mainState)

        Spacer(modifier = Modifier.height(30.dp))

        WordContent(mainState = mainState)

    }
}

@Composable
private fun InitialWordInfo(
    mainState: MainState
) {
    if (mainState.searchWord.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 30.dp)
        ) {
            mainState.wordItem?.let { wordItem ->

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = wordItem.word,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = wordItem.phonetic,
                    fontSize = 17.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column {
                    wordItem.sourceUrls.forEach {
                        Text(
                            text = it,
                            fontSize = 17.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }
            }
        }
    }

}

@Composable
private fun WordContent(
    mainState: MainState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                )
            )
            .background(
                MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
            )
    ) {
        if (mainState.searchWord.isNotEmpty()) {
            if (mainState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colorScheme.primary
                )
            } else {
                mainState.wordItem?.let { wordItem ->
                    WordResult(wordItem = wordItem)
                }
            }
        } else {
            Text(
                text = "Search a word",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}