package id.andra.jetpackcomposeboilerplate.presentation.components.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import id.andra.jetpackcomposeboilerplate.presentation.theme.Neutral90

@Composable
fun TextBody1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 14.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextBody2(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 12.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextButtonS(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 10.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.25.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 1.25.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextCaption(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 10.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextCaptionS(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 8.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextSubtitle2(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.1.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextSubtitle1(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.Normal,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 16.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextHeadingS(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    fontWeight: FontWeight? = FontWeight.W700,
    color: Color = Neutral90,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.15.sp,
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}