package com.example.prak9.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Modifier

@Composable
fun SiswaApp(navController: NavController= rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}