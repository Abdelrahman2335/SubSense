package com.example.subsense.home.presentation.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material.icons.outlined.WarningAmber
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.subsense.core.ui.LightColors.accent
import com.example.subsense.core.ui.LightColors.card
import com.example.subsense.core.ui.LightColors.destructive
import com.example.subsense.core.ui.LightColors.mutedForeground
import com.example.subsense.core.ui.LightColors.primary
import com.example.subsense.core.ui.LightColors.primaryForeground
import com.example.subsense.core.ui.LightColors.warning
import com.example.subsense.core.ui.LightColors.warningForeground
import com.example.subsense.home.presentation.view.component.HomeTopBar
import java.text.NumberFormat
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(){

        Scaffold(
            topBar = { HomeTopBar() },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            HomeScreenBody(
                modifier = Modifier.padding(innerPadding
                )
            )
        }
}

@Composable
fun HomeScreenBody(modifier: Modifier){
    val amount = 1234.50
    val amount2 = 1500

    val formattedAmount = NumberFormat.getCurrencyInstance(Locale.US).format(amount) // Put it in the VM
    val formattedAmount2 = NumberFormat.getCurrencyInstance(Locale.US).format(amount2) // Put it in the VM

    Column(modifier
        .fillMaxSize()
        .padding(horizontal = 23.dp)) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp))
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
            // Same box used twice, you should make it reusable
        Box(
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .clip(RoundedCornerShape(16.dp))
                .background(warning.copy(alpha = 0.3f)),
            contentAlignment = Alignment.CenterStart,

        ) {

            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),

                Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.WarningAmber,
                    contentDescription = "Warning",
                    tint = warningForeground,
                    modifier = Modifier.size(21.dp)
                    )

                Text("Food budget: 85% used" , style = MaterialTheme.typography.labelLarge, color = warningForeground)
            }

        }

        Box(
            modifier = Modifier
                .padding(top = 19.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .clip(RoundedCornerShape(16.dp))
                .background(destructive.copy(alpha = 0.3f)),
            contentAlignment = Alignment.CenterStart,

            ) {

            Row(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),

                Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.ErrorOutline,
                    contentDescription = "Error",
                    tint = warningForeground,
                    modifier = Modifier.size(21.dp)
                )

                Text("Entertainment: Over budget by $23" , style = MaterialTheme.typography.labelLarge, color = warningForeground)
            }

        }


    }
}