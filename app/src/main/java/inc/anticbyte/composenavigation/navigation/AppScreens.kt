package inc.anticbyte.composenavigation.navigation

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

sealed class AppScreens {
    @Serializable
    data object FlowerHome

    @Serializable
    data class FlowerDetail(
        @DrawableRes
        val image: Int = 0,
        val name: String = "",
        val color: String = "",
        val type: String = "",
        val description: String = ""
    )
}