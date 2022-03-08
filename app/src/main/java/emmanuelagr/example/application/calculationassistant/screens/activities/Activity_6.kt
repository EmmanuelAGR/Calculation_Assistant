package emmanuelagr.example.application.calculationassistant.screens.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.components.AppBar
import emmanuelagr.example.application.calculationassistant.components.CardTemplate

@Composable
fun Activity_6(
    navController: NavController
) {
    var age by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0") },
            label = { Text(text = "Edad del paciente:") },
            value = age,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.toInt() <= 220
                    || it == ""
                ) {
                    age = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            )
        )
    }

    Scaffold(
        topBar = { AppBar(title = "Actividad No. 6", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Número de pulsaciones por cada 10 segundos",
                cardWidth = 300.dp,
                cardHeight = 300.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {
                    result = String.format(
                        "%.0f",
                        (220.0 - if (age != "") age.toDouble() else 0.0) / 10.0
                    )
                },
                result = "Las Pulsaciones recomendadas a la edad de $age son $result " +
                        "por cada 10 segundos.",
                resultSize = 13.sp
            )
        }
    }
}

