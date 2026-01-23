package com.example.subsense.home.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.subsense.home.data.dummy_data.DummyData
import java.text.NumberFormat
import java.util.Locale


@Composable
fun HomeScreenBody(modifier: Modifier) {
    val expenses = DummyData

    LazyColumn(

        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        item {
            SummaryCard()

        }
        item {
            AlertCard(
                imageVector = Icons.Outlined.WarningAmber,
                contentDescription = "Warning",
                color = warningForeground,
                text = "Food budget: 85% used"
            )
        }
        item {
            AlertCard(
                imageVector = Icons.Outlined.ErrorOutline,
                contentDescription = "Error",
                color = destructive,
                text = "Entertainment: Over budget by $23"
            )
        }
        item {
            Text(
                "Recent Expenses", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 3.dp)
            )
        }

        items(expenses, key = { it.id }) { expense ->
            ExpenseCard(expense)
        }
    }




}
