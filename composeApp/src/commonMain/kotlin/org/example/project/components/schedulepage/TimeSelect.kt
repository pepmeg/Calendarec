package org.example.project.components.schedulepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.theme.InterFontFamily

@Composable
fun TimeSelect(
    startHour: Int?,
    endHour: Int?,
    onStartHourChanged: (Int) -> Unit,
    onEndHourChanged: (Int) -> Unit
) {
    Column {
        Text(
            text = "Select time",
            fontWeight = FontWeight.Medium,
            fontFamily = InterFontFamily(),
            fontSize = 16.sp,
            letterSpacing = 0.3.sp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .background(Color(0xFFF1F5F9), RoundedCornerShape(10.dp))
        ) {
            TimeInputField(
                label = "From",
                value = startHour,
                onValueChange = onStartHourChanged,
                modifier = Modifier.weight(1f)
            )

            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "ArrowRight",
                modifier = Modifier.size(32.dp)
            )

            TimeInputField(
                label = "To",
                value = endHour,
                onValueChange = onEndHourChanged,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TimeInputField(
    label: String,
    value: Int?,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(value?.toString() ?: "") }

        Row(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 22.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText.take(2).filter { it.isDigit() }
                    text.toIntOrNull()?.takeIf { it in 0..23 }?.let(onValueChange)
                },
                label = {
                    Text(
                        text = label,
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily(),
                        fontSize = 12.sp,
                        letterSpacing = 0.3.sp
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Gray.copy(alpha = 0.1f),
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    focusedBorderColor = Color(0xFFDE496E),
                    focusedLabelColor = Color(0xFFDE496E),
                    unfocusedLabelColor = Color(0xFF94A3B8),
                    cursorColor = Color(0xFFDE496E),
                    selectionColors = TextSelectionColors(
                        handleColor = Color(0xFFDE496E),
                        backgroundColor = Color(0xFFDE496E)
                    )

                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = InterFontFamily(),
                    letterSpacing = 0.3.sp
                ),
                shape = RoundedCornerShape(15.dp),
                suffix = {
                    Text(
                        text = ":00",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily(),
                        letterSpacing = 0.3.sp
                    )
                }
            )
        }

    }