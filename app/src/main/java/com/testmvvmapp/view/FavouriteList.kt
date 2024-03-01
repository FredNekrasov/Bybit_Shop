package com.testmvvmapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.testmvvmapp.view_model.MainViewModel

@Composable
fun FavouriteList(viewModel: MainViewModel) {
    val state = viewModel.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(state.second) { mainInfo ->
                if(mainInfo.favorite) {
                    Item(mainInfo,Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}