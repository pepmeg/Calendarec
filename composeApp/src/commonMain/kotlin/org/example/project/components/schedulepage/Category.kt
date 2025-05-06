package org.example.project.components.schedulepage

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import org.example.project.theme.InterFontFamily
import org.jetbrains.compose.resources.painterResource
import androidx.compose.foundation.Image
import kotlinproject.composeapp.generated.resources.plus_icon

@Composable
fun Category(){
Column (modifier = Modifier.padding(end = 23.dp)) {
    Row(modifier = Modifier.padding(top = 34.dp)) {
        Text("Category", fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
    Row(modifier = Modifier.padding(top = 16.dp)) {
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(26.dp)
                .background(
                    color = Color(0xFFFFFBEB),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .align(Alignment.CenterStart)
                    .size(13.dp)
                    .background(
                        color = Color(0xFFF59E0B),
                        shape = CircleShape
                    )
            )
            Text(
                "Meeting",
                modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(26.dp)
                .background(
                    color = Color(0xFFFDF4FF),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .align(Alignment.CenterStart)
                    .size(13.dp)
                    .background(
                        color = Color(0xFF701A75),
                        shape = CircleShape
                    )
            )
            Text(
                "Hangout",
                modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(26.dp)
                .background(
                    color = Color(0xFFFEF2F2),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .align(Alignment.CenterStart)
                    .size(13.dp)
                    .background(
                        color = Color(0xFFDC2626),
                        shape = CircleShape
                    )
            )
            Text(
                "Cooking",
                modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
    Row(modifier = Modifier.padding(top = 8.dp)) {
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(26.dp)
                .background(
                    color = Color(0xFFF6F6F6),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .align(Alignment.CenterStart)
                    .size(13.dp)
                    .background(
                        color = Color(0xFF4A4A4A),
                        shape = CircleShape
                    )
            )
            Text(
                "Other",
                modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(26.dp)
                .background(
                    color = Color(0xFFF0FFF5),
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 7.dp)
                    .align(Alignment.CenterStart)
                    .size(13.dp)
                    .background(
                        color = Color(0xFF1A7529),
                        shape = CircleShape
                    )
            )
            Text(
                "Weekend",
                modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Image(
            modifier = Modifier.padding(start = 14.dp).size(24.dp),
            painter = painterResource(Res.drawable.plus_icon),
            contentDescription = "Задний фон"
        )
    }
}
    }
