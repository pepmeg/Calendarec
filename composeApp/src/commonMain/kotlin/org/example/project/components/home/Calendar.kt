package org.example.project.components.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.theme.InterFontFamily
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

@Composable
fun Calendar(
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
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
            val isToday = date == today
            val isSelected = date == selectedDate

            val dayModifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .clickable { onDateSelected(date) }
                .then(
                    if (isSelected) Modifier
                        .background(Color(0xFFFFF0F0))
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                    else Modifier
                )

            CalendarDay(
                date = date,
                isToday = isToday,
                isSelected = isSelected,
                modifier = dayModifier
            )
        }
    }
}

@Composable
fun CalendarDay(
    date: LocalDate,
    isToday: Boolean,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val isTodayAndNotSelected = isToday && !isSelected

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(50.dp)
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            fontSize = 18.sp,
            fontFamily = InterFontFamily(),
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
            color = when {
                isSelected -> Color(0xFFDE496E)
                isTodayAndNotSelected -> Color(0xFF1E293B)
                else -> Color(0xFF1E293B)
            },
            textAlign = TextAlign.Center
        )

        Text(
            text = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).replace(".", ""),
            fontSize = 14.sp,
            fontFamily = InterFontFamily(),
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
            color = when {
                isSelected -> Color(0xFFDE496E)
                isTodayAndNotSelected -> Color.Gray
                else -> Color.Gray
            },
            textAlign = TextAlign.Center
        )

        if (isSelected) {
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDE496E))
            )
        }
    }
}