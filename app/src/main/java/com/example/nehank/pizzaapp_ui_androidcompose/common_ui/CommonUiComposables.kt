package com.example.nehank.pizzaapp_ui_androidcompose.common_ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SpacerHeight() {
    Spacer(modifier = Modifier.height(4.dp))
}


@Composable
fun CustomIconButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    imageTitle: String,
    onClick: () -> Unit
) {
    IconButton(modifier = modifier, onClick = {
        onClick()
    }) {
        Icon(painter = painterResource(id = icon), contentDescription = imageTitle, tint = Color.White)
    }
}