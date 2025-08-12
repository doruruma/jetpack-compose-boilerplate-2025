package id.andra.jetpackcomposeboilerplate.core.presentation.theme

import id.andra.jetpackcomposeboilerplate.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

val roboto = FontFamily(
    Font(R.font.roboto_regular, weight = FontWeight.Normal),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_semibold, weight = FontWeight.SemiBold),
    Font(R.font.roboto_bold, weight = FontWeight.Bold)
)