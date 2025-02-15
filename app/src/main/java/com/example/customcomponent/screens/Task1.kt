package com.example.customcomponent.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.component_library.button.CustomButton
import com.example.component_library.button.style.ButtonDefaultStyle.buttonDefaultStyle
import com.example.component_library.button.style.ButtonErrorStyle.buttonErrorStyle
import com.example.component_library.button.style.ButtonStyleState
import com.example.component_library.button.style.ButtonWarningStyle.buttonWarningStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task1() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Task 1")
                }
            )
        },
        content = { innerPadding ->
            ConfigScreen(Modifier.padding(innerPadding))
        }
    )

}


@Composable
fun ConfigScreen(modifier: Modifier) {

    var uiState by remember {
        mutableStateOf(UiState())
    }

    Column(
        modifier = modifier
            .then(Modifier.padding(16.dp))
    ) {
        Text("Configuration", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            // State Dropdown
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "State",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonState(
                onStateSelected = {
                    uiState = uiState.copy(buttonState = it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            // State Dropdown
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Style",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonStyleState(
                onStateSelected = {
                    uiState = uiState.copy(buttonStyle = it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Select Icon",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownIconState(
                onStateSelected = {
                    uiState = uiState.copy(icon = it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Quick Actions
        Text("Quick Actions", fontWeight = FontWeight.Medium)

        OutlinedTextField(
            value = uiState.title ?: "",
            onValueChange = {
                uiState = uiState.copy(title = it)
            },
            label = { Text("Title") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // State 1 with Skeleton
        Text("States", fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {

            CustomButton(
                style = when (uiState.buttonStyle) {
                    ButtonStyleState.DEFAULT -> buttonDefaultStyle()
                    ButtonStyleState.ERROR -> buttonErrorStyle()
                    ButtonStyleState.WARNING -> buttonWarningStyle()
                },
                text = uiState.title,
                icon = painterResource(uiState.icon),
                state = uiState.buttonState
            ) { }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    Task1()
}
