package com.example.prak9.view.uicontroller

import android.R.attr.type
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.prak9.view.DetailSiswaScreen
import com.example.prak9.view.EditSiswaScreen
import com.example.prak9.view.EntrySiswaScreen
import com.example.prak9.view.HomeScreen
import com.example.prak9.view.route.DestinasiDetailSiswa
import com.example.prak9.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.prak9.view.route.DestinasiEditSiswa
import com.example.prak9.view.route.DestinasiEntry
import com.example.prak9.view.route.DestinasiHome


@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{
    NavHost(navController=navController, startDestination = DestinasiHome.route, modifier = Modifier)
    {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate(route = "${DestinasiDetailSiswa.route}/${it}") }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
    }


