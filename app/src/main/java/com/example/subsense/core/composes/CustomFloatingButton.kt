package com.example.subsense.core.composes

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomFloatingButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String

) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.tertiary,
        shape = CircleShape,
        onClick = onClick
    ) {

        Icon(

            imageVector = icon,
            contentDescription = contentDescription,
        )


    }
}