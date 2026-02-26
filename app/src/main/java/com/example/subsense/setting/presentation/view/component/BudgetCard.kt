package com.example.subsense.setting.presentation.view.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.subsense.core.model.ExpenseCategory


@Composable
fun BudgetCard(

    index: Int,
    categories: List<ExpenseCategory>
) {

    var textValue by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(41.dp)
                .clip(CircleShape)
                .background(categories[index].color.copy(0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = categories[index].icon,
                contentDescription = categories[index].displayName,
                tint = categories[index].color,
            )
        }
        Text(categories[index].displayName, modifier = Modifier.weight(1f))
        OutlinedTextField(

            value = textValue,
            onValueChange = { textValue = it },
            shape = RoundedCornerShape(21.dp),
            singleLine = true,
            modifier = Modifier
                .width(100.dp)
                .height(60.dp),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onSurface

            ),
            leadingIcon = {
                Icon(

                    Icons.Outlined.AttachMoney,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),

            )
    }
}