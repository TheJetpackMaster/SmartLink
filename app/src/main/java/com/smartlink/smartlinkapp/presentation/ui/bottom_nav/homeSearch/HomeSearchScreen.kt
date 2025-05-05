package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.homeSearch

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.MainSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components.TopSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components.TopSectionCard
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.homeSearch.commponents.CustomHomeSearchScreenTopBar
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.RequestActionButton
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.SwapRequestCard
import com.smartlink.smartlinkapp.ui.theme.Vibrant_Green

@Composable
fun HomeSearchScreen() {
    val textValue = remember { mutableStateOf("") }
    Scaffold(
        topBar = { CustomHomeSearchScreenTopBar(textValue) },
        containerColor = Color.Transparent,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())

        ) {
            HomeSearchContent(textValue)
        }

    }
}


@Composable
fun HomeSearchContent(textValue: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (textValue.value.isNotEmpty()) {
            HomeSearchResultSection()

        } else {
            HomeSearchTopSection()
            HomeSearchMainSection()

        }


    }
}

@Composable
fun HomeSearchTopSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Explore !",
            color = Color.Black,
            fontSize = 27.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(cardBackgroundColor),

            ) {
            Image(
                painter = painterResource(R.drawable.main_card_image),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Top 10 Best course for 2023",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Finding a good job can be a real hassle. Especially with the competition around, it gets comparatively difficult to choose the right job for you... ",
                    color = Color.Black,
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.person_2),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Read More",
                        color = Color.Black,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }

        }
    }
}

@Composable
fun HomeSearchMainSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(cardBackgroundColor),

            ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.search_screen_card_image1),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(110.dp)
                        .clip(RoundedCornerShape(26.dp))

                )

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = "Internships Platform",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "Undergraduate/postgraduate students or research scholars enrolled in recognized universities/institutions in India and abroad can apply for the NITI Aayog Internship Scheme. They will work closely with NITI's verticals/divisions/cells....",
                        color = Color.Black,
                        fontSize = 8.sp,
                        lineHeight = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun HomeSearchResultSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        repeat(6) {
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
                        buttonText = "SWAP"
                    )
                }

            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CustomPreviewScreen() {
    HomeSearchScreen()
}