package org.example.project.components.schedulepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.project.theme.InterFontFamily
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ScheduleTitle(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text = "Let's set the",
                fontFamily = InterFontFamily(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                letterSpacing = (0.3).sp,
                color = Color(0xFF1E293B)
            )
            Text(
                text = "schedule easily",
                fontFamily = InterFontFamily(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                letterSpacing = (0.3).sp,
                color = Color(0xFF1E293B)
            )
        }
    }
}