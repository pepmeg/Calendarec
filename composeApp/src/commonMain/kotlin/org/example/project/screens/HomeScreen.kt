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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.example.project.SharedViewModel
import org.example.project.components.SetScheduleButton
import org.example.project.components.home.Home
import org.example.project.components.home.RemindersScreen
import org.example.project.components.home.ScheduleToday
import org.example.project.components.homepage.Calendar
import org.jetbrains.compose.ui.tooling.preview.Preview
import java.time.LocalDate

@Composable
@Preview
fun HomeScreen(navController: NavController, viewModel: SharedViewModel) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 48.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Home(viewModel)
        Calendar(
            selectedDate = selectedDate,
            onDateSelected = { newDate ->
                selectedDate = newDate
            }
        )
        ScheduleToday(viewModel, date = selectedDate)
        Spacer(modifier = Modifier.height(30.dp))
        RemindersScreen(viewModel, date = selectedDate)
        Spacer(modifier = Modifier.height(30.dp))
        SetScheduleButton(
            text = "Set Schedule",
            onClick = { navController.navigate("schedule") }
        )
    }
}