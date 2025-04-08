package id.andra.jetpackcomposeboilerplate.presentation.components.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import id.andra.jetpackcomposeboilerplate.presentation.theme.Neutral90
import id.andra.jetpackcomposeboilerplate.presentation.theme.textBody1
import id.andra.jetpackcomposeboilerplate.presentation.theme.textBody2
import id.andra.jetpackcomposeboilerplate.presentation.theme.textButton
import id.andra.jetpackcomposeboilerplate.presentation.theme.textButtonS
import id.andra.jetpackcomposeboilerplate.presentation.theme.textCaption
import id.andra.jetpackcomposeboilerplate.presentation.theme.textCaptionS
import id.andra.jetpackcomposeboilerplate.presentation.theme.textHeadingS
import id.andra.jetpackcomposeboilerplate.presentation.theme.textSubtitle1
import id.andra.jetpackcomposeboilerplate.presentation.theme.textSubtitle2

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
        style = textBody1.copy(
            fontWeight = fontWeight
        ),
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
        style = textBody2.copy(
            fontWeight = fontWeight
        ),
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
        style = textButtonS.copy(
            fontWeight = fontWeight
        ),
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
        style = textButton.copy(
            fontWeight = fontWeight
        ),
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
        style = textCaption.copy(
            fontWeight = fontWeight
        ),
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
        style = textCaptionS.copy(
            fontWeight = fontWeight
        ),
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
        style = textSubtitle2.copy(
            fontWeight = fontWeight
        ),
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
        style = textSubtitle1.copy(
            fontWeight = fontWeight
        ),
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
        style = textHeadingS.copy(
            fontWeight = fontWeight
        ),
        modifier = modifier,
        maxLines = maxLines,
        color = color,
        textAlign = textAlign
    )
}