package com.smartlink.smartlinkapp.presentation.ui.scheduleClass

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberTimePickerState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.smartlink.smartlinkapp.R
import com.smartlink.smartlinkapp.ui.theme.Creamy_Vanilla
import com.smartlink.smartlinkapp.ui.theme.Muted_Gold
import com.smartlink.smartlinkapp.ui.theme.Pure_Black
import com.smartlink.smartlinkapp.ui.theme.Radiant_Gold
import com.smartlink.smartlinkapp.ui.theme.Reddish_Brown
import com.smartlink.smartlinkapp.ui.theme.Soft_Gray
import com.smartlink.smartlinkapp.ui.theme.Sunburst_Yellow
import com.smartlink.smartlinkapp.ui.theme.Sunflower_Gold
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
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

            //🔹Dummy State
            var selectedTimes by remember { mutableStateOf(setOf<String>()) }

            TimeScheduleDialog(
                onSelectionChanged = {
                    selectedTimes = it
                }
            )

            ScheduleClassNote()

            var showDatepciker by remember { mutableStateOf(false) }
            Button(
                onClick = {
                    showDatepciker = true
                }
            ) {}
            RangeDatePickerDialog(
                showDialog = showDatepciker,
                onDismiss = { showDatepciker = false },
                onDateSelected = { _, _ -> },
                selectedDays = selectedDays
            )

        }
    }
}


//🔹 Select lecture days
@Composable
fun DaysOfWeekDropDown(
    selectedDays: Set<String>,
    onSelectionChanged: (Set<String>) -> Unit,
) {
    val daysOfWeek =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var expanded by remember { mutableStateOf(false) }
    val anchor = remember { Ref<androidx.compose.ui.geometry.Rect?>() }

    Row(
        modifier = Modifier.padding(12.dp)
    ) {
        // 🔹 Main Box for dropdown
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .border(width = 1.5.dp, color = Pure_Black, shape = RoundedCornerShape(6.dp))
                .clickable { expanded = true }
                .padding(8.dp)
                .onGloballyPositioned { coordinates -> // Get position for dropdown
                    anchor.value = coordinates.boundsInWindow()
                }
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
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    tint = Pure_Black,
                    modifier = Modifier
                        .size(26.dp)
                        .rotate(rotateArrowIcon)
                )
            }
        }

        // 🔹 Days list DropDownMenu
        DropdownMenu(
            expanded = expanded,
            containerColor = Soft_Gray,
            shadowElevation = 7.dp,
            tonalElevation = 7.dp,
            offset = DpOffset(x = 0.dp, y = 10.dp),
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(.6f)
        ) {
            daysOfWeek.forEach { day ->
                val isSelected = selectedDays.contains(day)
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = Soft_Gray,
                                    uncheckedColor = Color.Black,
                                    checkedColor = Radiant_Gold
                                ),
                                checked = isSelected,
                                onCheckedChange = null
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                day,
                                color = Pure_Black
                            )
                        }
                    },
                    onClick = {
                        val newSelection =
                            if (isSelected) selectedDays - day else selectedDays + day
                        onSelectionChanged(newSelection)
                    }
                )
            }
        }

        Spacer(Modifier.weight(1f))

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

        Spacer(Modifier.weight(.5f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable


//🔹 Select lecture timing
fun TimeScheduleDialog(
    onSelectionChanged: (Set<String>) -> Unit,
) {
    // State variables
    var expanded by remember { mutableStateOf(false) }
    var showStartTimeSetDialog by remember { mutableStateOf(false) }
    var showEndTimeSetDialog by remember { mutableStateOf(false) }

    var startTime by remember { mutableStateOf("00:00") }
    var endTime by remember { mutableStateOf("00:00") }

    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 🔹 Dropdown Box to select timing
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .border(width = 1.5.dp, color = Pure_Black, shape = RoundedCornerShape(6.dp))
                .clickable { expanded = !expanded }
                .padding(8.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Timings",
                    style = TextStyle(
                        color = Pure_Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Spacer(modifier = Modifier.width(8.dp)) // Small spacing before icon

                // 🔹 Animated dropdown icon
                val rotateArrowIcon by animateFloatAsState(
                    targetValue = if (expanded) 180f else 0f,
                    animationSpec = tween(200, easing = FastOutSlowInEasing)
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Dropdown",
                    tint = Pure_Black,
                    modifier = Modifier
                        .size(26.dp)
                        .rotate(rotateArrowIcon)
                )
            }
        }

        // 🔹 Time Selection Dropdown Menu
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(.6f),
            containerColor = Soft_Gray,
            shadowElevation = 7.dp,
            tonalElevation = 7.dp,
            offset = DpOffset(0.dp, 10.dp),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // 🔹 Select Start Time
            DropdownMenuItem(
                enabled = false,
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "From",
                            color = Pure_Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(Modifier.weight(1f))

                        // 🔹 Start Time Picker
                        TimePickerButton(
                            time = startTime,
                            onClick = { showStartTimeSetDialog = true }
                        )
                    }
                },
                onClick = {}
            )

            // 🔹 Select End Time
            DropdownMenuItem(
                enabled = false,
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "To",
                            color = Pure_Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(Modifier.weight(1f))

                        // 🔹 End Time Picker
                        TimePickerButton(time = endTime) { showEndTimeSetDialog = true }
                    }
                },
                onClick = {}
            )
        }

        Spacer(Modifier.weight(1f)) // Centering support

        // 🔹 Selected Time Display Box
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Creamy_Vanilla)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$startTime - $endTime",
                maxLines = 1,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Spacer(Modifier.weight(1f)) // Centering support
    }

    // 🔹 Show Start Time Picker Dialog
    if (showStartTimeSetDialog) {
        AdvancedTimePicker(
            onConfirm = { state ->

                val (formattedTime, amPm) = formatTime(state.hour, state.minute)
                startTime = "$formattedTime $amPm"
                showStartTimeSetDialog = false
                onSelectionChanged(setOf("$startTime - $endTime"))
            },
            onDismiss = { showStartTimeSetDialog = false }
        )
    }

    // 🔹 Show End Time Picker Dialog
    if (showEndTimeSetDialog) {
        AdvancedTimePicker(
            onConfirm = { state ->

                val (formattedTime, amPm) = formatTime(state.hour, state.minute)
                endTime = "$formattedTime $amPm"

                showEndTimeSetDialog = false
                onSelectionChanged(
                    setOf("$startTime - $endTime")
                )
            },
            onDismiss = { showEndTimeSetDialog = false }
        )
    }
}


