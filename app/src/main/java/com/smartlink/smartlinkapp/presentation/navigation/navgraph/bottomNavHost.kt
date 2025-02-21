package com.smartlink.smartlinkapp.presentation.navigation.navgraph

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.smartlink.smartlinkapp.presentation.navigation.routes.BottomNavRoutes
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.CommunityScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.HomeScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.profile.ProfileScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.skillswap.SkillSwapScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.sms.SmsScreen


fun NavGraphBuilder.bottomNavHost(navController: NavController) {
    navigation(
        startDestination = BottomNavRoutes.CommunityScreen.route,
        route = BottomNavRoutes.BottomRoutes.route
    ) {

        // Home Screen
        composable(BottomNavRoutes.HomeScreen.route,
            popEnterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(250))
            },
            enterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(250))
            }
        ) {
            HomeScreen()
        }

        // SMS Screen
        composable(BottomNavRoutes.SmsScreen.route,
            popEnterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(250))
            },
            enterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(250))
            }
        ) {
            SmsScreen()
        }

        // Skill Swap Screen
        composable(BottomNavRoutes.SwapSkillScreen.route,
            popEnterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(250))
            },
            enterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(250))
            }
        ) {
            SkillSwapScreen()
        }

        // Profile Screen
        composable(BottomNavRoutes.ProfileScreen.route,
            popEnterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(250))
            },
            enterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(250))
            }
        ) {
            ProfileScreen()
        }

        // Community Screen
        composable(BottomNavRoutes.CommunityScreen.route,
            popEnterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(250))
            },
            enterTransition = {
                fadeIn(animationSpec = tween(250))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(250))
            }
        ) {
            CommunityScreen(navController = navController)
        }
    }
}