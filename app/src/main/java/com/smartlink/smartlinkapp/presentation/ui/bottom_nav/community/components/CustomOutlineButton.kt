package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor

@Composable
fun CustomOutlineButton(
    isFilter: Boolean = false,
    modifier: Modifier = Modifier,
    text: String = "Filter",
    texSize: TextUnit = 14.sp
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = { expanded = true },
        modifier = modifier,
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, cardBackgroundColor)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            if (isFilter) {
                Icon(
                    painter = painterResource(R.drawable.filter),
                    contentDescription = null,
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(6.dp))
            }
            Text(text = text, color = Color.Black, fontSize = texSize)
        }

        if (isFilter){
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = cardBackgroundColor
            ) {
                listOf("Musician", "Dancer", "Artist").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(text = option, color = Color.Black) },
                        onClick = { expanded = false }
                    )
                }
            }
        }

    }
}