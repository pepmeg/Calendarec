package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.Task
import org.example.project.data.TasksState
import java.time.LocalDate
import java.time.LocalTime

class SharedViewModel : ViewModel() {
    val name = MutableStateFlow("")
    val tasksState = MutableStateFlow(TasksState())
    val notifyActive = MutableStateFlow(false)
    val message = MutableStateFlow("")

    fun showNotification(text: String) {
        message.value = text
        notifyActive.value = true

        viewModelScope.launch {
            delay(4000)
            notifyActive.value = false
        }
    }

    fun addTask(newTask: Task): Boolean {
        val newStart = LocalTime.parse(newTask.starttime)
        val newEnd = LocalTime.parse(newTask.endtime)

        val filteredTasks = tasksState.value.allTasks.filter { task ->
            if (task.date != newTask.date) return@filter true

            val start = LocalTime.parse(task.starttime)
            val end = LocalTime.parse(task.endtime)
            newEnd <= start || newStart >= end
        }

        val updatedTasks = filteredTasks + newTask

        tasksState.update { current ->
            current.copy(allTasks = updatedTasks)
        }
        return true
    }


    fun getTasksFor(date: LocalDate): List<Task> {
        return tasksState.value.allTasks.filter { it.date == date }
    }
}