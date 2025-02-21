package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.message

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Charcoal_Brown
import com.smartlink.smartlinkapp.ui.theme.Creamy_Vanilla
import com.smartlink.smartlinkapp.ui.theme.Golden_Sand
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.ui.theme.Sunflower_Gold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen() {

    Scaffold(
        containerColor = Creamy_Vanilla,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Muted_Gold
                ),
                title = {
                    Text(
                        text = "Message",
                        color = Creamy_Vanilla
                    )
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(R.drawable.searchicon),
                            contentDescription = "",
                            tint = Creamy_Vanilla
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Creamy_Vanilla
                        )
                    }
                }
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .shadow(elevation = 8.dp)
                    .background(Color.White)
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.menuicon), contentDescription = "",
                        tint = Muted_Gold,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(Modifier.weight(1f))

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.moreverticon), contentDescription = "",
                        tint = Muted_Gold,
                        modifier = Modifier.size(22.dp)
                            .rotate(90f)
                    )
                }
            }

//            LazyColumn {
//
//            }

            // DUMMY USER LIST

            ChatListItem()
            ChatListItem(
                userName = "Team of SS",
                userImage = R.drawable.avatar_image2,
                lastSeen = "12:01",
                lastText = "hey? what going on brother."
            )
            ChatListItem()
        }

    }
}

@Composable
fun ChatListItem(
    userImage: Int = R.drawable.avatar_image,
    userName: String = "Robbie Harrison",
    lastText: String = "Hey! how are you",
    lastSeen: String = "12:02",
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(userImage), contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(5.dp)
        ) {
            Text(
                text = userName,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = lastText,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 16.dp)
            )

        }

        Spacer(Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentWidth()
                .padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = lastSeen,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Sunflower_Gold)
            )
        }
    }
    HorizontalDivider(color = Color.White, thickness = 2.dp)
}