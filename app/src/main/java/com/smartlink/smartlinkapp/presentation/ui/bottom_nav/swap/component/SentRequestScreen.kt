package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.R


import com.smartlink.smartlinkapp.ui.theme.Vibrant_Green

@Composable
fun SentRequestScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SentSwapRequestFilterRow()

        Spacer(Modifier.height(24.dp))

        SwapRequestCard(
            userImage = R.drawable.avatar_image,
            userName = "Robbie Harrison",
            experienceText = "8years +",
            favorites = "3k+",
            swaps = "65+",
            chats = "146",
            actionContent = {
                RequestActionButton(
                    buttonColor = Vibrant_Green,
                    buttonText = "UNSWAP"
                )
            }

        )

        Spacer(Modifier.height(24.dp))

        SwapRequestCard(
            userImage = R.drawable.avatar_image2,
            userName = "James Smith",
            experienceText = "5years +",
            favorites = "5k+",
            swaps = "60+",
            chats = "128",
            rating = 4.0f,
            actionContent = {
                RequestActionButton(
                    buttonColor = Vibrant_Green,
                    buttonText = "UNSWAP"
                )
            }
        )

        Spacer(Modifier.height(24.dp))
        WarningText()
    }
}
