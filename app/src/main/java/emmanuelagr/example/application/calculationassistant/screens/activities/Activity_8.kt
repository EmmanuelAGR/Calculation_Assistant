package emmanuelagr.example.application.calculationassistant.screens.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.components.AppBar
import emmanuelagr.example.application.calculationassistant.components.CardTemplate

@Composable
fun Activity_8(
    navController: NavController
) {
    var centigrade by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Centrígados:") },
            value = centigrade,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+[.]?+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    centigrade = it
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
        topBar = { AppBar(title = "Actividad No. 8", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Centrígados a Farenheit",
                cardWidth = 300.dp,
                cardHeight = 300.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {
                    result = String.format(
                        "%.0f",
                        9.0 / 5.0 * (if (centigrade != "") centigrade.toDouble() else 0.0) + 32.0
                    )
                },
                result = "Farenheit = $result °F"
            )
        }
    }
}

