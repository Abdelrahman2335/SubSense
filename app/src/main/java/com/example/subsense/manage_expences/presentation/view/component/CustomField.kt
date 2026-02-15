package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(muted)
            .padding(vertical = 24.dp, horizontal = 21.dp) // Control internal spacing
    ) {
        Text(
            text = head,
            color = mutedForeground,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (errorMessage != null) Color.Red else mutedForeground,
                    shape = RoundedCornerShape(14.dp)
                ),
            shape = RoundedCornerShape(14.dp),
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(placeholder, color = mutedForeground) },
            isError = errorMessage != null,
            leadingIcon = {
                Icon(
                    imageVector = if (head == "Amount") Icons.Outlined.AttachMoney else Icons.Outlined.Edit,
                    contentDescription = null,
                    tint = mutedForeground
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent // Hide default error indicator
            ),
            singleLine = true
        )
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}