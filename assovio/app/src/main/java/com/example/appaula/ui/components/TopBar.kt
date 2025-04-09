package com.example.appaula.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appaula.ui.components.defaults.DefaultButton

@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    onClickBack: (() -> Unit)? = null
) {
    Column {
        Row(
            modifier = modifier.padding(vertical = 16.dp, horizontal = 8.dp).fillMaxWidth().height(46.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (onClickBack !== null) {
                DefaultButton(
                    onClick = onClickBack,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxHeight()
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                textAlign = if (onClickBack === null) TextAlign.Center else null,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace
            )
        }
        HorizontalDivider(thickness = 2.dp)
    }
}
