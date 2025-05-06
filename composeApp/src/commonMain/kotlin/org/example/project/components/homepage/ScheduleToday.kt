package org.example.project.components.homepage

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

@Composable
fun ScheduleToday(viewModel: SharedViewModel) {
    val todayTasks = viewModel.getTodayTasks()
    val timeSlots = listOf("08:00", "10:00", "12:00", "14:00", "16:00")

    Column {
        Text(
            text = "Schedule Today",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = InterFontFamily(),
            color = Color(0xFF1E293B),
            letterSpacing = 0.3.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                timeSlots.forEach { time ->
                    Text(
                        text = time,
                        color = Color(0xFF64748B),
                        fontFamily = InterFontFamily(),
                        fontSize = 14.sp
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(start = 32.dp)
            ) {
                todayTasks.forEach { task ->
                    ScheduleItem(task = task)
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}

@Composable
fun ScheduleItem(task: Task) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((task.duration * 40).dp - 8.dp)
            .background(Color(0xFFDE496E), shape = RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        Text(
            text = task.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = InterFontFamily(),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(6.dp)
        )

        Image(
            painter = painterResource(Res.drawable.avatars_icon),
            contentDescription = "avatars",
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.BottomEnd)
        )
    }
}