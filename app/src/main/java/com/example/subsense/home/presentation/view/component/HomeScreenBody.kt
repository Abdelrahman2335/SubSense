package com.example.subsense.home.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.model.ExpenseCategory
import com.example.subsense.core.ui.ChartColors
import com.example.subsense.core.ui.LightColors.destructive
import com.example.subsense.core.ui.LightColors.warningForeground
import java.text.NumberFormat
import java.util.Locale


@Composable
fun HomeScreenBody(modifier: Modifier){

    Column(
        modifier
        .fillMaxSize()
        .padding(horizontal = 23.dp)) {
        SummaryCard(modifier)
        // Same box used twice, you should make it reusable
        AlertCard(
            imageVector = Icons.Outlined.WarningAmber,
            contentDescription = "Warning",
            color = warningForeground,
            text = "Food budget: 85% used"
        )
        AlertCard(
            imageVector = Icons.Outlined.ErrorOutline,
            contentDescription = "Error",
            color = destructive,
            text = "Entertainment: Over budget by $23"
        )

        Text(
            "Recent Expenses", style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 3.dp)
        )
        ExpenseCard(
            amount = 12,
            category = ExpenseCategory.FoodDining,
            note = "Lunch at Chipotle"
        )
    }
}
