package com.smartlink.smartlinkapp.presentation.navigation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.smartlink.smartlinkapp.presentation.navigation.routes.BottomNavRoutes

@Composable
fun RootNavHost(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavRoutes.BottomRoutes.route,
        route = "ROOT"
    ) {
        bottomNavHost(navController = navHostController)
    }
}