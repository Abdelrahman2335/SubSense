package com.example.subsense.core.composes

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.ui.LightColors.secondaryForeground

@Composable
fun CustomField(
    head: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    value: String,
    errorMessage: String?,
    enableLeadingIcon: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 19.dp, end = 19.dp, top = 14.dp, bottom = 23.dp)

        ) {
            Text(
                text = head,
                color = secondaryForeground,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedTextField(
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
                leadingIcon = if (!enableLeadingIcon) null else {
                    {
                        val icon = if (head == "Amount")
                            Icons.Outlined.AttachMoney
                        else
                            Icons.Outlined.Edit

                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = mutedForeground
                        )
                    }
                },
                singleLine = true,
                keyboardOptions = keyboardOptions
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


}