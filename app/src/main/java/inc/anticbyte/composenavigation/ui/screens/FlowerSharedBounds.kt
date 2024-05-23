package inc.anticbyte.composenavigation.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import inc.anticbyte.composenavigation.R


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FlowerSharedBounds(modifier: Modifier = Modifier) {
    var showDetails by remember { mutableStateOf(false) }

    SharedTransitionLayout(modifier = modifier.clickable { showDetails = !showDetails }) {
        AnimatedContent(targetState = showDetails, label = "") { targetState ->
            if (targetState) {
                DetailedContent(
                    modifier = modifier,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedContent,
                    onBack = { showDetails = !showDetails }
                )
            } else {
                MainContent(
                    modifier = modifier,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedVisibilityScope = this@AnimatedContent,
                    onShowDetails = {
                        showDetails = !showDetails
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onShowDetails: () -> Unit
) {
    with(sharedTransitionScope) {
        Row(
            modifier = Modifier
                .padding(8.dp)

                .background(MaterialTheme.colorScheme.surfaceContainer)
                .fillMaxWidth()
                .clickable { onShowDetails() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card {
                Row {
                    Image(
                        modifier = Modifier
                            .sharedElement(
                                rememberSharedContentState(key = "image"),
                                animatedVisibilityScope = animatedVisibilityScope
                            )
                            .size(60.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.pink_rose),
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = modifier.width(20.dp))
            Text(
                text = "Rose", modifier = Modifier.sharedElement(
                    rememberSharedContentState(key = "title"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
            )
        }
    }
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailedContent(
    modifier: Modifier = Modifier,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onBack: () -> Unit,
) {
    with(sharedTransitionScope) {
        Column(
            modifier = Modifier
                .padding(top = 200.dp, start = 16.dp, end = 16.dp)

                .clickable {
                    onBack()
                }
        ) {
            Card(modifier = modifier.clip(CircleShape)) {
                Image(
                    modifier = Modifier
                        .size(200.dp)
                        .sharedElement(
                            rememberSharedContentState(key = "image"),
                            animatedVisibilityScope = animatedVisibilityScope
                        ),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.pink_rose),
                    contentDescription = null,
                )
            }
            Text(
                text = "Rose", modifier = Modifier.sharedElement(
                    rememberSharedContentState(key = "title"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
            )
            Spacer(modifier = modifier.height(20.dp))
            Text(text = "The pink rose is a classic and elegant flower that is known for its beauty and fragrance. It has many layers of soft pink petals and a sweet, delicate scent. The pink rose is often used in bouquets and arrangements for special occasions such as weddings and anniversaries.")
        }
    }
}

@Preview
@Composable
private fun DefPrev() {
    FlowerSharedBounds()
}