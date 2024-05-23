package inc.anticbyte.composenavigation.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import inc.anticbyte.composenavigation.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedBoundsExample(modifier: Modifier = Modifier) {
    SharedTransitionLayout {

    }
}


@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
) {
    var clicked by remember { mutableStateOf(false) }

    SharedTransitionLayout {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
                    .size(350.dp),
                painter = painterResource(id = R.drawable.pink_rose), contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(text = "Pink Rose")
            Spacer(modifier = modifier.height(24.dp))
            AnimatedContent(
                targetState = clicked,
                label = "",
                modifier = Modifier
            ) { target ->
                Text(
                    modifier = Modifier
                        .combinedClickable(
                            onClick = {
                                clicked = !clicked
                            },
                        )
                        .sharedBounds(
                            sharedContentState = rememberSharedContentState(key = "bound"),
                            animatedVisibilityScope = this@AnimatedContent,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ),
                    text = "The pink rose is a classic and elegant flower that is known for its beauty and fragrance. It has many layers of soft pink petals and a sweet, delicate scent. " +
                            "The pink rose is often used in bouquets and arrangements" +
                            " for special occasions such as weddings and anniversaries",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (target) Int.MAX_VALUE else 3
                )
            }
        }
    }
}


@Composable
fun DetailedContent(modifier: Modifier = Modifier) {

}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview
@Composable
private fun DefPrev() {
    MainContent()
}