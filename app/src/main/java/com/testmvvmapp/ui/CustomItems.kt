package com.testmvvmapp.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.*

@Composable
fun FredCardView(
    modifier: Modifier,
    color1: Color,
    color2: Color,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp
) {
    Canvas(modifier){
        val clipPath = Path().apply {
            lineTo(size.width - cutCornerSize.toPx(), 0f)
            lineTo(size.width, cutCornerSize.toPx())
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        clipPath(clipPath){
            drawRoundRect(color = color1, size = size, cornerRadius = CornerRadius(cornerRadius.toPx()))
            drawRoundRect(
                color2,
                Offset(size.width - cutCornerSize.toPx(), -100f),
                Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                CornerRadius(cornerRadius.toPx())
            )
        }
    }
}
@Composable
fun FredText(value: String, style: TextStyle = MaterialTheme.typography.bodyMedium) {
    Text(value, style = style, color = MaterialTheme.colorScheme.onErrorContainer, overflow = TextOverflow.Ellipsis)
}
@Composable
fun FredOTF(value: String,onChangeNumber: (String) -> Unit,id: String,keyboardType: KeyboardType,modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = onChangeNumber,
        modifier,
        label = { Text(id, fontFamily = FontFamily.Serif) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors()
    )
}
@Composable
fun FredTextField(value: String, onChangeNumber: (String) -> Unit, id: String, modifier: Modifier = Modifier) {
    TextField(
        value,
        onChangeNumber,
        modifier,
        label = { Text(id, fontFamily = FontFamily.Serif) },
        shape = MaterialTheme.shapes.medium,
        colors = OutlinedTextFieldDefaults.colors()
    )
}
@Composable
fun FredButton(click: () -> Unit, inf: String, modifier: Modifier = Modifier) {
    Button(click, modifier) { Text(inf, fontFamily = FontFamily.Serif) }
}

@Composable
fun FredCheckbox(value: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        value,
        onCheckedChange,
        Modifier.border(2.dp,MaterialTheme.colorScheme.onErrorContainer,MaterialTheme.shapes.extraSmall),
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.error,
            uncheckedColor = MaterialTheme.colorScheme.onError,
            checkmarkColor = MaterialTheme.colorScheme.inversePrimary,
            disabledCheckedColor = MaterialTheme.colorScheme.primaryContainer,
            disabledUncheckedColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledIndeterminateColor = MaterialTheme.colorScheme.outline
        )
    )
}