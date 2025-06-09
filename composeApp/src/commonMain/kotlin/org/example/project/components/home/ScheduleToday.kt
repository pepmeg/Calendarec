package org.example.project.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.avatars_icon
import org.example.project.SharedViewModel
import org.example.project.data.Task
import org.example.project.theme.InterFontFamily
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import java.time.LocalDate

@Composable
fun ScheduleToday(viewModel: SharedViewModel, date: LocalDate) {
    val tasks by remember(date, viewModel.tasksState) {
        derivedStateOf {
            viewModel.getTasksFor(date)
        }
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Schedule Today",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = InterFontFamily(),
            color = Color(0xFF1E293B),
            letterSpacing = 0.3.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            if (tasks.isNotEmpty()) {
                val density = LocalDensity.current
                tasks.sortedBy { task ->
                    task.starttime.substringBefore(":").toIntOrNull() ?: 0
                }.forEach { task ->

                    var measuredHeightPx by remember { mutableStateOf(0) }
                    val measuredHeightDp = with(density) { measuredHeightPx.toDp() }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .height(measuredHeightDp)
                                .padding(end = 8.dp)
                        ) {
                            Text(
                                text = task.starttime,
                                color = Color(0xFF64748B),
                                fontFamily = InterFontFamily(),
                                fontSize = 14.sp
                            )
                            Text(
                                text = task.endtime,
                                color = Color(0xFF64748B),
                                fontFamily = InterFontFamily(),
                                fontSize = 14.sp
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .onGloballyPositioned { coordinates ->
                                    measuredHeightPx = coordinates.size.height
                                }
                        ) {
                            ScheduleItem(task = task)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            } else {
                Text(
                    text = "Nothing",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun ScheduleItem(task: Task) {
    fun categoryColor(category: String): Color = when (category) {
        "Meeting" -> Color(0xFFF59E0B)
        "Hangout" -> Color(0xFF701A75)
        "Cooking" -> Color(0xFFDC2626)
        "Other" -> Color(0xFF4A4A4A)
        "Weekend" -> Color(0xFF1A7529)
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFDE496E), shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(
                            color = categoryColor(task.title),
                            shape = CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = task.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = InterFontFamily(),
                    modifier = Modifier.weight(1f)
                )
            }

            if (task.note.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = task.note,
                    fontSize = 12.sp,
                    maxLines = 2,
                    color = Color.White.copy(alpha = 0.8f),
                    fontFamily = InterFontFamily(),
                    modifier = Modifier.padding(start = 10.dp, end = 30.dp)
                )
            }
        }

        Image(
            painter = painterResource(Res.drawable.avatars_icon),
            contentDescription = "avatars",
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.CenterEnd)
        )
    }
}