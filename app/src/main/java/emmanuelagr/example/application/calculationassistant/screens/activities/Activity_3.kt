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
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.components.AppBar
import emmanuelagr.example.application.calculationassistant.components.CardTemplate

@Composable
fun Activity_3(
    navController: NavController
) {
    var uInt by remember { mutableStateOf("") }
    var division by remember { mutableStateOf("") }

    var result by remember { mutableStateOf("") }
    var enabled by remember { mutableStateOf(false) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        OutlinedTextField(
            placeholder = { Text(text = "0.0") },
            label = { Text(text = "Número Entero Positivo:") },
            value = uInt,
            onValueChange = {
                if (it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 10
                    || it == ""
                ) {
                    uInt = it
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
            label = { Text(text = "Cinco Dígitos:") },
            value = division,
            onValueChange = {
                if (it.contains(regex = Regex("^-([0-9]+)?$")) && it.length <= 6
                    || it.contains(regex = Regex("^[0-9]+([0-9]+)?$")) && it.length <= 5
                    || it == ""
                ) {
                    enabled =
                        it.contains("-") && it.length == 6 || it.contains(regex = Regex("^[0-9]+([0-9]+)?\$")) && it.length == 5

                    division = it
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
        topBar = { AppBar(title = "Actividad No. 3", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Número Entero Positivo / 5 dígitos",
                cardWidth = 300.dp,
                cardHeight = 360.dp,
                body = { CardBody() },
                visibility = visibility,
                enabled = enabled,
                onClick = {
                    result = String.format(
                        "%.2f",
                        (if (uInt != "") uInt.toDouble() else 0.0) / (if (division != "") (division.mapIndexed { index, c ->
                            if (index == 0 && division[0] != ('-')
                                || index == 1 && division[0] == '-' || index == division.length - 1
                            )
                                c.digitToInt() * c.digitToInt()
                            else
                                if (c != ('-')) c.digitToInt() else c
                        }).joinToString("").toDouble() else 0.0)
                    )
                },
                result = "División = $result"
            )
        }
    }
}

