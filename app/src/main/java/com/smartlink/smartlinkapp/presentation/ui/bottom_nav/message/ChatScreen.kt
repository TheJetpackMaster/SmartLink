package com.smartlink.smartlinkapp.presentation.ui.bottom_nav.message

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.component.SentRequestFilter
import com.smartlink.smartlinkapp.ui.theme.Charcoal_Brown
import com.smartlink.smartlinkapp.ui.theme.Creamy_Vanilla
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.ui.theme.Pure_Black
import com.smartlink.smartlinkapp.ui.theme.Radiant_Gold
import com.smartlink.smartlinkapp.ui.theme.Smoke_White
import com.smartlink.smartlinkapp.ui.theme.Soft_Gray


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ChatScreen() {
    val imeInsets = WindowInsets.ime
    val isImeVisible = WindowInsets.isImeVisible

    val isKeyboardVisible by remember { derivedStateOf { isImeVisible } }
//
//    val keyboardVisibleState = rememberUpdatedState(newValue = isKeyboardVisible)
//
//    // 🔹 Force recomposition to avoid inconsistent ui behaviour
//    LaunchedEffect(keyboardVisibleState.value) {
//
//    }


    //🔹Main Container for whole screen
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
        }
    ) { innerPadding ->

        //🔹Main Inner Content container
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Creamy_Vanilla)
            ) {
                //🔹UserInfo Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp)
                        .shadow(elevation = 8.dp)
                        .background(Color.White)
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Image(
                        painter = painterResource(R.drawable.avatar_image), contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.weight(1f))


                    // Dummy state for More Dropdown
                    val showDrop = remember { mutableStateOf(false) }
                    val dummyButtonColorAnimation by animateColorAsState(
                        targetValue = if (showDrop.value) Muted_Gold else Color.Transparent,
                        animationSpec = tween(durationMillis = 300,easing = FastOutSlowInEasing)

                    )

                    //🔹More DropDown IconButton
                    Button(
                        modifier = Modifier.size(36.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = dummyButtonColorAnimation
                        ),
                        onClick = {
                            showDrop.value = true
                        },
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.moreverticon),
                            contentDescription = "",
                            tint = if(showDrop.value) Color.White else Muted_Gold,
                            modifier = Modifier
                                .size(22.dp)
                                .rotate(90f)
                        )

                        ChatScreenMoreDropDown(
                            showDropDown = showDrop
                        )
                    }
                }

                //🔹If no Message Dummy Text if text than lazy column for that
                LazyColumn {
                    items(100) {
                        Text("Good", color = Pure_Black)
                    }
                    item() {
                        Spacer(Modifier.height(120.dp))
                    }
                }


            }

            //🔹Main TextField Section
            TextFieldSection(
                onAddAction = {},
                onEmojiAction = {},
                onAttachmentAction = {},
                onVoiceAction = {},
                onSendAction = {},
                modifier = Modifier.align(Alignment.BottomStart)
            )

        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TextFieldSection(
    modifier: Modifier = Modifier,
    onAddAction: () -> Unit = {},
    onEmojiAction: () -> Unit = {},
    onAttachmentAction: () -> Unit = {},
    onVoiceAction: () -> Unit = {},
    onSendAction: () -> Unit = {},

    ) {
    val imeInsets = WindowInsets.ime
    val density = LocalDensity.current
    val imeHeight by remember {
        derivedStateOf {
            imeInsets.getBottom(density).toFloat()
        }
    }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = object : DefaultLifecycleObserver {
            override fun onPause(owner: LifecycleOwner) {
                focusManager.clearFocus(force = true) // Clears focus from the text field
                keyboardController?.hide()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    val animatedPadding by animateDpAsState(
        targetValue = if (imeHeight > 450) 0.dp else 16.dp,
        animationSpec = tween(durationMillis = 100, easing = LinearEasing),
        label = "AnimatedHeight"
    )

    val animatedBottomPadding by animateDpAsState(
        targetValue = if (imeHeight > 450) 0.dp else 18.dp,
        animationSpec = tween(durationMillis = 0, easing = LinearEasing),
        label = "AnimatedCorner"
    )

    val animatedCorner by animateDpAsState(
        targetValue = if (imeHeight > 450) 0.dp else 18.dp,
        animationSpec = tween(durationMillis = 140, easing = LinearEasing),
        label = "AnimatedCorner"
    )

    val animatedHeight by animateDpAsState(
        targetValue = if (imeHeight > 450) 88.dp else 106.dp,
        animationSpec = tween(durationMillis = 80, easing = LinearEasing),
        label = "AnimatedCorner"
    )

    val scale by animateFloatAsState(
        targetValue = if (imeHeight > 450) 0.85f else 1f,
        animationSpec = tween(durationMillis = 100, easing = FastOutSlowInEasing),
        label = "ScaleAnimation"
    )

    // 🔹 Main Layout
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 100.dp, max = 240.dp)
            .padding(horizontal = animatedPadding)
            .padding(bottom = animatedBottomPadding),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Smoke_White
        ),
        shape = RoundedCornerShape(
            bottomStart = animatedCorner, bottomEnd = animatedCorner,
            topEnd = 18.dp, topStart = 18.dp
        )

    ) {

        // 🔹 Dummy for now
        var text by remember { mutableStateOf("") }


        // 🔹 TextField selection colors
        val customTextSelectionColors = TextSelectionColors(
            handleColor = Radiant_Gold,  // Customize handle color
            backgroundColor = Radiant_Gold.copy(alpha = 0.4f) // Customize selection color
        )


        // 🔹 Main textField
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Pure_Black,
                    unfocusedTextColor = Pure_Black,
                    cursorColor = Pure_Black,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                placeholder = {
                    Text(
                        "type your message here...",
                        fontSize = 14.sp, color = Pure_Black.copy(.6f)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(50.dp, max = 120.dp)
                    .background(Color.Transparent),
                value = text,
                onValueChange = {
                    text = it
                },
                maxLines = 4,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }


        // 🔹 ActionButtons Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp)
                .padding(bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically


        ) {

            // 🔹 Add Action Button
            Button(
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 1.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Color.White
                ),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(4.dp),
                onClick = {
                    onAddAction
                },
                modifier = Modifier
                    .size(32.dp)
            ) {
                Icon(
                    painterResource(R.drawable.plusicon),
                    contentDescription = "",
                    tint = Soft_Gray,
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(Modifier.width(12.dp))

            // 🔹 Emoji Action Button
            Button(
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Soft_Gray.copy(.01f)
                ),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                onClick = {
                    onEmojiAction
                },
                modifier = Modifier
                    .size(22.dp)
            ) {
                Icon(
                    painterResource(R.drawable.emojiiocn),
                    contentDescription = "",
                    tint = Soft_Gray,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            onClick = onEmojiAction
                        )
                )
            }

            Spacer(Modifier.width(12.dp))

            // 🔹 Attachment Action Button
            Button(
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Soft_Gray.copy(.01f)
                ),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                onClick = {
                    onAttachmentAction
                },
                modifier = Modifier
                    .size(22.dp)
            ) {
                Icon(
                    painterResource(R.drawable.attachmenticon),
                    contentDescription = "",
                    tint = Soft_Gray,
                    modifier = Modifier.size(20.dp)

                )
            }

            Spacer(modifier = Modifier.weight(1f))


            // 🔹 Voice Action Button
            Button(
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 1.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    Radiant_Gold
                ),
                shape = CircleShape,
                contentPadding = PaddingValues(4.dp),
                onClick = {
                    onVoiceAction
                },
                modifier = Modifier
                    .size(32.dp)
            ) {
                Icon(
                    painterResource(R.drawable.micicon),
                    contentDescription = "",
                    tint = Pure_Black,
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(Modifier.width(12.dp))


            // 🔹 SendNow Action Button
            Button(
                onClick = {
                    onSendAction
                },
                modifier = Modifier.height(38.dp),
                colors = ButtonDefaults.buttonColors(
                    Radiant_Gold
                ),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 4.dp
                ),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                Text(
                    text = "Send Now",
                    color = Pure_Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
        }
    }
}


