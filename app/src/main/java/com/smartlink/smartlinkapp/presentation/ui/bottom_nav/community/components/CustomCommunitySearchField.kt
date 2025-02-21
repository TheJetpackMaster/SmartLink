package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.community.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomCommunitySearchField(textValue: MutableState<String>) {
    BasicTextField(
        value = textValue.value,
        onValueChange = { textValue.value = it },
        textStyle = TextStyle(fontSize = 14.sp, color = Color.Black),
        modifier = Modifier
            .width(200.dp)
            .height(35.dp)
            .background(Color.Gray.copy(0.5f), shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 20.dp),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.fillMaxSize(),
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
        }
    )
}
