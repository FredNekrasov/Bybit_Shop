package com.testmvvmapp.ui

sealed class ScreenRoutes(val route: String) {
    data object DataList : ScreenRoutes("DataListRoute")
    data object Authorization : ScreenRoutes("AuthorizationRoute")
    data object Registration : ScreenRoutes("RegistrationRoute")
    data object Profile : ScreenRoutes("ProfileRoute")
    data object Favorites : ScreenRoutes("FavoritesRoute")
}