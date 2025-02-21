package com.smartlink.smartlinkapp.presentation.ui.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material3.DrawerState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.primaryColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomMainPageTopBar(drawerState: DrawerState, scope: CoroutineScope) {
    Column(
        modifier = Modifier
            .background(primaryColor)
            //.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TopBarIconButton(
                painterResource(R.drawable.topbar_menu),
                onClick = { scope.launch { drawerState.open() } })
            Spacer(modifier = Modifier.weight(1f))
            TopBarIconButton(painterResource(R.drawable.topbar_search), onClick = {})
            TopBarIconButton(painterResource(R.drawable.topbar_premium), onClick = {})
        }
    }
}

@Composable
fun TopBarIconButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.size(18.dp),
    tint: Color = Color.White,
) {
    IconButton(onClick = onClick) {
        Icon(painter = icon, contentDescription = "Top Bar Icon", modifier = modifier, tint = tint)
    }
}