@Composable
fun ChatScreenMoreDropDown(
    showDropDown: MutableState<Boolean>,
) {
    DropdownMenu(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .wrapContentWidth(),
        expanded = showDropDown.value,
        onDismissRequest = {
            showDropDown.value = false
        },
        containerColor = Color.White,
        shadowElevation = 10.dp,

        ) {
        DropdownMenuItem(
            onClick = {

            },
            text = {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Icon(
                        painterResource(R.drawable.schoolicon),
                        contentDescription = "",
                        tint = Charcoal_Brown,
                        modifier = Modifier
                            .size(20.dp)

                    )

                    Text(
                        text = "SCHEDULE CLASS",
                        color = Pure_Black
                    )
                }
            }
        )


        DropdownMenuItem(
            onClick = {
            },
            text = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Icon(
                        painterResource(R.drawable.callicon),
                        contentDescription = "",
                        tint = Charcoal_Brown,
                        modifier = Modifier
                            .size(20.dp)

                    )

                    Text(
                        text = "CALL",
                        color = Pure_Black
                    )
                }
            }
        )

        DropdownMenuItem(
            onClick = {

            },
            text = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Icon(
                        painterResource(R.drawable.communityicon),
                        contentDescription = "",
                        tint = Charcoal_Brown,
                        modifier = Modifier
                            .size(20.dp)

                    )

                    Text(
                        text = "CREATE COMMUNITY",
                        color = Pure_Black
                    )
                }
            }
        )

        DropdownMenuItem(
            onClick = {

            },
            text = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    Icon(
                        painterResource(R.drawable.addicon),
                        contentDescription = "",
                        tint = Charcoal_Brown,
                        modifier = Modifier
                            .size(20.dp)

                    )

                    Text(
                        text = "ADD IN COMMUNITY",
                        color = Pure_Black
                    )
                }
            }
        )
    }
}

@Composable
@Preview
fun TextFieldSectionPreview() {
    TextFieldSection(

    )
}
