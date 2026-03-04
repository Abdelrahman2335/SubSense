package com.example.subsense.setting.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.subsense.core.composes.CustomButton
import com.example.subsense.core.data.model.ExpenseCategory
import com.example.subsense.core.ui.LightColors.mutedForeground

@Composable
fun SettingScreenBody(innerPadding: PaddingValues) {
    val categories = ExpenseCategory.getAllCategories()

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 18.dp, vertical = 12.dp)
    ) {
        item {

            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(

                    Icons.Outlined.AttachMoney,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    "Monthly Budgets",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

        }

        items(categories) { category ->

            BudgetCard(category)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 9.dp)
                    .height(2.dp)
                    .background(mutedForeground.copy(alpha = 0.3f))
            )
        }
        item {
            CustomButton(
                Modifier.padding(vertical = 16.dp),
                onClick = {

                },
            )
        }
        item {

            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(

                    Icons.Outlined.Notifications,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    "Notifications",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            CustomAlert(
                "Budget Alerts",
                "Get notified when approaching limits",
                true,
                {},
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 9.dp)
                    .height(2.dp)
                    .background(mutedForeground.copy(alpha = 0.3f))
            )
            CustomAlert(
                "Daily Reminders",
                "Remind to log expenses",
                false,
                {},
            )

        }

    }
}
