package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components.TopSection


@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = Color.Transparent,
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
           .padding(8.dp)
           .statusBarsPadding()
           ) {
            HomeContent()
        }

    }
}


@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
        //.background(backgroundColor)
    ) {
        //NavigationDrawer()
        TopSection()
        MainSection()

    }
}

@Composable
fun MainSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Free Learning",
                color = Color.Black,
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "See more",
                color = Color.Black,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline
            )
        }
        MainSectionCard()
    }
}

@Composable
fun MainSectionCard() {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(285.dp)

    ) {

        //Spacer(modifier = Modifier.padding(top = 200.dp))
        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxSize()
                .shadow(2.dp, shape = RoundedCornerShape(16.dp))
                .background(cardLightBackgroundColor, shape = RoundedCornerShape(16.dp))

        ) {}


        Column(
            modifier = Modifier
                .padding(4.dp)
                .shadow(2.dp, shape = RoundedCornerShape(16.dp))
                .background(Color.White, shape = RoundedCornerShape(16.dp)),
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = 170.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                Row {
                    Text(
                        text = "21,390 students",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "10 h 26m",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
                Text(
                    text = "Learn UI/UX Design, Figma  and Prototyping",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(modifier = Modifier.padding(bottom = 4.dp)) {
                    Text(text = "Brad  Frost ", color = Color.Gray, fontSize = 14.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(painter = painterResource(R.drawable.save), contentDescription = "")
                }
            }

        }

        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .shadow(2.dp, shape = RoundedCornerShape(16.dp))
                .background(cardBackgroundColor, shape = RoundedCornerShape(8.dp)),

            ) {
            Image(
                painter = painterResource(R.drawable.main_card_image),
                contentDescription = "",
                modifier = Modifier.padding(8.dp)
            )
        }


    }

}


@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    HomeScreen()
}

val primaryColor = Color(0xFFB89653)
val backgroundColor = Color(0xFFFFF7D4)
val cardBackgroundColor = Color(0xFFFFD95A)
val cardLightBackgroundColor = Color(0xFFFFE27F)
//val accentColor = Color(0xFFFFD95A)
