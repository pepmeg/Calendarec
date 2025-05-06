package org.example.project.data

import java.time.LocalDate

data class Task(
    val title: String,
    val time: String,
    val duration: Int,
    val date: LocalDate
) {
    fun isToday(): Boolean = date == LocalDate.now()

    fun isTomorrow(): Boolean = date == LocalDate.now().plusDays(1)
}

data class TasksState(
    val allTasks: List<Task> = emptyList(),
    val showTomorrowOnly: Boolean = false
)