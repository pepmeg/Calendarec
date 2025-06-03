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
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import kotlinproject.composeapp.generated.resources.plus_icon

@Composable
fun Category(
    selectedCategory: String?,
    onCategorySelected: (String) -> Unit
) {
    Column() {
        Row() {
            Text("Category", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
        Row(modifier = Modifier.padding(top = 16.dp)) {
            CategoryChip(
                name = "Meeting",
                color = Color(0xFFFFFBEB),
                dotColor = Color(0xFFF59E0B),
                isSelected = selectedCategory == "Meeting",
                onClick = { onCategorySelected("Meeting") }
            )

            Spacer(modifier = Modifier.width(14.dp))

            CategoryChip(
                name = "Hangout",
                color = Color(0xFFFDF4FF),
                dotColor = Color(0xFF701A75),
                isSelected = selectedCategory == "Hangout",
                onClick = { onCategorySelected("Hangout") }
            )

            Spacer(modifier = Modifier.width(14.dp))

            CategoryChip(
                name = "Cooking",
                color = Color(0xFFFEF2F2),
                dotColor = Color(0xFFDC2626),
                isSelected = selectedCategory == "Cooking",
                onClick = { onCategorySelected("Cooking") }
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            CategoryChip(
                name = "Other",
                color = Color(0xFFF6F6F6),
                dotColor = Color(0xFF4A4A4A),
                isSelected = selectedCategory == "Other",
                onClick = { onCategorySelected("Other") }
            )

            Spacer(modifier = Modifier.width(14.dp))

            CategoryChip(
                name = "Weekend",
                color = Color(0xFFF0FFF5),
                dotColor = Color(0xFF1A7529),
                isSelected = selectedCategory == "Weekend",
                onClick = { onCategorySelected("Weekend") }
            )

            Image(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .size(24.dp),
                painter = painterResource(Res.drawable.plus_icon),
                contentDescription = "Add new category"
            )
        }
    }
}

@Composable
fun CategoryChip(
    name: String,
    color: Color,
    dotColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) color.copy(alpha = 0.8f) else color
    val borderColor = if (isSelected) dotColor else Color.Transparent

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(26.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 7.dp)
                .align(Alignment.CenterStart)
                .size(13.dp)
                .background(
                    color = dotColor,
                    shape = CircleShape
                )
        )
        Text(
            name,
            modifier = Modifier.align(Alignment.Center).padding(start = 12.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
        )
    }
}