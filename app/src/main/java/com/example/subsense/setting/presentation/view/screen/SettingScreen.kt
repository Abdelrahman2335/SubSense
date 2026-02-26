package com.example.subsense.setting.presentation.view.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.subsense.core.composes.CustomTopBar
import com.example.subsense.core.ui.Constraints.TITLE_SETTINGS
import com.example.subsense.setting.presentation.view.component.SettingScreenBody

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen() {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = TITLE_SETTINGS,
                onClick = {}
            )

        }
    ) {
        SettingScreenBody(it)
    }
}

@Preview
@Composable
fun SettingScreenPreview(){
    SettingScreen()
}