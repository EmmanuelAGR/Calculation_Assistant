package emmanuelagr.example.application.calculationassistant.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.components.ActivitiesList
import emmanuelagr.example.application.calculationassistant.components.AppBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { AppBar("Calculation Assistant") },
        content = {
            ActivitiesList(navController)
        }
    )
}