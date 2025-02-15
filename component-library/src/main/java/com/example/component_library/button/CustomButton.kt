package com.example.component_library.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.component_library.R
import com.example.component_library.button.colors.ButtonColorSelector
import com.example.component_library.button.colors.ButtonColors
import com.example.component_library.button.style.ButtonDefaultStyle.buttonDefaultStyle
import com.example.component_library.button.style.ButtonStyle
import com.example.component_library.icon.CustomIcon


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    style: ButtonStyle = buttonDefaultStyle(),
    colors: ButtonColorSelector = style.colorSelector,
    text: String?,
    icon: Painter?,
    state: ButtonState,
    onClick: () -> Unit
    ){

    /**
     * for demo Using same color set for Disabled and Loading state
     * we can create separate color set for Different States
     */
    val colorSet: ButtonColors by remember(state,colors) {
        mutableStateOf(
            if(state == ButtonState.DISABLED || state == ButtonState.LOADING) colors.disabledColors else colors.defaultColors
        )
    }

    val stateIcon = if( state == ButtonState.LOADING) painterResource(R.drawable.ic_loading) else icon

    if(state == ButtonState.SKELETON){
        CustomButtonSkeleton()
    }else{
        CustomButtonBody(
            modifier,
            style,
            colorSet,
            text,
            stateIcon,
            state,
            onClick
        )
    }

}

@Composable
fun CustomButtonBody(
    modifier: Modifier = Modifier,
    style: ButtonStyle,
    colors: ButtonColors,
    text: String?,
    icon: Painter?,
    state: ButtonState,
    onClick: () -> Unit
) {
    val modifierSet = Modifier
        .then(modifier)
        .clickable(
            enabled = state != ButtonState.DISABLED,
            onClickLabel = null,
            role = Role.Button,
            onClick = {
                onClick()
            }
        )

    /**
     * Button can be further customised to use different orientation
     * like
     * BOTTOM will use Column (Icon then Text)
     * RIGHT will use Row(ICON then Text)
     * same LEFT and TOP
     */

    Column(
        modifier = modifierSet,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconBody(style,colors,icon)
        text?.let {
            Text(
                text = it,
                fontWeight = FontWeight.Medium,
                color = colors.labelColor
            )
        }
    }

}

@Composable
fun IconBody(style: ButtonStyle, colors: ButtonColors, icon: Painter?) {
    Box (
        modifier = Modifier
            .padding(12.dp)
            .size(64.dp)
            .clip(CircleShape)
            .background(
                color = colors.containerColor
            ),
        contentAlignment = Alignment.Center
    ){
        CustomIcon(icon = icon, color = colors.contentColor)
    }
}


@Composable
fun CustomButtonSkeleton(){
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
                .width(82.dp)
                .background(Color.LightGray)
        )
    }
}


@Preview
@Composable
fun CustomButtonPreview(){
    CustomButtonSkeleton()
}