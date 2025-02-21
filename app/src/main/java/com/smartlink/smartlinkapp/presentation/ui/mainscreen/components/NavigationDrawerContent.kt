package com.smartlink.smartlinkapp.presentation.ui.mainscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.navigation.routes.BottomNavRoutes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerContent(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavController,
) {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.7f)
            .background(
                Color.White,
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            )
            .statusBarsPadding()
    ) {
        // Top Section
        DrawerTopSection(
            drawerState = drawerState,
            scope = scope
        )

        HorizontalDivider(color = Color.Black)
        Spacer(modifier = Modifier.fillMaxHeight(0.075f))

        // Main Section
        Column {
            DrawerMainSection(
                drawerState = drawerState,
                scope = scope,
                navController = navController
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Section
        Column(modifier = Modifier.padding(bottom = 8.dp)) {
            DrawerBottomSection(drawerState=drawerState,scope=scope, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun DrawerTopSection(drawerState: DrawerState, scope: CoroutineScope) {
    DrawerItemRow(
        icon = painterResource(R.drawable.right_arrow),
        label = "Menu",
        iconSize = 25.dp,
        textSize = 20.sp,
        drawerState = drawerState,
        scope = scope,
        isNavBackButton = true
    )
}

@Composable
fun DrawerMainSection(drawerState: DrawerState, scope: CoroutineScope,navController: NavController) {
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.personal_details),
        label = "Personal details",
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.community),
        label = "Community",
        drawerState = drawerState,
        scope = scope,
        onClick = {
            scope.launch { drawerState.close() }
            navController.navigate(BottomNavRoutes.CommunityScreen.route)

        }
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.premium),
        label = "Premium",
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.time_table),
        label = "Time Table",
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.portfolio),
        label = "Portfolio",
        endIcon = painterResource(R.drawable.topbar_premium),
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
    DrawerItemRow(
        icon = painterResource(R.drawable.personalise_coaching),
        label = "Personalise Coaching",
        endIcon = painterResource(R.drawable.topbar_premium),
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    HorizontalDivider(color = Color.Black.copy(0.2f))
}

@Composable
fun DrawerBottomSection(drawerState: DrawerState,scope: CoroutineScope,modifier: Modifier){
    Text(
        text = "Privacy Policy • Terms of Service",
        color = Color.Black,
        fontSize = 12.sp,
        modifier = modifier
    )
    HorizontalDivider(color = Color.Black)
    DrawerItemRow(
        icon = painterResource(R.drawable.help_icon),
        label = "Help and feedback ",
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
    DrawerItemRow(
        icon = painterResource(R.drawable.logout_icon),
        label = "Log out",
        drawerState = drawerState,
        scope = scope,
        onClick = {}
    )
}

@Composable
fun DrawerItemRow(
    icon: Painter,
    label: String,
    iconSize: Dp = 20.dp,
    textSize: TextUnit = 16.sp,
    isNavBackButton: Boolean = false,
    endIcon: Painter? = null,
    drawerState: DrawerState,
    scope: CoroutineScope,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Full width to align icons properly
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row( // Wrap icon and text
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp).fillMaxWidth(0.8f) // Allows text to take available space
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(iconSize)
                    .clickable { if (isNavBackButton)(scope.launch { drawerState.close() }) }
            )
            Spacer(modifier = Modifier.width(12.dp)) // Space between icon and text

            Text(
                text = label,
                color = Color.Black,
                fontSize = textSize,
                maxLines = 2, // Allows multi-line text
                modifier = Modifier.wrapContentWidth() // Expands naturally
            )
        }
        if (endIcon != null) {
            Image(
                painter = endIcon,
                contentDescription = null,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}