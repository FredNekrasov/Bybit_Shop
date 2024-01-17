package com.testmvvmapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.testmvvmapp.model.service.entities.MainInfo
import com.testmvvmapp.ui.FredCardView

@Composable
fun Item(data: MainInfo, modifier: Modifier = Modifier) {
    Box(modifier) {
        FredCardView(Modifier.matchParentSize(), MaterialTheme.colorScheme.error, MaterialTheme.colorScheme.inverseOnSurface)
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            Text(data.title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(8.dp))
            Text(data.description, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(8.dp))
            Text(data.type.title, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
            Text(data.type.key, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(Modifier.fillMaxWidth()) {
                items(data.tags) {
                    Text(it, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
                }
            }
            Text(data.url, style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.onSurface, overflow = TextOverflow.Ellipsis)
        }
    }
}