package com.muradnajafli.dictionaryapp.presentation.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muradnajafli.dictionaryapp.presentation.MainUiEvents

@Composable
fun SearchSection(
    searchWord: String,
    onEvent: (MainUiEvents) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = searchWord,
        onValueChange = {
            onEvent(MainUiEvents.OnSearchWordChanged(it))
        },
        trailingIcon = {
            IconButton(
                onClick = {
                    onEvent(MainUiEvents.OnSearchWordSubmitted)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        },
        label = {
            Text(
                text = "Search Word",
                fontSize = 15.sp,
                modifier = Modifier.alpha(0.7f)
            )
        },
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onEvent(MainUiEvents.OnSearchWordSubmitted)
            }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        singleLine = true
    )
}