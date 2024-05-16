package inc.anticbyte.composenavigation.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Flowers(
    @DrawableRes
    val image: Int,
    val name: String,
    val type: String,
    val color: String,
)
