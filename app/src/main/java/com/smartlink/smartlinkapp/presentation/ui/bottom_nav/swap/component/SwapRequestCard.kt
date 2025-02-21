package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Flame_Orange
import com.smartlink.smartlinkapp.ui.theme.Pure_Black
import com.smartlink.smartlinkapp.ui.theme.Sunflower_Gold
import com.smartlink.smartlinkapp.ui.theme.Vibrant_Green


@Composable
fun SwapRequestCard(
    cardColor: Color = Sunflower_Gold,
    elevation: Dp = 5.dp,
    cornerRadius: Dp = 24.dp,
    padding: Dp = 12.dp,
    profileImageSize: Dp = 100.dp,
    profileCornerRadius: Dp = 12.dp,
    userImage: Int = R.drawable.avatar_image,
    userName: String = "BehindTheApp",
    profession: String = "Musician",
    experienceText: String = "8 years +",
    rating: Float = 3.5f,
    favorites: String = "3k+",
    swaps: String = "65+",
    chats: String = "146",
    actionContent: @Composable () -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = cardColor),
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .shadow(elevation = elevation, shape = RoundedCornerShape(cornerRadius))
            .clip(RoundedCornerShape(cornerRadius))
            .background(cardColor)
            .padding(padding)
    ) {
        Row(
            modifier = Modifier.wrapContentHeight().fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            ProfileImage(userImage = userImage, size = profileImageSize, cornerRadius = profileCornerRadius)
            Spacer(Modifier.width(12.dp))

            SwapRequestUserInfo(
                userName = userName,
                profession = profession,
                experienceText = experienceText,
                rating = rating,
                favorites = favorites,
                swaps = swaps,
                chats = chats,
                actionContent = actionContent
            )
        }
    }
}

// User Profile Image
@Composable
fun ProfileImage(userImage:Int ,size: Dp = 100.dp, cornerRadius: Dp = 12.dp) {
    Image(
        painter = painterResource(userImage),
        contentDescription = "User Avatar",
        modifier = Modifier.size(size).clip(RoundedCornerShape(cornerRadius)),
        contentScale = ContentScale.Crop
    )
}

// User Information Section
@Composable
fun SwapRequestUserInfo(
    userName: String,
    profession: String,
    experienceText: String,
    rating: Float,
    favorites: String,
    swaps: String,
    chats: String,
    actionContent: @Composable () -> Unit
) {
    Column(modifier = Modifier.padding(bottom = 4.dp)) {
        UserNameAndBookmark(userName)
        UserProfessionAndRating(profession, rating)
        ExperienceText(experienceText)
        UserStats(favorites, swaps, chats)

        Spacer(Modifier.height(12.dp))

        actionContent()
    }
}

// User Name & Bookmark Section
@Composable
fun UserNameAndBookmark(userName: String) {
    Row(
        modifier = Modifier.padding(end = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = userName, color = Pure_Black, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.bookmarkicon),
            contentDescription = "Bookmark Icon",
            tint = Pure_Black,
            modifier = Modifier.size(22.dp)
        )
    }
}

// Profession & Star Rating
@Composable
fun UserProfessionAndRating(profession: String, rating: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = profession, color = Pure_Black, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(6.dp))
        Box(
            modifier = Modifier.width(12.dp).height(2.dp).background(Pure_Black)
        )
        Spacer(modifier = Modifier.width(6.dp))
        StarRating(rating = rating)
    }
}

// Star Rating
@Composable
fun StarRating(rating: Float) {
    Row {
        repeat(5) { index ->
            Icon(
                painter = painterResource(R.drawable.starrating),
                contentDescription = "Star Rating",
                tint = if (index < rating.toInt()) Flame_Orange else Color.Gray,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}

// Experience Text
@Composable
fun ExperienceText(experience: String) {
    val experienceText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Pure_Black)
        ) { append("Experience") }

        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, color = Pure_Black)
        ) { append(" = ") }

        withStyle(
            style = SpanStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Vibrant_Green)
        ) { append(experience) }
    }

    Text(text = experienceText, color = Pure_Black)
}

// User Stats (Likes, Swaps, Chats)
@Composable
fun UserStats(
    favorites: String,
    swaps: String,
    chats: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatsItem(R.drawable.favoriteicon, favorites)
        StatsItem(R.drawable.swapicon, swaps)
        StatsItem(R.drawable.chaticon, chats)
    }
}

@Composable
fun StatsItem(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "Stat Icon",
            tint = Pure_Black,
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Pure_Black
        )
    }
}

// Request Action Button
@Composable
fun RequestActionButton(
    onClick: () -> Unit = {},
    buttonText: String = "UNSWAP",
    buttonColor: Color = Vibrant_Green,
    textColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(32.dp),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(buttonText, color = textColor)
    }
}

// Warning Text
@Composable
fun WarningText() {
    Column(
        modifier = Modifier.padding(horizontal = 26.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val warningText = buildAnnotatedString {
            append("The Response of the person will be notified to you your provided")
            withStyle(
                style = SpanStyle(
                    color = Flame_Orange
                )
            ) {
                append(" gmail ")
            }
            append("account for more information Contact on")

            withStyle(
                style = SpanStyle(
                    color = Flame_Orange
                )
            ) {
                append(" help and support")
            }
            append(".")
        }

        Icon(
            painter = painterResource(R.drawable.warningicon), contentDescription = "",
            tint = Pure_Black
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = warningText,
            color = Pure_Black,
            textAlign = TextAlign.Center,
            lineHeight = 12.sp,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )

    }
}
