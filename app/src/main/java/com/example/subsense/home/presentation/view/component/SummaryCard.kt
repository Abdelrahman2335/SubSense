package com.example.subsense.home.presentation.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.accent
import com.example.subsense.core.ui.LightColors.mutedForeground
import java.text.NumberFormat
import java.util.Locale

@Composable
fun SummaryCard(modifier: Modifier){
    val amount = 1234.50
    val amount2 = 1500

    val formattedAmount = NumberFormat.getCurrencyInstance(Locale.US).format(amount) // Put it in the VM
    val formattedAmount2 = NumberFormat.getCurrencyInstance(Locale.US).format(amount2) // Put it in the VM

    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .shadow(elevation = 9.dp, shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clip(RoundedCornerShape(16.dp))

    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 19.dp, end = 16.dp)

        ) {

            Text("Total Spent This Month", style = MaterialTheme.typography.titleMedium, color = mutedForeground)
            Spacer(Modifier.padding(bottom = 4.dp))
            Text(formattedAmount, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
            Spacer(Modifier.padding(bottom = 13.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween


            ){
                Text("Budget Usage", style = MaterialTheme.typography.bodyLarge, color = mutedForeground)
                Text("82%", style = MaterialTheme.typography.bodyLarge, color = accent)

            }
            Spacer(Modifier.padding(bottom = 6.dp))

            LinearProgressIndicator(
                color = accent,
                progress = { 0.65f }, // 65% progress
                modifier = Modifier
                    .fillMaxWidth()
                    .height(9.dp)
            )
            Spacer(Modifier.padding(bottom = 8.dp))
            Text("$formattedAmount of $formattedAmount2 budget" , style = MaterialTheme.typography.labelLarge, color = mutedForeground)


        }

    }
}