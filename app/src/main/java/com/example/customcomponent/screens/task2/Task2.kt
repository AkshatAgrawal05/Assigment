package com.example.customcomponent.screens.task2

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.component_library.button.CustomButton
import com.example.component_library.button.style.ButtonDefaultStyle.buttonDefaultStyle
import com.example.component_library.button.style.ButtonErrorStyle.buttonErrorStyle
import com.example.component_library.button.style.ButtonStyleState
import com.example.component_library.button.style.ButtonWarningStyle.buttonWarningStyle
import com.example.customcomponent.screens.DropDownButtonState
import com.example.customcomponent.screens.DropDownButtonStyleState
import com.example.customcomponent.screens.DropDownIconState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task2(viewModel: Task2ViewModel = viewModel()){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Task 2")
                }
            )
        },
        content = { innerPadding ->
            Task2ConfigScreen(Modifier.padding(innerPadding), viewModel)
        }
    )
}

@Composable
fun Task2ConfigScreen(modifier: Modifier, viewModel: Task2ViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ){

        Row(
           modifier = Modifier
               .fillMaxWidth()
               .wrapContentHeight()
               .padding(24.dp)
        ){

            CustomButton(
                modifier = Modifier.weight(1f),
                text = viewModel.button1UiState.title,
                style = when (viewModel.button1UiState.buttonStyle) {
                    ButtonStyleState.DEFAULT -> buttonDefaultStyle()
                    ButtonStyleState.ERROR -> buttonErrorStyle()
                    ButtonStyleState.WARNING -> buttonWarningStyle()
                },
                state = viewModel.button1UiState.buttonState,
                icon = painterResource(viewModel.button1UiState.icon)
            ) {

            }

            CustomButton(
                modifier = Modifier.weight(1f),
                text = viewModel.button2UiState.title,
                style = when (viewModel.button2UiState.buttonStyle) {
                    ButtonStyleState.DEFAULT -> buttonDefaultStyle()
                    ButtonStyleState.ERROR -> buttonErrorStyle()
                    ButtonStyleState.WARNING -> buttonWarningStyle()
                },
                state = viewModel.button2UiState.buttonState,
                icon = painterResource(viewModel.button2UiState.icon)
            ) {

            }

            CustomButton(
                modifier = Modifier.weight(1f),
                text = viewModel.button3UiState.title,
                style = when (viewModel.button3UiState.buttonStyle) {
                    ButtonStyleState.DEFAULT -> buttonDefaultStyle()
                    ButtonStyleState.ERROR -> buttonErrorStyle()
                    ButtonStyleState.WARNING -> buttonWarningStyle()
                },
                state = viewModel.button3UiState.buttonState,
                icon = painterResource(viewModel.button3UiState.icon)
            ) {

            }

        }

        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ){

            Button1Config(modifier,viewModel)

            Button2Config(modifier,viewModel)

            Button3Config(modifier,viewModel)

        }

    }
}

@Composable
fun Button1Config(modifier: Modifier = Modifier,viewModel: Task2ViewModel){
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            // State Dropdown
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "State 1",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonState(
                onStateSelected = {
                    viewModel.updateButton1State(it)
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
                text = "Style 1",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonStyleState(
                onStateSelected = {
                    viewModel.updateButton1Style(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Select Icon 1",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownIconState(
                onStateSelected = {
                    viewModel.updateButton1Icon(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = viewModel.button1UiState.title ?: "",
            onValueChange = {
                viewModel.updateButton1Title(it)
            },
            label = { Text("Title1") }
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable
fun Button2Config(modifier: Modifier = Modifier,viewModel: Task2ViewModel){
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            // State Dropdown
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "State 2",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonState(
                onStateSelected = {
                    viewModel.updateButton2State(it)
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
                text = "Style 2",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonStyleState(
                onStateSelected = {
                    viewModel.updateButton2Style(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Select Icon 2",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownIconState(
                onStateSelected = {
                    viewModel.updateButton2Icon(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = viewModel.button2UiState.title ?: "",
            onValueChange = {
                viewModel.updateButton2Title(it)
            },
            label = { Text("Title 2") }
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Composable
fun Button3Config(modifier: Modifier = Modifier,viewModel: Task2ViewModel){
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            // State Dropdown
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "State 3",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonState(
                onStateSelected = {
                    viewModel.updateButton3State(it)
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
                text = "Style 3",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownButtonStyleState(
                onStateSelected = {
                    viewModel.updateButton3Style(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Select Icon 3",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Medium
            )

            DropDownIconState(
                onStateSelected = {
                    viewModel.updateButton3Icon(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            value = viewModel.button3UiState.title ?: "",
            onValueChange = {
                viewModel.updateButton3Title(it)
            },
            label = { Text("Title 3") }
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}

@Preview
@Composable
fun Task2Preview(){
    Task2(viewModel())
}
