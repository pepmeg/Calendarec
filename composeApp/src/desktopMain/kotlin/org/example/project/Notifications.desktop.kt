package org.example.project

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.zIndex
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_task_notification
import org.example.project.theme.InterFontFamily
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
actual fun Notify(message: String) {
    Box(
        modifier = Modifier.zIndex(2f)
            .padding(horizontal = 24.dp, vertical = 48.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFDE496E), RoundedCornerShape(15.dp))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_task_notification),
                contentDescription = "icon",
                modifier = Modifier
                    .size(30.dp)
            )
            Text(
                "Задача '$message' успешно создана",
                fontFamily = InterFontFamily(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}