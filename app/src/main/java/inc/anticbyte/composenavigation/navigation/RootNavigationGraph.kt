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
import inc.anticbyte.composenavigation.ui.screens.FlowerDetailScreen
import inc.anticbyte.composenavigation.ui.screens.FlowerHomeScreen


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RootNavigationGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(
            modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars),
            navController = navController,
            startDestination = AppScreens.FlowerHome
        ) {
            composable<AppScreens.FlowerHome> {
                FlowerHomeScreen(
                    onItemClick = { flower ->
                        navController.navigate(
                            AppScreens.FlowerDetail(
                                flower.image,
                                flower.name,
                                flower.color,
                                flower.type,
                                flower.description
                            )
                        )
                    },
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable
                )
            }
            composable<AppScreens.FlowerDetail> {
                FlowerDetailScreen(
                    flowerDetail = it.toRoute(),
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable
                )
            }
        }
    }
}