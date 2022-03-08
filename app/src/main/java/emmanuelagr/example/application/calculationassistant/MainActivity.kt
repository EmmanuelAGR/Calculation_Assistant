package emmanuelagr.example.application.calculationassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import emmanuelagr.example.application.calculationassistant.routes.Routes
import emmanuelagr.example.application.calculationassistant.ui.theme.CalculationAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculationAssistantTheme {
                // A surface container using the 'background' color from the theme
                Routes()
            }
        }
    }
}