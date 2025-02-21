package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.primaryColor

@Composable
fun TopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Swap, learn, grow",
            color = Color.Black,
            fontSize = 27.sp,
            fontWeight = FontWeight.SemiBold
        )
        TopSectionCard()
    }
}


@Composable
fun TopSectionCard() {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(cardBackgroundColor),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Most Collaborated",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )

                Row() {
                    listOf(R.drawable.person_1, R.drawable.person_2, R.drawable.person_3).forEach { person ->
                        Image(
                            painter = painterResource(person),
                            contentDescription = "Collaborator",
                            modifier = Modifier
                                .size(25.dp)
                                .background(primaryColor, shape = CircleShape)
                                .clip(shape = CircleShape)
                        )
                    }
                    Text(text = "100+", fontSize = 10.sp, color = Color.Black)
                }
            }

            Text(
                text = "Discover the most accomplished and influential professionals",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithText(painterResource(R.drawable.favorite), "20k+")
                IconWithText(painterResource(R.drawable.reshare), "50k+")
                IconWithText(painterResource(R.drawable.comment), "20k+")
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "See more",
                    color = Color.Black,
                    fontSize = 14.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Composable
fun IconWithText(icon: Painter, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = icon, contentDescription = null, modifier = Modifier.size(20.dp))
        Text(text = label, fontSize = 12.sp, color = Color.Black, modifier = Modifier.padding(start = 4.dp))
    }
}
