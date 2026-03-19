package com.example.subsense.setting.presentation.view.component

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.setting.presentation.manager.event.SettingEvent
import com.example.subsense.setting.presentation.manager.view_model.SettingViewModel

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun SettingScreenBody(
    viewModel: SettingViewModel = hiltViewModel<SettingViewModel>(),
    innerPadding: PaddingValues
) {


    val state by viewModel.state.collectAsStateWithLifecycle()

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        state.notificationPermissionRequest.let {
            viewModel.onPermissionResult(Manifest.permission.POST_NOTIFICATIONS, isGranted)
        }
    }

    // Trigger permission request when ViewModel requests it
    LaunchedEffect(state.notificationPermissionRequest) {
        if (state.notificationPermissionRequest) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }


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

        items(state.budgetCategories) { category ->

            BudgetCard(
                category,
                state.budgetValues.first { it.categoryId == category.id },
                viewModel::onEvent
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 9.dp)
                    .height(2.dp)
                    .background(mutedForeground.copy(alpha = 0.3f))
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
                state.budgetNotification.isEnabled,
            ) {
                viewModel.onEvent(
                    SettingEvent.UpdateNotification(
                        state.budgetNotification.copy(
                            isEnabled = !state.budgetNotification.isEnabled
                        )
                    )
                )
            }
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
                state.dailyNotification.isEnabled,
            ) {

                viewModel.onEvent(
                    SettingEvent.UpdateNotification(
                        state.dailyNotification.copy(
                            isEnabled = !state.dailyNotification.isEnabled
                        )
                    )
                )
            }

        }

    }
}
