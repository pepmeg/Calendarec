package org.example.project.components.schedulepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import org.example.project.SharedViewModel
import org.example.project.data.Task
import java.time.LocalDate


@Composable
fun TaskSet(
    viewModel: SharedViewModel,
    navController: NavController
) {
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    var startHour by remember { mutableStateOf<Int?>(null) }
    var endHour by remember { mutableStateOf<Int?>(null) }
    var note by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DateSelect(
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TimeSelect(
            startHour = startHour,
            endHour = endHour,
            onStartHourChanged = { startHour = it },
            onEndHourChanged = { endHour = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Category()

        Spacer(modifier = Modifier.height(16.dp))


        InputNote(
            note = note,
            onNoteChanged = { note = it },
            onSaveClicked = {
                if (selectedDate != null && startHour != null && endHour != null && note.isNotBlank()) {
                    val duration = (endHour!! - startHour!!).coerceAtLeast(1)
                    val timeString = "%02d:00".format(startHour!!)
                    val taskDate = selectedDate!!

                    val task = Task(
                        title = note,
                        time = timeString,
                        duration = duration,
                        date = taskDate
                    )


                    viewModel.addTask(task)
                    viewModel.showNotification(note)
                    navController.navigate("home")
                }
            }
        )
    }
}
