package inc.anticbyte.composenavigation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, onClick: (String) -> Unit,
) {
    var value by rememberSaveable { mutableStateOf("") }
    Column {
        Text(text = "Hello, Home Screen")
        AppPrimaryTextField(textValue = value, onTextValueChange = { value = it })
        Button(onClick = { onClick(value) }) {
            Text(text = "Go to Profile Screen")
        }
    }
}


@Composable
fun AppPrimaryTextField(
    modifier: Modifier = Modifier,
    textValue: String,
    onTextValueChange: (String) -> Unit,
) {
    var value by rememberSaveable { mutableStateOf(textValue) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { value = it;onTextValueChange(it) })
}