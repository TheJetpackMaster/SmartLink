package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CustomCommunityPageTopBar
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.HomeContent
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.MainSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.components.TopSection
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.backgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.cardBackgroundColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.home.primaryColor
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CommunityContentMainSection
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components.CommunityContentTopSection
import com.smartlink.smartlinkapp.ui.theme.Charcoal_Brown

@Composable
fun CommunityScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomCommunityPageTopBar(onClick = { navController.popBackStack() }) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        CommunityContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun CommunityContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        CommunityContentTopSection()
        //CommunityContentMainSection()
        CommunityContentResultSection()
    }
}

@Composable
fun CommunityContentResultSection() {
    repeat(6){
        CommunityContentJointCard()
    }

}

@Composable
fun CommunityContentJointCard(){
    Box(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(top = 32.dp)
                .padding(horizontal = 4.dp)
                .background(cardBackgroundColor.copy(0.6f), shape = RoundedCornerShape(14.dp))
        ) { }

        Column(modifier = Modifier) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                colors = CardDefaults.cardColors(cardBackgroundColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = "Graphic Era", fontSize = 24.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.person_2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.person_2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(CircleShape)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.person_2),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(CircleShape)
                        )
                    }
                }
                Text(
                    text = "Unleash your creativity and join our vibrant community of graphic designers, where ideas ignite and talents flourish",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(Charcoal_Brown),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Ask to Join ")
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun CustomPreview() {
    CommunityScreen(rememberNavController())
}







