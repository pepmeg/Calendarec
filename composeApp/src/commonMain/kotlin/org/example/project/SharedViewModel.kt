package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.Task
import org.example.project.data.TasksState

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

    fun saveName(newName: String) {
        name.value = newName
    }

    fun addTask(newTask: Task) {
        tasksState.update { current ->
            current.copy(allTasks = current.allTasks + newTask)
        }
    }

    fun getTodayTasks(): List<Task> {
        return tasksState.value.allTasks.filter { it.isToday() }
    }

    fun getTomorrowTasks(): List<Task> {
        return tasksState.value.allTasks.filter { it.isTomorrow() }
    }

}