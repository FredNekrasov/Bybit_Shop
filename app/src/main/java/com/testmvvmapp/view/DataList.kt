package com.testmvvmapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.testmvvmapp.R
import com.testmvvmapp.view_model.MainViewModel

@Composable
fun DataList(viewModel: MainViewModel) {
    val state = viewModel.resultSF.collectAsState().value
    val tryAgain = stringResource(R.string.tryAgain)
    Box(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            items(state.second){ mainInfo ->
                Item(mainInfo,Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}