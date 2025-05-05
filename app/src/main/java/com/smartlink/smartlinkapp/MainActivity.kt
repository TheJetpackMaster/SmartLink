package com.smartlink.smartlinkapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.message.ChatScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.message.MessageScreen
import com.smartlink.smartlinkapp.presentation.ui.bottom_nav.swap.SwapScreen
import com.smartlink.smartlinkapp.presentation.ui.mainscreen.MainScreen
import com.smartlink.smartlinkapp.presentation.ui.scheduleClass.ScheduleClassScreen
import com.smartlink.smartlinkapp.ui.theme.SmartLinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmartLinkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen()


                }
            }
        }
    }
}
