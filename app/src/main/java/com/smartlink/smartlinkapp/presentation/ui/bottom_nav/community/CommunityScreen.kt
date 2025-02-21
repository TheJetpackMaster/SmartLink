package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CustomCommunityPageTopBar
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.HomeContent
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.MainSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components.TopSection
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.backgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.primaryColor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CommunityContentMainSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CommunityContentTopSection

@Composable
fun CommunityScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomCommunityPageTopBar(onClick = { navController.popBackStack() }) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        CommunityContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun CommunityContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().background(backgroundColor)) {
        CommunityContentTopSection()
        CommunityContentMainSection()
    }
}









