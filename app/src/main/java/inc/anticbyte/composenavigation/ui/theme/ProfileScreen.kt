package inc.anticbyte.composenavigation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import inc.anticbyte.composenavigation.navigation.AppScreens

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    profileData: AppScreens.Profile,
    onClick: () -> Unit,
) {
    Column {
        Text(text = "Hello, Profile Screen")
        Button(onClick = onClick) {
            Text(text = "Go to Home Screen")
        }
        Text(text = profileData.name)
        Text(text = profileData.email)
        Text(text = profileData.age.toString())
        Text(text = profileData.gender)
    }
}