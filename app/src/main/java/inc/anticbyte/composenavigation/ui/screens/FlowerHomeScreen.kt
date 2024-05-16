package inc.anticbyte.composenavigation.ui.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import inc.anticbyte.composenavigation.data.DataSource.dataList
import inc.anticbyte.composenavigation.data.model.Flowers

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FlowerHomeScreen(
    modifier: Modifier = Modifier, onItemClick: (Flowers) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(dataList) { flower ->
            FlowerListItem(
                modifier = modifier,
                flower = flower,
                onItemClick = { onItemClick(flower) },
                sharedTransitionScope = sharedTransitionScope,
                animatedContentScope = animatedContentScope
            )
        }
    }
}


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FlowerListItem(
    modifier: Modifier = Modifier, flower: Flowers, onItemClick: (Flowers) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        Card(
            modifier = Modifier
                        .sharedElement(
                            sharedTransitionScope.rememberSharedContentState(key = "image-${flower.image}"),
                            animatedVisibilityScope = animatedContentScope
                        )
                .clickable {
                    onItemClick(flower)
                }
                .fillMaxWidth(),
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(120.dp)
                        .height(170.dp),
                    painter = painterResource(id = flower.image),
                    contentDescription = flower.name, contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    modifier = Modifier.sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "text-${flower.name}"),
                        animatedVisibilityScope = animatedContentScope
                    ),
                    text = flower.name.uppercase(),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefPrev() {
//    FlowerHomeScreen()
}