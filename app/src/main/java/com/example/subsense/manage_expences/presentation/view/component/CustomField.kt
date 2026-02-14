package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground


@Composable
fun CustomField(
    head: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    value: String,
    errorMessage: String?,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .drawWithContent {
                drawContent()
                // Bottom shadow (drawn outside below the content)
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(0f, size.height),
                    size = Size(width = size.width, height = 8.dp.toPx())
                )
                // Right shadow (drawn outside to the right)
                drawRect(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.15f),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(size.width, 0f),
                    size = Size(width = 8.dp.toPx(), height = size.height)
                )
            }
            .padding(end = 8.dp, bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 180.dp)
                .clip(RoundedCornerShape(26.dp))
                .background(muted),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = head,
                    color = mutedForeground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 22.dp, bottom = 4.dp)
                )
                TextField(
                    value = value,
                    onValueChange = { onValueChange(value) },
                    placeholder = { Text(placeholder, color = mutedForeground) },
                    isError = errorMessage != null,
                    supportingText = {

                        if (errorMessage != null) {
                            Text(errorMessage)
                        }
                    },
                    leadingIcon = {
                        if (head == "Amount") {
                            Icon(
                                imageVector = Icons.Outlined.AttachMoney,
                                contentDescription = "Money",
                                tint = mutedForeground,
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Outlined.Edit,
                                contentDescription = "Note",
                                tint = mutedForeground,
                            )
                        }

                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Red
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .padding(horizontal = 21.dp)
                        .border(
                            width = 1.dp,
                            color = mutedForeground,
                            shape = RoundedCornerShape(14.dp)
                        )
                )
            }
        }
    }
}