package com.testmvvmapp.view.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.testmvvmapp.R.string
import com.testmvvmapp.ui.*
import com.testmvvmapp.view_model.UserVM

@Composable
fun Profile(controller: NavHostController, userVM: UserVM) {
    val user = userVM.resultSF.collectAsState().value.second
    Column(Modifier.fillMaxSize(),Arrangement.Top,Alignment.CenterHorizontally) {
        FredTextHeader(stringResource(string.profile))
        Spacer(Modifier.height(16.dp))
        UserInfo(user, Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround, Alignment.CenterVertically) {
            FredButton({ controller.navigate(ScreenRoutes.DataList.route) }, stringResource(string.shop))
            FredButton({ controller.navigate(ScreenRoutes.Favorites.route) }, stringResource(string.favourites))
        }
    }
}