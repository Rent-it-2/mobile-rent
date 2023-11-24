package sptech.school.rent_it.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sptech.school.rent_it.R

private val Roboto = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_bold),
    Font(R.font.roboto_italic),
    Font(R.font.roboto_light),
    Font(R.font.roboto_medium),
    Font(R.font.roboto_regular),
    Font(R.font.roboto_thin)
)

val typography = Typography(
//    defaultFontFamily = Roboto,
    headlineSmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)