package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.R


@Composable
fun CommunityContentTopSection() {
    val textValue = rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CustomCommunityIconButton(
            icon = R.drawable.topbar_search,
            iconSize = 20.dp,
            onClick = {},
            buttonSize = 30.dp
        )

        CustomCommunitySearchField(textValue)

        Spacer(modifier = Modifier.width(10.dp))

        CustomCommunityIconButton(
            icon = R.drawable.mic,
            iconSize = 20.dp,
            onClick = {},
            buttonSize = 30.dp,
            isVoice = true
        )
    }
}