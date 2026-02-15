package com.example.subsense.manage_expences.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.subsense.core.ui.LightColors.muted
import com.example.subsense.core.ui.LightColors.mutedForeground

@Composable
fun CounterTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    errorMessage: String?,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .width(48.dp) // Small fixed width
            .height(36.dp)
            .border(
                1.dp,
                color = if (errorMessage != null) Color.Red else mutedForeground,
                RoundedCornerShape(8.dp)
            )
            .background(muted, RoundedCornerShape(8.dp))
            .padding(8.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
//                if (value.isEmpty()) {
//                    Text(
//                        "0",
//                        fontSize = 14.sp,
//                        color = Color.Gray,
//                        textAlign = TextAlign.Center
//                    )
//                }
                innerTextField()
            }
        }
    )
}