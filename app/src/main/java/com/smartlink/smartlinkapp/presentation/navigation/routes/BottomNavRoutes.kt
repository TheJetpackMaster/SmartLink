package com.smartlink.smartlinkapp.presentation.navigation.routes

sealed class BottomNavRoutes(val route: String) {
    data object BottomRoutes : BottomNavRoutes(route = "Bottom_Route")
    data object HomeScreen : BottomNavRoutes(route = "Home_Screen")
    data object SmsScreen : BottomNavRoutes(route = "Sms_Screen")
    data object SwapSkillScreen : BottomNavRoutes(route = "SwapSkill_Screen")
    data object ProfileScreen : BottomNavRoutes(route = "Profile_Screen")
    data object CommunityScreen : BottomNavRoutes(route = "Community_Screen")
}