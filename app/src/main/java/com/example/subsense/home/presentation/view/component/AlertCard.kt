package com.example.subsense.home.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.warning

@Composable
fun AlertCard(
    imageVector: ImageVector,
    contentDescription: String,
    color: Color,
    text: String,
){
    Box(
        modifier = Modifier
            .padding(top = 19.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.2f)
            .clip(RoundedCornerShape(16.dp))
            .background(color.copy(alpha = 0.2f)),
        contentAlignment = Alignment.CenterStart,

        ) {

        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(),

            Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                tint = color,
                modifier = Modifier.size(21.dp)
            )

            Text( text, style = MaterialTheme.typography.labelLarge, color = color)
        }

    }
}