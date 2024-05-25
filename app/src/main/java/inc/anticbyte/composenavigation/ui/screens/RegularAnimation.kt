package inc.anticbyte.composenavigation.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import inc.anticbyte.composenavigation.data.DataSource
import inc.anticbyte.composenavigation.ui.theme.ComposeNavigationTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RegularTextAnim(
    modifier: Modifier = Modifier
) {

    ComposeNavigationTheme {
        SharedTransitionLayout {
            var clicked by remember { mutableStateOf(false) }
            AnimatedContent(targetState = clicked, label = "") { contentClicked ->
                Column(modifier.fillMaxSize()) {
                    Text(
                        modifier = modifier
                            .sharedBounds(
                                rememberSharedContentState(key = "bound"),
                                this@AnimatedContent,
                            )
                            .clickable { clicked = !contentClicked },
                        text = DataSource.dataList.first().description,
                        maxLines = if (clicked) Int.MAX_VALUE else 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun DefPrev() {
    ComposeNavigationTheme {
        RegularTextAnim()
    }
}