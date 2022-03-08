package emmanuelagr.example.application.calculationassistant.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import emmanuelagr.example.application.calculationassistant.R
import emmanuelagr.example.application.paintwm.components.PillCard

data class Activities(
    val title: String,
    val description: String,
    val img: Int,
    val imgDescription: String,
    val route: String
)

val activies = listOf(
    Activities(
        "Perímetro de un Polígono Regular",
        "El hexágono es un polígono que cuenta con seis lados.",
        R.drawable.formula_del_perimetro_de_un_hexagono,
        "6 sided regular polygon",
        "/activity_1"
    ),
    Activities(
        "Nómina semanal",
        "Es cuando los trabajadores reciben su salario cada semana.",
        R.drawable.nomina_semanal,
        "Weekly payroll",
        "/activity_2"
    ),
    Activities(
        "Número Entero Positivo / 5 dígitos",
        "Operación matemática mediante la cual se trata de descomponer un número.",
        R.drawable.fraccion,
        "Positive integer between 5 digits",
        "/activity_3"
    ),
    Activities(
        "Décadas a Días",
        "Período de diez años referido a las decenas de siglo.",
        R.drawable._10_anos,
        "Decades to Days",
        "/activity_4"
    ),
    Activities(
        "Masa de Aire",
        "Representa la proporción de la atmósfera que la luz debe atravesar antes de " +
                "golpear la Tierra.",
        R.drawable.world,
        "Air mass",
        "/activity_5"
    ),
    Activities(
        "Número de pulsaciones por cada 10 segundos",
        "Aporta información relevante sobre el estado de salud del paciente.",
        R.drawable.icono_de_coraz_n_rojo_con_latidos,
        "Number of pulses per 10 seconds",
        "/activity_6"
    ),
    Activities(
        "Farenheit a Centígrados",
        "El grado centígrado, es la unidad termométrica cuyo 0 se ubica 0.01 grados por " +
                "debajo del punto triple del agua.",
        R.drawable.thermometer_cf,
        "Fahrenheit to Centigrade",
        "/activity_7"
    ),
    Activities(
        "Centrígados a Farenheit",
        "El grado Fahrenheit es una escala de temperatura cuyas temperaturas de " +
                "congelación y ebullición del agua son 32 °F y 212 °F.",
        R.drawable.thermometer_cf,
        "Centigrade to Fahrenheit",
        "/activity_8"
    )
)

@Composable
fun ActivitiesList(navController: NavController) {
    LazyColumn(content = {
        items(activies) { activity ->
            PillCard(
                title = activity.title,
                description = activity.description,
                img = activity.img,
                imgDescription = activity.imgDescription,
                onClick = { navController.navigate(route = activity.route) }
            )
        }
    })
}