// 🔹 Add a note for schedule
@Composable
fun ScheduleClassNote() {

    // Dummy text for now
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .border(1.dp, color = Radiant_Gold)
    ) {
        TextField(
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Creamy_Vanilla,
                unfocusedContainerColor = Creamy_Vanilla,
                focusedIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.Transparent,
                cursorColor = Color.Black

            ),
            modifier = Modifier.fillMaxSize(),
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            placeholder = {
                Text(
                    "Add Note...",
                    fontWeight = FontWeight.Medium,
                    color = Color.Black.copy(.5f)
                )
            },
            textStyle = TextStyle(
                color = Pure_Black,
                fontSize = 14.sp
            )
        )
    }
}


// 🔹 Reusable UI Component for Selecting Time
@Composable
fun TimePickerButton(
    modifier: Modifier = Modifier,
    time: String, onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .border(1.dp, Pure_Black, RoundedCornerShape(4.dp))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = time, color = Color.White)

        Spacer(Modifier.width(8.dp)) // Small spacing before icon

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Time Picker",
            tint = Color.White,
            modifier = Modifier
                .size(26.dp)

        )
    }
}


// 🔹 Function to Format Time in 12-hour format with AM/PM
fun formatTime(hour: Int, minute: Int): Pair<String, String> {
    val amPm = if (hour < 12) "AM" else "PM"
    val hour12 = if (hour % 12 == 0) 12 else hour % 12
    val formattedTime = String.format("%d:%02d", hour12, minute)
    return formattedTime to amPm
}


