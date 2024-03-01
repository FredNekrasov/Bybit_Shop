package com.testmvvmapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.ui.FredCardView
import com.testmvvmapp.ui.FredText

@Composable
fun Item(data: MainInfo, modifier: Modifier = Modifier) {
    Box(modifier) {
        FredCardView(Modifier.matchParentSize(), MaterialTheme.colorScheme.errorContainer, MaterialTheme.colorScheme.onErrorContainer)
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
        }
    }
}