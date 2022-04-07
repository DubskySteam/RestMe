import Request.Request
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun UI() {

    var input by remember { mutableStateOf("") }
    val request = remember { Request() }
    var progress by remember { mutableStateOf(0.0f) }

    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Row {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                label = { Text("CALL ADRESS") }
            )
        }
        Row (verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {progress+=0.1f}) {
                Text(text = "GET")
            }
            Button(
                onClick = request::post
                ) {
                Text(text = "POST")
            }
            Button(onClick = request::get) {
                Text(text = "Test")
            }
        }
        Row {
            CircularProgressIndicator(progress = progress, color = Color.White)
        }
    }
}

