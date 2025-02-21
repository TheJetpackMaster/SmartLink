package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Radiant_Gold
import com.smartlink.smartlinkapp.ui.theme.Stone_Gray

@Composable
fun ReceivedRequestScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        SwapRequestCard(
            cardColor = Color.White,
            elevation = 5.dp,
            cornerRadius = 24.dp,
            padding = 12.dp,
            profileImageSize = 100.dp,
            profileCornerRadius = 12.dp,
            userImage = R.drawable.avatar_image,
            userName = "Robbie Harrison",
            profession = "Musician",
            rating = 3f,
            favorites = "3k+",
            swaps = "65+",
            chats = "146",
            actionContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    RequestActionButton(
                        buttonText = "ACCEPT",
                        buttonColor = Radiant_Gold
                    )

                    RequestActionButton(
                        buttonText = "DECLINE",
                        buttonColor = Stone_Gray
                    )
                }
            }
        )

        SwapRequestCard(
            cardColor = Color.White,
            elevation = 5.dp,
            cornerRadius = 24.dp,
            padding = 12.dp,
            profileImageSize = 100.dp,
            profileCornerRadius = 12.dp,
            userImage = R.drawable.avatar_image3,
            userName = "Jessamine Mumtaz",
            profession = "Designer",
            rating = 3f,
            favorites = "258",
            swaps = "23",
            chats = "19",
            experienceText = "4year +",
            actionContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    RequestActionButton(
                        buttonText = "ACCEPT",
                        buttonColor = Radiant_Gold
                    )

                    RequestActionButton(
                        buttonText = "DECLINE",
                        buttonColor = Stone_Gray
                    )
                }
            }
        )

        SwapRequestCard(
            cardColor = Color.White,
            elevation = 5.dp,
            cornerRadius = 24.dp,
            padding = 12.dp,
            profileImageSize = 100.dp,
            profileCornerRadius = 12.dp,
            userImage = R.drawable.avatar_image3,
            userName = "William David",
            profession = "Stock Trader",
            rating = 3f,
            favorites = "500",
            swaps = "41",
            chats = "200",
            experienceText = "5year +",
            actionContent = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    RequestActionButton(
                        buttonText = "ACCEPT",
                        buttonColor = Radiant_Gold
                    )

                    RequestActionButton(
                        buttonText = "DECLINE",
                        buttonColor = Stone_Gray
                    )
                }

            }
        )
    }
}
