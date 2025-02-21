package com.smartlink.smartlinkapp.presentation.ui.mainscreen

import android.R.attr.onClick
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.smartlink.smartlinkapp.presentation.navigation.navgraph.RootNavHost
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.BottomBarItem
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.CustomBottomBar
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.navigation.routes.BottomNavRoutes
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.backgroundColor
import com.smartlink.smartlinkapp.presentation.ui.mainscreen.components.BottomBarItems
import com.smartlink.smartlinkapp.presentation.ui.mainscreen.components.CustomMainPageTopBar
import com.smartlink.smartlinkapp.presentation.ui.mainscreen.components.NavigationDrawerContent



@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val currentBottomNavState =
        rememberSaveable { mutableStateOf(BottomNavRoutes.HomeScreen.route) }
    val showTopBar = listOf<String>(
        BottomNavRoutes.HomeScreen.route,
        BottomNavRoutes.ProfileScreen.route,
        BottomNavRoutes.SmsScreen.route,
        BottomNavRoutes.SwapSkillScreen.route
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    // Main page Navigation Drawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            // Navigation Drawer Content Function
            NavigationDrawerContent(
                scope = scope,
                drawerState = drawerState,
                navController = navController
            )
        }
    ) {
        Scaffold(
            topBar = {

                if (currentRoute != null && showTopBar.contains(currentRoute)) {
                    CustomMainPageTopBar(
                        drawerState = drawerState,
                        scope = scope
                    )
                }
            },
            bottomBar = {
                // Custom Bottom bar
                CustomBottomBar(
                    items = BottomBarItems(),
                    navController = navController,
                    currentBottomNavSate = currentBottomNavState

                )
            },
            containerColor = backgroundColor,
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    //.padding(innerPadding)
                    .fillMaxSize()
            ) {
                RootNavHost(navController)
            }
        }

    }
}

