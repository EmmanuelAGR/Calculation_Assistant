package emmanuelagr.example.application.calculationassistant.screens.activities

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.components.AppBar
import emmanuelagr.example.application.calculationassistant.components.CardTemplate

@Composable
fun Activity_2(
    navController: NavController
) {
    var employees by remember { mutableStateOf(mutableListOf("", "", "", "", "")) }
    var result by remember { mutableStateOf(0) }
    val visibility = remember { mutableStateOf(false) }

    @Composable
    fun CardBody() {
        Box(modifier = Modifier.height(240.dp)) {
            LazyColumn {
                itemsIndexed(employees) { index, employe ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            placeholder = { Text(text = "Horas trabajadas") },
                            label = { Text(text = "Empleado No. ${index + 1}:") },
                            value = employe,
                            onValueChange = { value ->
                                if (value.contains(regex = Regex("^[0-9]+([0-9]+)?$"))
                                    && value.toInt() <= 168 || value == ""
                                ) {
                                    employees = employees.toMutableList().also {
                                        it[index] = value
                                    }
                                    visibility.value = false
                                }
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = MaterialTheme.colors.secondary,
                                placeholderColor = MaterialTheme.colors.secondary
                            ),
                            modifier = Modifier
                                .weight(1f)
                        )

                        Spacer(modifier = Modifier.padding(end = 10.dp))

                        OutlinedTextField(
                            placeholder = { Text(text = "0 COP") },
                            label = { Text(text = "Pago:") },
                            value = if (employe != "") "${employe.toInt() * 1000}" else "0 COP",
                            onValueChange = { },
                            singleLine = true,
                            enabled = false,
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = MaterialTheme.colors.secondary,
                                placeholderColor = MaterialTheme.colors.secondary
                            ),
                            modifier = Modifier
                                .weight(0.55f)
                        )
                    }
                    if (index <= employees.count()) Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

    Scaffold(
        topBar = { AppBar(title = "Actividad No. 1", navController = navController) }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CardTemplate(
                title = "Perímetro de un Polígono Regular",
                cardWidth = 300.dp,
                cardHeight = 460.dp,
                body = { CardBody() },
                visibility = visibility,
                onClick = {
                    employees.forEach {
                        if (it != "")
                            result += it.toInt() * 1000
                    }
                },
                result = "Total a Pagar = $result COP"
            )
        }
    }
}

