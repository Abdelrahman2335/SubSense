package com.example.subsense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.subsense.core.ui.SubSenseTheme
import com.example.subsense.expense.presentation.view.screen.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SubSenseTheme {
                MainScreen()
            }
        }
    }
}

