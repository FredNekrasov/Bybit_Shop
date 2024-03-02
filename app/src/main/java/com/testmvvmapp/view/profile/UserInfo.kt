package com.testmvvmapp.view.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.testmvvmapp.R.string
import com.testmvvmapp.model.entities.User
import com.testmvvmapp.ui.FredCardView

@Composable
fun UserInfo(user: User?,modifier: Modifier) {
    if (user != null) {
        Box(modifier) {
            FredCardView(Modifier.matchParentSize(),MaterialTheme.colorScheme.tertiaryContainer,MaterialTheme.colorScheme.onTertiaryContainer)
            Column(modifier.padding(16.dp)) {
                Text("${stringResource(string.userName)}: ${user.userName}", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onTertiaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.password)}: ${user.password}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onTertiaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.email)}: ${user.email}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onTertiaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.name)}: ${user.firstName}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onTertiaryContainer)
                Spacer(Modifier.height(8.dp))
                Text("${stringResource(string.surname)}: ${user.lastName}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onTertiaryContainer)
            }
        }
    }
}