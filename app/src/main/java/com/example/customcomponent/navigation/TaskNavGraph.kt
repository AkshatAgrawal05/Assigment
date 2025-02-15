package com.example.customcomponent.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.customcomponent.screens.Home
import com.example.customcomponent.screens.Task1
import com.example.customcomponent.screens.task2.Task2

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home"){

        composable("home") {
            Home(navController)
        }

        composable("task1"){
            Task1()
        }

        composable("task2"){
            Task2()
        }
    }
}