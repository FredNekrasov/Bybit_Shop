package com.testmvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.testmvvmapp.ui.ScreenRoutes
import com.testmvvmapp.ui.theme.TestMVVMAppTheme
import com.testmvvmapp.view.Authorization
import com.testmvvmapp.view.Registration
import com.testmvvmapp.view.list.DataList
import com.testmvvmapp.view.list.FavouriteList
import com.testmvvmapp.view.profile.Profile
import com.testmvvmapp.view_model.BybitVM
import com.testmvvmapp.view_model.UserVM

class MainActivity : ComponentActivity() {
    private val bybitVM: BybitVM by viewModels()
    private val userVM: UserVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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