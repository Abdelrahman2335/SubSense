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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.subsense.core.data.model.Budget
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.setting.presentation.manager.event.SettingEvent


@Composable
fun BudgetCard(

    category: ExpenseCategory,
    budgetValue: Budget,
    event: (SettingEvent) -> Unit
) {


    val focusManager = LocalFocusManager.current

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(41.dp)
                .clip(CircleShape)
                .background(category.color.copy(0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = category.icon,
                contentDescription = category.displayName,
                tint = category.color,
            )
        }
        Text(category.displayName, modifier = Modifier.weight(1f))
        OutlinedTextField(

            value = budgetValue.limitAmount.toString(),
            onValueChange = {
                val amount = it.toIntOrNull()
                if (amount != null) {
                    event(
                        SettingEvent.UpsertBudget(
                            Budget(
                                categoryId = category.id,
                                limitAmount = amount
                            )
                        )
                    )
                }

            },
            shape = RoundedCornerShape(21.dp),
            singleLine = true,
            modifier = Modifier
                .width(120.dp)
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