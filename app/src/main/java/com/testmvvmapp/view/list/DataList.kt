package com.testmvvmapp.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.testmvvmapp.R.string
import com.testmvvmapp.model.service.util.ConnectionStatus
import com.testmvvmapp.ui.*
import com.testmvvmapp.view_model.BybitVM

@Composable
fun DataList(controller: NavHostController,viewModel: BybitVM) {
    val state = viewModel.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        if (state.first == ConnectionStatus.LOADING) CircularProgressIndicator(Modifier.align(Alignment.Center))
        Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
            FredTextHeader(stringResource(string.shop))
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.second) { mainInfo ->
                    var isFavorite by remember { mutableStateOf(mainInfo.favorite) }
                    Item(mainInfo,isFavorite,{
                        isFavorite = it
                        mainInfo.favorite = it
                    },Modifier.fillMaxWidth())
                    Spacer(Modifier.height(8.dp))
                }
                item {
                    Row(Modifier.fillMaxWidth(),Arrangement.SpaceAround,Alignment.CenterVertically) {
                        FredButton({ controller.navigateUp() },stringResource(string.goBack))
                        this@Box.ShowInternetInfo({ viewModel.getData() },state.first)
                        FredButton({ controller.navigate(ScreenRoutes.Favorites.route) }, stringResource(string.favourites))
                    }
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}
@Composable
fun BoxScope.ShowInternetInfo(action: () -> Unit,state: ConnectionStatus) {
    val tryAgain = stringResource(string.tryAgain)
    TextButton(
        action,
        Modifier.align(Alignment.BottomCenter),
        enabled = when(state) {
            ConnectionStatus.LOADING, ConnectionStatus.SUCCESS -> false
            else -> true
        }
    ) {
        Text(
            when(state) {
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