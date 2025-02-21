package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Charcoal_Brown
import com.smartlink.smartlinkapp.ui.theme.Golden_Sand
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.ui.theme.Pure_Black
import com.smartlink.smartlinkapp.ui.theme.Sunflower_Gold

@Composable
fun SentSwapRequestFilterRow() {

    val showRequestFilter = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedIconButton(
            modifier = Modifier
                .width(78.dp)
                .height(26.dp),
            border = BorderStroke(width = 1.dp, color = Muted_Gold),
            shape = RoundedCornerShape(6.dp),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.filtericon), contentDescription = "",
                    tint = Charcoal_Brown,
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = "Filter", color = Charcoal_Brown,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

        }

        IconButton(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(if(showRequestFilter.value) Sunflower_Gold else Color.Transparent)
                .size(28.dp),
            onClick = {
                showRequestFilter.value = !showRequestFilter.value
            }) {
            Icon(
                painter = painterResource(R.drawable.moreverticon), contentDescription = "",
                tint = Muted_Gold,
                modifier = Modifier.size(18.dp)
            )

            // Filter DropDown
            SentSwapRequestFilterDropDown(
                showRequestFilter = showRequestFilter
            )
        }
    }
}

@Composable
fun SentSwapRequestFilterDropDown(
    showRequestFilter: MutableState<Boolean>,
) {
    var selectedFilter = remember { mutableStateOf(SentRequestFilter.SEEN) }

    DropdownMenu(
        containerColor = Color.Transparent,
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        modifier = Modifier
            .width(120.dp)
            .padding(top = 14.dp)
            .background(Golden_Sand)
            .clip(RoundedCornerShape(5.dp))
            .border(
                width = 2.dp,
                color = Pure_Black,
                shape = RoundedCornerShape(5.dp)
            ),
        expanded = showRequestFilter.value,
        onDismissRequest = {
            showRequestFilter.value = false
        }
    ) {
        DropdownMenuItem(
            onClick = {
                if (selectedFilter.value == SentRequestFilter.SEEN) {
                    selectedFilter.value = SentRequestFilter.ALL
                } else {
                    selectedFilter.value = SentRequestFilter.SEEN
                }

                showRequestFilter.value = false
            },
            text = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Seen",
                        textDecoration =
                        if (selectedFilter.value == SentRequestFilter.SEEN) TextDecoration.Underline
                        else TextDecoration.None,
                        color = Charcoal_Brown
                    )
                }
            }
        )

        HorizontalDivider(color = Charcoal_Brown, thickness = 2.dp)

        DropdownMenuItem(
            onClick = {
                if (selectedFilter.value == SentRequestFilter.ACCEPTED) {
                    selectedFilter.value = SentRequestFilter.ALL
                } else {
                    selectedFilter.value = SentRequestFilter.ACCEPTED
                }

                showRequestFilter.value = false
            },
            text = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Accepted",
                        textDecoration =
                        if (selectedFilter.value == SentRequestFilter.ACCEPTED) TextDecoration.Underline
                        else TextDecoration.None,
                        color = Charcoal_Brown
                    )
                }
            }
        )

        HorizontalDivider(color = Charcoal_Brown, thickness = 2.dp)

        DropdownMenuItem(
            onClick = {
                if (selectedFilter.value == SentRequestFilter.DECLINED) {
                    selectedFilter.value = SentRequestFilter.ALL
                } else {
                    selectedFilter.value = SentRequestFilter.DECLINED
                }

                showRequestFilter.value = false
            },
            text = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Declined",
                        textDecoration =
                        if (selectedFilter.value == SentRequestFilter.DECLINED) TextDecoration.Underline
                        else TextDecoration.None,
                        color = Charcoal_Brown
                    )
                }
            }
        )
    }
}

enum class SentRequestFilter {
    ALL, SEEN, ACCEPTED, DECLINED
}
