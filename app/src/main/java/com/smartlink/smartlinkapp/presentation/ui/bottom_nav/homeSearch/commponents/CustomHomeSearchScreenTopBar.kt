package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.homeSearch.commponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material3.DrawerState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.backgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.primaryColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CustomHomeSearchScreenTopBar(textValue: MutableState<String>) {
    Column(
        modifier = Modifier.background(primaryColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left Icon (Back Arrow)
            TopBarIconButton(
                painterResource(R.drawable.right_arrow),
                modifier = Modifier.size(25.dp),
                onClick = { }
            )

            // Search Field (Takes Remaining Space)
            CustomHomeScreenSearchField(
                textValue = textValue,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )

            // Right Icon (Mic with Background)
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .background(backgroundColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                TopBarIconButton(
                    painterResource(R.drawable.mic),
                    tint = Color.Black,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun TopBarIconButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.size(18.dp),
    tint: Color = Color.White,
) {
    IconButton(onClick = onClick) {
        Icon(painter = icon, contentDescription = "Top Bar Icon", modifier = modifier, tint = tint)
    }
}

@Composable
fun CustomHomeScreenSearchField(
    textValue: MutableState<String>,
    modifier: Modifier = Modifier,
) {
    BasicTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
        modifier = modifier
            .height(35.dp)
            .background(backgroundColor, shape = RoundedCornerShape(20.dp)),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    //  .padding(horizontal = 12.dp)
                    .background(Color.Transparent, shape = RoundedCornerShape(20.dp)),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (textValue.value.isEmpty()) {
                        Text(
                            text = "Search here!",
                            color = Color.Black.copy(0.6f),
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                }
                if (textValue.value.isNotEmpty()){
                    VerticalDivider(color = Color.Black)
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(40.dp)
                            .background(
                                Color.Transparent,
                                shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.searchicon),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

            }

        }
    )
}