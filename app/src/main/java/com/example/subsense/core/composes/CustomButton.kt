package com.example.subsense.core.composes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.mutedForeground


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ElevatedButton(
        shape = RoundedCornerShape(14.dp),

        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(bottom = 19.dp, start = 14.dp, end = 14.dp),
        onClick = onClick,

        colors = ButtonColors(

            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = mutedForeground,
            disabledContentColor = mutedForeground
        )
    ) {
        Text("Save")
    }
}
