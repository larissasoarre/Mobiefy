package app.mobiefy.ui.screens.signupscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {
    Column {
        Spacer(modifier = Modifier.height(300.dp))
        Text("Valeu muito obrigado mas agora virei puta! \n- Valeska Poposuda")
    }
}