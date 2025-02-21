package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.ui.theme.Creamy_Vanilla
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.CustomTabIndicator
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.ReceivedRequestScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.SentRequestScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapScreen() {
    Scaffold(
        containerColor = Creamy_Vanilla,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Muted_Gold
                ),
                title = {
                    Text(
                        text = "Swap",
                        color = Creamy_Vanilla
                    )
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(R.drawable.searchicon),
                            contentDescription = "",
                            tint = Creamy_Vanilla
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Creamy_Vanilla
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val tabTitles = listOf(ToggleTab.SEND, ToggleTab.RECEIVED)
            var selectedTab by remember { mutableStateOf(ToggleTab.SEND) }
            val pagerState = rememberPagerState(initialPage = 1) { 2 }
            val coroutineScope = rememberCoroutineScope()

            TabRow(
                modifier = Modifier.height(75.dp),
                selectedTabIndex = selectedTab.ordinal,
                containerColor = Color(0xFFFFF7D4),
                indicator = { tabPositions ->
                    CustomTabIndicator(
                        tabsPos = tabPositions,
                        pagerState = pagerState
                    )
                },
                divider = {
                    HorizontalDivider(
                        thickness = 5.dp,
                        color = Color.White
                    )
                }
            ) {
                tabTitles.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTab == tab,
                        onClick = {
                            selectedTab = tab
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                        modifier = Modifier.background(Color(0xFFFFF7D4))
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(vertical = 8.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 6.dp),
                                text = tab.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (selectedTab == tab) Color.Black else Color(0xFF7D7564)
                            )
                        }
                    }
                }
            }

            HorizontalPager(
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> {
                        SentRequestScreen()
                    }

                    1 -> {
                        ReceivedRequestScreen()
                    }
                }
            }
        }
    }
}




enum class ToggleTab { SEND, RECEIVED }


//@Preview
//@Composable
//fun SwapScreenPreview() {
//
//    SwapScreen()
//
//}
