package com.smartlink.smartlinkapp.presentation.ui.scheduleClass

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.node.Ref
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Creamy_Vanilla
import com.smartlink.smartlinkapp.ui.theme.Golden_Sand
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.ui.theme.Pure_Black
import com.smartlink.smartlinkapp.ui.theme.Radiant_Gold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleClassScreen() {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {

                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            modifier = Modifier.size(28.dp),
                            painter = painterResource(R.drawable.searchicon),
                            contentDescription = "",
                            tint = Pure_Black
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
                            painter = painterResource(R.drawable.menuicon),
                            contentDescription = "",
                            tint = Pure_Black
                        )
                    }
                },
                modifier = Modifier
                    .shadow(elevation = 20.dp, spotColor = Pure_Black, ambientColor = Pure_Black)
                    .background(Color.White)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)

            ) {
                Icon(
                    painter = painterResource(R.drawable.stopwatchicon), contentDescription = "",
                    tint = Radiant_Gold,
                )

                Text(
                    text = "Schedule Class",
                    color = Pure_Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                )
            }

            //🔹Dummy State
            var selectedDays by remember { mutableStateOf(setOf<String>()) }

            DaysOfWeekDropDown(
                selectedDays = selectedDays,
                onSelectionChanged = {
                    selectedDays = it
                }
            )
        }
    }
}

@Composable
fun DaysOfWeekDropDown(
    selectedDays: Set<String>,
    onSelectionChanged: (Set<String>) -> Unit,
) {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var expanded by remember { mutableStateOf(false) }
    val anchor = remember { Ref<androidx.compose.ui.geometry.Rect?>() }

    Row(
        modifier = Modifier.padding(12.dp)
    ) {
        // 🔹 Main Box for dropdown
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .border(width = 2.dp, color = Pure_Black, shape = RoundedCornerShape(6.dp))
                .padding(8.dp)
                .onGloballyPositioned { coordinates -> // Get position for dropdown
                    anchor.value = coordinates.boundsInWindow()
                }
                .clickable { expanded = true },
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Days",
                    style = TextStyle(
                        color = Pure_Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

//                Spacer(modifier = Modifier.weight(1f))


                // Dummy animation
                val rotateArrowIcon by animateFloatAsState(
                        targetValue = if (expanded) 180f else 0f,
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = FastOutSlowInEasing
                        )
                    )

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = Pure_Black,
                    modifier = Modifier.size(26.dp)
                        .rotate(rotateArrowIcon)
                )
            }
        }

        // 🔹 Days list DropDownMenu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.wrapContentWidth()
        ) {
            daysOfWeek.forEach { day ->
                val isSelected = selectedDays.contains(day)
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = isSelected,
                                onCheckedChange = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(day)
                        }
                    },
                    onClick = {
                        val newSelection = if (isSelected) selectedDays - day else selectedDays + day
                        onSelectionChanged(newSelection)
                    }
                )
            }
        }

        Spacer(Modifier.width(40.dp))

        // 🔹 To show selected days
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Creamy_Vanilla)
                .padding(horizontal = 12.dp)
                .padding(vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (selectedDays.isEmpty()) "None"
                else selectedDays.sortedBy { daysOfWeek.indexOf(it) }
                    .joinToString(",") { it.take(3) },
                maxLines = 1,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}




//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DaysOfWeekDropDown(
//    selectedDays: Set<String>,
//    onSelectionChanged: (Set<String>) -> Unit,
//) {
//    val daysOfWeek =
//        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//    var expanded by remember { mutableStateOf(false) }
//
//    Log.d("expanded", expanded.toString())
//
//    Row(
//        modifier = Modifier.padding(12.dp)
//    ) {
//
//        //🔹Main Box for dropdown
//        ExposedDropdownMenuBox(
//            modifier = Modifier.fillMaxWidth(.5f),
//            expanded = expanded,
//            onExpandedChange = { expanded = !expanded }
//        ) {
//            Row(
//                modifier = Modifier
//                    .border(width = 2.dp, color = Pure_Black, shape = RoundedCornerShape(6.dp))
//                    .padding(8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                //🔹Necessary TextField for ExposedDrpDown
//                BasicTextField(
//                    value = "Days",
//                    onValueChange = {},
//                    readOnly = true,
//                    modifier = Modifier
//                        .width(IntrinsicSize.Min) // Width matches text size
//                        .menuAnchor(type = MenuAnchorType.PrimaryNotEditable),
//                ) {
//
//                    val rotateArrowIcon by animateFloatAsState(
//                        targetValue = if (expanded) 180f else 0f,
//                        animationSpec = tween(
//                            durationMillis = 200,
//                            easing = FastOutSlowInEasing
//                        )
//                    )
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = "Days",
//                            style = TextStyle(
//                                color = Pure_Black,
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Medium
//                            )
//                        )
//                        Icon(
//                            imageVector = Icons.Default.KeyboardArrowDown,
//                            contentDescription = "",
//                            tint = Pure_Black,
//                            modifier = Modifier
//                                .size(26.dp)
//                                .rotate(rotateArrowIcon)
//
//                        )
//                    }
//
//                }
//            }
//
//
//            //🔹Days list DropDownMenu
//            ExposedDropdownMenu(
//                modifier = Modifier.wrapContentWidth(),
//                expanded = expanded,
//                onDismissRequest = {
//                    expanded = !expanded
//                }
//            ) {
//                daysOfWeek.forEach { day ->
//                    val isSelected = selectedDays.contains(day)
//                    DropdownMenuItem(
//                        text = {
//                            Row(verticalAlignment = Alignment.CenterVertically) {
//                                Checkbox(
//                                    checked = isSelected,
//                                    onCheckedChange = null
//                                )
//                                Spacer(modifier = Modifier.width(8.dp))
//                                Text(day)
//                            }
//                        },
//                        onClick = {
//                            val newSelection = if (isSelected) {
//                                selectedDays - day
//                            } else {
//                                selectedDays + day
//                            }
//                            onSelectionChanged(newSelection)
//                        }
//                    )
//
//                }
//            }
//        }
//
//        //🔹To show selectedDays
//        Box(
//            modifier = Modifier
//                .width(140.dp)
//                .height(40.dp)
//                .clip(RoundedCornerShape(12.dp))
//                .background(Golden_Sand)
//                .padding(horizontal = 12.dp)
//                .padding(vertical = 2.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text =
//                if (selectedDays.isEmpty()) "None"
//                else selectedDays.sortedBy { daysOfWeek.indexOf(it) }
//                    .joinToString(",") { it.take(3) },
//                maxLines = 1,
//                fontSize = 14.sp,
//                color = Color.Gray
//            )
//        }
//    }
//}