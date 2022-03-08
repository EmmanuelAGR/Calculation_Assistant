package emmanuelagr.example.application.calculationassistant.screens.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun Activity_5(
    navController: NavController
) {
    var pressure by remember { mutableStateOf("0.0") }
    var volume by remember { mutableStateOf("0.0") }
    var temperature by remember { mutableStateOf("0.0") }

    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Presión:") },
            value = pressure,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?\$"))
                    && it.length <= 10 || it == ""
                ) {
                    pressure = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Volumen:") },
            value = volume,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?\$"))
                    && it.length <= 10 || it == ""
                ) {
                    volume = it
                    visibility.value = false
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.secondary,
                placeholderColor = MaterialTheme.colors.secondary
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Temperatura:") },
            value = temperature,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?\$"))
                    && it.length <= 10 || it == ""
                ) {
                    temperature = it
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
        topBar = { AppBar(title = "Actividad No. 5", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Masa de Aire",
                cardWidth = 300.dp,
                cardHeight = 420.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {
                    result = String.format(
                        "%.2f",
                        (pressure.toDouble() * volume.toDouble()) / (0.37 * (temperature.toDouble() + 460.0))
                    )
                },
                result = "Masa del Aire = $result",
                resultSize = 16.sp
            )
        }
    }
}

