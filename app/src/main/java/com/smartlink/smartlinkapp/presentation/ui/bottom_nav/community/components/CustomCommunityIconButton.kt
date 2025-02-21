package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor

@Composable
fun CustomCommunityIconButton(
    icon: Int,
    iconSize: Dp = 20.dp,
    onClick: () -> Unit,
    buttonSize: Dp = 30.dp,
    isVoice: Boolean = false
) {
    val buttonColor = if (isVoice) cardBackgroundColor else Color.Transparent
    IconButton(
        onClick = onClick,  // FIX: Now properly invokes onClick
        modifier = Modifier.size(buttonSize),
        colors = IconButtonDefaults.iconButtonColors(buttonColor)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(iconSize)
        )
    }
}