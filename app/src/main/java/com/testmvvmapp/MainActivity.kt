package com.testmvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.testmvvmapp.bybit.presentation.DataList
import com.testmvvmapp.bybit.presentation.FavouriteList
import com.testmvvmapp.bybit.presentation.viewModel.BybitVM
import com.testmvvmapp.ui.ScreenRoutes
import com.testmvvmapp.ui.theme.TestMVVMAppTheme
import com.testmvvmapp.user.presentation.Authorization
import com.testmvvmapp.user.presentation.Registration
import com.testmvvmapp.user.presentation.profile.Profile
import com.testmvvmapp.user.presentation.viewModel.UserVM
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bybitVM: BybitVM = getViewModel()
        val userVM: UserVM = getViewModel()
        setContent {
            TestMVVMAppTheme {
                Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val controller = rememberNavController()
                    Scaffold { padding ->
                        Column(Modifier.fillMaxSize().padding(padding)) {
                            NavHost(controller,ScreenRoutes.Authorization.route){
                                composable(ScreenRoutes.Authorization.route){ Authorization(controller, userVM) }
                                composable(ScreenRoutes.Registration.route){ Registration(controller, userVM) }
                                composable(ScreenRoutes.Profile.route){ Profile(controller, userVM) }
                                composable(ScreenRoutes.DataList.route){ DataList(controller, bybitVM) }
                                composable(ScreenRoutes.Favorites.route) { FavouriteList(controller, bybitVM) }
                            }
                        }
                    }
                }
            }
        }
    }
}