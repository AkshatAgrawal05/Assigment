package com.example.component_library.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    icon: Painter?,
    color: Color,
    size: Dp = 24.dp
){
    /**
     * custom semantics can be created for accessibility
     * and can be added in modifier
     */

    Box(
        modifier = Modifier
            .requiredSize(size)
            .then(modifier),
        contentAlignment = Alignment.Center
    ){
        icon?.let {
            Icon(
                modifier = Modifier
                    .requiredHeight(size)
                    .requiredWidth(size),
                painter = it,
                tint = color,
                contentDescription = null
            )
        }
    }

}