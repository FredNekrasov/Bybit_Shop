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
import com.testmvvmapp.viewModels.BybitVM

@Composable
fun FavouriteList(controller: NavHostController, bybitVM: BybitVM) {
    val state = bybitVM.resultSF.collectAsState().value
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
            FredTextHeader(stringResource(R.string.favourites))
            Spacer(Modifier.height(16.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(state.second) { mainInfo ->
                    if(mainInfo.favorite) {
                        var isFavorite by remember { mutableStateOf(mainInfo.favorite) }
                        Item(mainInfo,isFavorite,{
                            isFavorite = it
                            mainInfo.favorite = it
                        },Modifier.fillMaxWidth())
                        Spacer(Modifier.height(8.dp))
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
}