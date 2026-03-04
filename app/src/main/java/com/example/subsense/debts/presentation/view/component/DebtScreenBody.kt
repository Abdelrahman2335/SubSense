package com.example.subsense.debts.presentation.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.subsense.core.composes.SwipeToDeleteContainer
import com.example.subsense.core.ui.LightColors.accent
import com.example.subsense.core.ui.LightColors.destructive
import com.example.subsense.debts.presentation.manager.event.DebtEvent
import com.example.subsense.debts.presentation.manager.view_model.DebtViewModel

@Composable
fun DebtScreenBody(
    viewModel: DebtViewModel = hiltViewModel<DebtViewModel>(),
    innerPadding: PaddingValues
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val event = viewModel::onEvent
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = innerPadding,

        ) {
        item {
            SummaryCard(
                "Money You Lent",
                Icons.AutoMirrored.Filled.TrendingUp,
                accent,
                state.totalLent,
                state.totalLentPending
            )
            SummaryCard(
                "Money You Borrowed",
                Icons.AutoMirrored.Filled.TrendingDown,
                destructive,
                state.totalBorrow,
                state.totalBorrowPending
            )
        }
        item {
            Text(
                "Money Lent", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = accent,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 3.dp)
            )
        }
        items(state.moneyLent) { debt ->

            SwipeToDeleteContainer(debt, { event(DebtEvent.DeleteDebt(debt)) }) {

                DebtItem(it)
            }
        }
        item {
            Text(
                "Money Borrowed", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = destructive,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 3.dp)
            )
            // List of debits
        }
        items(state.moneyBorrow) { debt ->

            SwipeToDeleteContainer(debt, { event(DebtEvent.DeleteDebt(debt)) }) {

                DebtItem(it)
            }

        }
    }
}
