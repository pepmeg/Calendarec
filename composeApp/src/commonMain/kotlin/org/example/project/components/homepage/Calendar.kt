package org.example.project.components.homepage

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.theme.InterFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
@Preview
fun Calendar() {
    val today = LocalDate.now()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        (-3..3).forEach { offset ->
            val date = today.plusDays(offset.toLong())
            CalendarDay(
                date = date,
                isToday = offset == 0,
                modifier = Modifier
                    .then(
                        if (offset == 0) Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Red.copy(alpha = 0.05f))
                            .padding(top = 16.dp, bottom = 6.dp, start = 16.dp, end = 16.dp)
                        else Modifier
                    )
            )
        }
    }
}

@Composable
fun CalendarDay(
    date: LocalDate,
    isToday: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            fontSize = 18.sp,
            fontFamily = InterFontFamily(),
            fontWeight = if (isToday) FontWeight.Bold else FontWeight.SemiBold,
            color = if (isToday) Color.Red else Color(0xFF1E293B),
            textAlign = TextAlign.Center
        )

        Text(
            text = date.dayOfWeek.getDisplayName(
                TextStyle.SHORT,
                Locale.ENGLISH
            ).replace(".", ""),
            fontSize = 14.sp,
            fontFamily = InterFontFamily(),
            color = if (isToday) Color.Red else Color.Gray,
            textAlign = TextAlign.Center
        )

        if (isToday) {
            DotIndicator()
        }
    }
}

@Composable
private fun DotIndicator() {
    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .size(6.dp)
            .clip(CircleShape)
            .background(Color.Red)
    )
}