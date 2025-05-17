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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun ScheduleToday(viewModel: SharedViewModel) {
    val todayTasks = viewModel.getTodayTasks()
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Schedule Today",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = InterFontFamily(),
                color = Color(0xFF1E293B),
                letterSpacing = 0.3.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            val density = LocalDensity.current

            todayTasks.sortedBy {
                it.time.substringBefore(":").toIntOrNull() ?: 0
            }.forEachIndexed { index, task ->

                val startHour = task.time.substringBefore(":").toIntOrNull() ?: 0
                val endHour = (startHour + task.duration).coerceAtMost(24)

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
                            text = "%02d:00".format(startHour),
                            color = Color(0xFF64748B),
                            fontFamily = InterFontFamily(),
                            fontSize = 14.sp
                        )
                        Text(
                            text = "%02d:00".format(endHour),
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
        }
    }
}

@Composable
fun ScheduleItem(task: Task) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFFDE496E), shape = RoundedCornerShape(16.dp))
            .padding(6.dp)
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
                .padding(end = 36.dp)
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