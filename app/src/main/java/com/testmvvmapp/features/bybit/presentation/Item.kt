package com.testmvvmapp.features.bybit.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testmvvmapp.features.bybit.data.models.MainInfo
import com.testmvvmapp.ui.*

@Composable
fun Item(
    data : MainInfo,
    isFavorite : Boolean,
    onFavouriteChange : (Boolean) -> Unit,
    modifier : Modifier = Modifier
) {
    Box(modifier) {
        FredCardView(
            Modifier.matchParentSize(),
            MaterialTheme.colorScheme.errorContainer,
            MaterialTheme.colorScheme.onErrorContainer
        )
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            FredText(data.title, MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            FredText(data.description)
            Spacer(modifier = Modifier.height(8.dp))
            FredText("${data.type.title}: ${data.type.key}")
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(Modifier.fillMaxWidth()) {
                items(data.tags) {
                    FredText(it)
                    Spacer(Modifier.width(8.dp))
                }
            }
            FredText(data.url, MaterialTheme.typography.bodySmall)
            FredCheckbox(isFavorite, onFavouriteChange)
        }
    }
}