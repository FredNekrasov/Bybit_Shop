package com.testmvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.testmvvmapp.ui.ScreenRoutes
import com.testmvvmapp.ui.theme.TestMVVMAppTheme
import com.testmvvmapp.view.Authorization
import com.testmvvmapp.view.Registration
import com.testmvvmapp.view.list.DataList
import com.testmvvmapp.view.list.FavouriteList
import com.testmvvmapp.view.profile.Profile
import com.testmvvmapp.view_model.MainViewModel
import com.testmvvmapp.view_model.UserVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    private val userVM: UserVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestMVVMAppTheme {
                Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    Scaffold { padding ->
                        Column(Modifier.fillMaxSize().padding(padding)) {
                            NavHost(navController,ScreenRoutes.Authorization.route){
                                composable(ScreenRoutes.Authorization.route){
                                    Authorization(navController, userVM)
                                }
                                composable(ScreenRoutes.Registration.route){
                                    Registration(navController, userVM)
                                }
                                composable(ScreenRoutes.Profile.route){
                                    Profile(navController, userVM)
                                }
                                composable(ScreenRoutes.DataList.route){
                                    DataList(viewModel)
                                }
                                composable(ScreenRoutes.Favorites.route){
                                    FavouriteList(viewModel)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}