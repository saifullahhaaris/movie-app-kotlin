package com.example.mymovieapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GradientButton(
    onClick: () -> Unit,
    text: String,
    gradientColors: List<Color>,
    contentColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(),
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(colors = gradientColors),
                shape = ButtonDefaults.shape
            )
    ) {
        Text(text = text)
    }
}

//@Composable
//fun ExampleGradientScreen() {
//    GradientButton(
//        onClick = { /* ... */ },
//        text = "Retrieve Movie",
//        gradientColors = listOf(Color.Blue, Color(0xFF64B5F6)), // Example blue gradient
//        contentColor = Color.White
//    )
//    GradientButton(
//        onClick = { /* ... */ },
//        text = "Add to Database",
//        gradientColors = listOf(Color.Green, Color(0xFF81C784)), // Example green gradient
//        contentColor = Color.White
//    )
//    // ... other gradient buttons
//}