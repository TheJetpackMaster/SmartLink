package com.smartlink.smartlinkapp.presentation.ui.mainscreen.components

import androidx.compose.runtime.Composable
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.BottomBarItem
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.navigation.routes.BottomNavRoutes

@Composable
fun BottomBarItems(): List<BottomBarItem> {
    return listOf(
        BottomBarItem(
            "Home",
            R.drawable.home_icon,
            route = BottomNavRoutes.HomeScreen.route
        ),
        BottomBarItem(
            "Chat",
            R.drawable.chat_icon,
            route = BottomNavRoutes.SmsScreen.route
        ),
        BottomBarItem(
            "Swap",
            R.drawable.swap_icon,
            route = BottomNavRoutes.SwapSkillScreen.route
        ),
        BottomBarItem(
            "Profile",
            R.drawable.profile_icon,
            route = BottomNavRoutes.ProfileScreen.route
        )
    )
}
