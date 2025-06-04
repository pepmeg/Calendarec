package org.example.project.components.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.theme.InterFontFamily
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun DateSelect(
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
) {
    val today = LocalDate.now()
    val dates = listOf(
        today,
        today.plusDays(1),
        today.plusDays(2)
    )

    Column {
        Text(
            text = "Select the date",
            fontWeight = FontWeight.Medium,
            fontFamily = InterFontFamily(),
            fontSize = 16.sp,
            letterSpacing = 0.3.sp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
        ) {
            dates.forEach { date ->
                Day(
                    date = date,
                    isSelected = date == selectedDate,
                    onClick = { onDateSelected(date) }
                )
            }

            OtherDay()
        }
    }
}

@Composable
fun Day(
    date: LocalDate,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val dayOfMonth = date.dayOfMonth
    val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .width(75.dp)
            .height(100.dp)
            .background(
                color = if (isSelected) Color(0xFF8572FF) else Color(0xFFF1F5F9),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Text(
            text = dayOfMonth.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = InterFontFamily(),
            letterSpacing = 0.3.sp,
            color = if (isSelected) Color.White else Color(0xFF4A4A4A),
            modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 30.dp)
        )
        Text(
            text = dayOfWeek,
            fontSize = 14.sp,
            fontFamily = InterFontFamily(),
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.3.sp,
            color = if (isSelected) Color.White else Color(0xFF4A4A4A),
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}

@Composable
fun OtherDay() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFF1F5F9), RoundedCornerShape(10.dp))
    ) {
        androidx.compose.material.Text(
            text = "Other",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = InterFontFamily(),
            letterSpacing = (0.3).sp,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 30.dp)
        )
        androidx.compose.material.Text(
            text = "Date",
            fontSize = 14.sp,
            fontFamily = InterFontFamily(),
            fontWeight = FontWeight.Normal,
            letterSpacing = (0.3).sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}