package com.example.subsense.core.composes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.subsense.core.ui.LightColors.primary
import com.example.subsense.core.ui.LightColors.primaryForeground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(title: String, showBackArrow: Boolean = false, onClick: () -> Unit) {
    TopAppBar(
        title = { Text(title, style = MaterialTheme.typography.titleLarge) },


        navigationIcon = {
            if (showBackArrow) {
                IconButton(
                    onClick = onClick
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Back",
                        tint = primaryForeground,
                    )
                }
            }

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primary,
            titleContentColor = primaryForeground
        )
    )
}