package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CommunityContentMainSection() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Most Searched",
                color = Color.Black,
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold
            )

            CustomOutlineButton(
                isFilter = true,
                modifier = Modifier.width(70.dp).height(30.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        repeat(6) {
            CustomOutlineButton(
                isFilter = false,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                text = "Musician",
                texSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}