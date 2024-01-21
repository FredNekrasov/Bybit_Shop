package com.testmvvmapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.testmvvmapp.R
import com.testmvvmapp.model.util.ConnectionStatus
import com.testmvvmapp.view_model.MainViewModel

@Composable
fun DataList(viewModel: MainViewModel) {
    val state = viewModel.resultSF.collectAsState().value
    val tryAgain = stringResource(R.string.tryAgain)
    Box(Modifier.fillMaxSize()) {
        if (state.second != null) {
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.second!!.list){ mainInfo ->
                    Item(mainInfo,Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                }
            }
        } else {
            if (state.first == ConnectionStatus.LOADING) CircularProgressIndicator(Modifier.align(Alignment.Center))
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
                        ConnectionStatus.LOADING -> stringResource(R.string.LOADING)
                        ConnectionStatus.SUCCESS -> stringResource(R.string.SUCCESS)
                        ConnectionStatus.NO_DATA -> "${stringResource(R.string.NO_DATA)}\n${tryAgain}"
                        ConnectionStatus.CONNECTION_ERROR -> "${stringResource(R.string.CONNECTION_ERROR)}\n${tryAgain}"
                        ConnectionStatus.NO_INTERNET -> "${stringResource(R.string.NO_INTERNET)}\n${tryAgain}"
                        ConnectionStatus.UNKNOWN -> "${stringResource(R.string.UNKNOWN)}\n${tryAgain}"
                    }, textAlign = TextAlign.Center
                )
            }
        }
    }
}