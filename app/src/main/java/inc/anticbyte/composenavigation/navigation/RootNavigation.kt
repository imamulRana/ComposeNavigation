package inc.anticbyte.composenavigation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import inc.anticbyte.composenavigation.ui.theme.HomeScreen
import inc.anticbyte.composenavigation.ui.theme.ProfileScreen
import kotlinx.serialization.Serializable

sealed class AppScreens {
    @Serializable
    data object Home

    @Serializable
    data class Profile(
        val name: String = "",
        val age: Int = 23,
        val gender: String = "Male",
        val email: String = "edithkermicatrowosevelt@examplepetstore.com"
    )
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RootNavigation(modifier: Modifier = Modifier, navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
            navController = navController,
            startDestination = AppScreens.Home
        ) {
            composable<AppScreens.Home> {
                HomeScreen(
                    onClick = { profileData ->
                        navController.navigate(AppScreens.Profile(profileData))
                    }
                )
            }
            composable<AppScreens.Profile> {
                ProfileScreen(
                    onClick = { navController.popBackStack() },
                    profileData = it.toRoute()
                )
            }
        }
    }
}