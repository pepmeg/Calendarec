package org.example.project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.example.project.SharedViewModel
import org.example.project.components.SetScheduleButton
import org.example.project.components.homepage.Calendar
import org.example.project.components.homepage.Home
import org.example.project.components.homepage.RemindersScreen
import org.example.project.components.homepage.ScheduleToday
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeScreen(navController: NavController, viewModel: SharedViewModel) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 48.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Home(viewModel)
        Calendar()
        ScheduleToday(viewModel)
        Spacer(modifier = Modifier.height(30.dp))
        RemindersScreen(viewModel)
        Spacer(modifier = Modifier.height(30.dp))
        SetScheduleButton(
            text = "Set Schedule",
            onClick = { navController.navigate("schedule") }
        )
    }
}