// 🔹 Time Pickers
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedTimePicker(
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit,
) {

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )

    /** Determines whether the time picker is dial or input */
    var showDial by remember { mutableStateOf(true) }

    /** The icon used for the icon button that switches from dial to input */
    val toggleIcon = if (showDial) {
        R.drawable.edittimeicon
    } else {
        R.drawable.clocktimeicon
    }

    AdvancedTimePickerDialog(
        onDismiss = { onDismiss() },
        onConfirm = { onConfirm(timePickerState) },
        toggle = {
            IconButton(onClick = { showDial = !showDial }) {
                Icon(
                    painter = painterResource(toggleIcon),
                    contentDescription = "Time picker type toggle",
                )
            }
        },
    ) {
        if (showDial) {
            TimePicker(
                state = timePickerState,
            )
        } else {
            TimeInput(
                state = timePickerState,
            )
        }
    }
}

@Composable
fun AdvancedTimePickerDialog(
    title: String = "Select Time",
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    toggle: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier =
            Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = MaterialTheme.colorScheme.surface
                ),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    toggle()
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = onDismiss) { Text("Cancel") }
                    TextButton(onClick = onConfirm) { Text("OK") }
                }
            }
        }
    }
}


// RangDatePicker dialog
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RangeDatePickerDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onDateSelected: (LocalDate?, LocalDate?) -> Unit,
    selectedDays: Set<String>,
) {

    if (showDialog) {
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                RangeDatePicker(
                    onDismiss = onDismiss,
                    onDateSelected = onDateSelected,
                    selectedDays = selectedDays
                )
            }
        }
    }
}


