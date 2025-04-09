package com.example.appaula.ui.components.defaults

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(8.dp),
    contentPadding: PaddingValues = PaddingValues(2.dp),
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        contentPadding = contentPadding
    ) {
        content()
    }
}
