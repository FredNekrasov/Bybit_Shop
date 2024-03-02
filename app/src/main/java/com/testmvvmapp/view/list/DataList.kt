package com.testmvvmapp.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.testmvvmapp.R.string
import com.testmvvmapp.model.service.util.ConnectionStatus
import com.testmvvmapp.view_model.MainViewModel

@Composable
fun DataList(viewModel: MainViewModel) {
    val state = viewModel.resultSF.collectAsState().value
    val tryAgain = stringResource(string.tryAgain)
    Box(Modifier.fillMaxSize()) {
        if (state.first == ConnectionStatus.LOADING) CircularProgressIndicator(Modifier.align(Alignment.Center))
        LazyColumn(Modifier.fillMaxSize()) {
            items(state.second){ mainInfo ->
                Item(mainInfo,Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))
            }
            item {
                Spacer(Modifier.height(16.dp))
                TextButton(
                    { viewModel.getData() },
                    Modifier.align(Alignment.BottomCenter),
                    enabled = when(state.first) {
                        ConnectionStatus.LOADING, ConnectionStatus.SUCCESS -> false
                        else -> true
                    }
                ) {
                    Text(
                        when(state.first) {
                            ConnectionStatus.LOADING -> stringResource(string.LOADING)
                            ConnectionStatus.SUCCESS -> stringResource(string.SUCCESS)
                            ConnectionStatus.NO_DATA -> "${stringResource(string.NO_DATA)}\n${tryAgain}"
                            ConnectionStatus.CONNECTION_ERROR -> "${stringResource(string.CONNECTION_ERROR)}\n${tryAgain}"
                            ConnectionStatus.NO_INTERNET -> "${stringResource(string.NO_INTERNET)}\n${tryAgain}"
                            ConnectionStatus.UNKNOWN -> "${stringResource(string.UNKNOWN)}\n${tryAgain}"
                        }, textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}