// Custom RangeDatePicker
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RangeDatePicker(
    onDismiss: () -> Unit,
    onDateSelected: (LocalDate?, LocalDate?) -> Unit,
    selectedDays: Set<String> = setOf(""),
    initialStartDate: LocalDate? = null,
    initialEndDate: LocalDate? = null,
) {

    // Days
    val daysOfWeek =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val sortedDays = selectedDays.sortedBy { daysOfWeek.indexOf(it) }

    Log.d("selecteddayssort", sortedDays.toString())


    val today = remember { LocalDate.now() }

    // Initialize start and end date from parameters
    var startDate by remember { mutableStateOf(initialStartDate) }
    var endDate by remember { mutableStateOf(initialEndDate) }
    var currentMonth by remember { mutableStateOf(startDate ?: today) } // Open at selected month

    val context = LocalContext.current

    LaunchedEffect(initialStartDate, initialEndDate) {
        startDate = initialStartDate
        endDate = initialEndDate
        currentMonth = startDate ?: today
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Creamy_Vanilla)
            .padding(horizontal = 26.dp, vertical = 26.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Month Navigation Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedIconButton(
                modifier = Modifier.size(32.dp),
                border = BorderStroke(2.dp, Pure_Black),
                colors = IconButtonDefaults.iconButtonColors(

                ),
                onClick = { currentMonth = currentMonth.minusMonths(1) },
                enabled = currentMonth.monthValue > today.monthValue || currentMonth.year > today.year
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Previous Month",
                    tint = Pure_Black,
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = "${currentMonth.month.name} ${currentMonth.year}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Pure_Black
            )

            OutlinedIconButton(
                modifier = Modifier.size(32.dp),
                border = BorderStroke(2.dp, Pure_Black),
                colors = IconButtonDefaults.iconButtonColors(

                ),
                onClick = { currentMonth = currentMonth.plusMonths(1) },
            ) {
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "Next Month",
                    tint = Pure_Black,
                    modifier = Modifier.size(24.dp)
                )
            }

        }

        Spacer(Modifier.height(16.dp))

        // Weekdays Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {
                Text(
                    text = it,
                    fontWeight = FontWeight.Normal,
                    color = Pure_Black,
                    fontSize = 14.sp
                )
            }
        }

        // Calendar Grid
        val firstDayOfMonth = currentMonth.withDayOfMonth(1)
        val daysInMonth = currentMonth.lengthOfMonth()
        val startDayOfWeek = (firstDayOfMonth.dayOfWeek.value - 1) % 7


        Column {
            var dayCounter = 1
            for (week in 0..5) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (day in 0..6) {
                        if (week == 0 && day < startDayOfWeek || dayCounter > daysInMonth) {
                            Text(text = "", modifier = Modifier.size(40.dp))
                        } else {
                            val date = currentMonth.withDayOfMonth(dayCounter)
                            val isDisabled = date.isBefore(today)
                            val isSelected = date == startDate || date == endDate
                            val dayAbbreviation = date.dayOfWeek.name.take(3).lowercase()
                            val selectedDaysLower =
                                sortedDays.map { it.take(3).lowercase() }.toSet()
                            val isSelectedDay = selectedDaysLower.contains(dayAbbreviation)

                            Log.d("selectedDays", selectedDays.toString())
                            Log.d("selectedDays", isSelectedDay.toString())

                            val isInRange =
                                startDate != null && endDate != null && date.isAfter(startDate) && date.isBefore(
                                    endDate
                                )

                            val backgroundColor = when {
                                isSelectedDay && isInRange -> Sunburst_Yellow
                                isSelected -> Radiant_Gold
                                isInRange -> Color.LightGray.copy(.3f)
                                else -> Color.Transparent
                            }

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(backgroundColor)
                                    .clickable(enabled = !isDisabled) {
                                        when {
                                            startDate == date -> {
                                                // Clicking start date resets both start and end
                                                startDate = null
                                                endDate = null
                                            }
                                            endDate == date -> {
                                                // Clicking end date only resets end
                                                endDate = null
                                            }
                                            startDate == null -> {
                                                // No start date selected, set start
                                                startDate = date
                                            }
                                            date.isBefore(startDate) -> {
                                                // Clicked before start date → make this the new start and shift the old start to end
                                                endDate = startDate
                                                startDate = date
                                            }
                                            endDate == null || date.isAfter(endDate) -> {
                                                // Clicking a date **after the current end date** updates the end date
                                                endDate = date
                                            }
                                            date.isBetween(startDate, endDate) -> {
                                                // Clicking inside the range updates the end date
                                                endDate = date
                                            }
                                            else -> {
                                                // Clicking a new date far outside range resets the selection
                                                startDate = date
                                                endDate = null
                                            }
                                        }
                                    },
//                                    .clickable(enabled = !isDisabled) {
//                                        when {
//                                            startDate == date -> {
//                                                // Clicking start date resets both start and end
//                                                startDate = null
//                                                endDate = null
//                                            }
//                                            endDate == date -> {
//                                                // Clicking end date only resets end
//                                                endDate = null
//                                            }
//                                            startDate == null -> {
//                                                // No start date selected, set start
//                                                startDate = date
//                                            }
//                                            date.isBefore(startDate) -> {
//                                                // Clicked before start date → this becomes the new end date instead of resetting
//                                                endDate = startDate
//                                                startDate = date
//                                            }
//                                            endDate == null || date.isBetween(startDate, endDate) -> {
//                                                // Clicked in range or no end date yet, update end date
//                                                endDate = date
//                                            }
//                                            else -> {
//                                                // Clicking a new date after start resets the range
//                                                startDate = date
//                                                endDate = null
//                                            }
//                                        }
//                                    }

                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = dayCounter.toString(),
                                    color = if (isDisabled) Color.Gray else Color.Black
                                )
                            }
                            dayCounter++
                        }
                    }
                }
            }
        }

        // Display Selected Dates
        Text(
            text = "Start: ${startDate ?: "-"}  End: ${endDate ?: "-"}",
            fontSize = 16.sp,
            color = Pure_Black
        )

        // Action Buttons
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            TextButton(onClick = onDismiss) {
                Text("Cancel", color = Reddish_Brown)
            }
            TextButton(onClick = {
                if (startDate == null || endDate == null) {
                    showToast(context, "Select start and end date")
                } else {
                    onDateSelected(startDate, endDate)
                    onDismiss()
                }
            }) {
                Text("Ok", color = Radiant_Gold)
            }
        }
    }
}

private var toast: Toast? = null

fun showToast(context: Context, message: String) {
    toast?.cancel() // Cancel previous toast if exists
    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT).apply { show() }
}


@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.isBetween(start: LocalDate?, end: LocalDate?): Boolean {
    return start != null && end != null && this.isAfter(start) && this.isBefore(end)
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Prev() {
    ScheduleClassScreen()
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