package com.testmvvmapp.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.testmvvmapp.R
import com.testmvvmapp.ui.*
import com.testmvvmapp.view_model.MainViewModel

@Composable
fun FavouriteList(controller: NavHostController,viewModel: MainViewModel) {
    val state = viewModel.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Row(Modifier.fillMaxWidth(),Arrangement.Center,Alignment.CenterVertically) {
                    FredTextHeader(stringResource(R.string.favourites))
                }
                Spacer(Modifier.height(32.dp))
            }
            items(state.second) { mainInfo ->
                if(mainInfo.favorite) {
                    Item(mainInfo,Modifier.fillMaxWidth())
                    Spacer(Modifier.height(16.dp))
                }
            }
            item {
                Row(Modifier.fillMaxWidth(),Arrangement.Center,Alignment.CenterVertically) {
                    FredButton({ controller.navigateUp() },stringResource(R.string.goBack))
                }
                Spacer(Modifier.height(16.dp))
            }
        }
    }
}