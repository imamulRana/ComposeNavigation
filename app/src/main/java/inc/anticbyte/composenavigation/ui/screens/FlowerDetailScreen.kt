package inc.anticbyte.composenavigation.ui.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import inc.anticbyte.composenavigation.navigation.AppScreens

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FlowerDetailScreen(
    modifier: Modifier = Modifier, flowerDetail: AppScreens.FlowerDetail,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope
) {
    with(sharedTransitionScope) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "image-${flowerDetail.image}"),
                        animatedVisibilityScope = animatedContentScope
                    )
                    .clip(RoundedCornerShape(10))
                    .height(380.dp),
                painter = painterResource(flowerDetail.image),
                contentDescription = flowerDetail.name,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "text-${flowerDetail.name}"),
                        animatedVisibilityScope = animatedContentScope
                    )
                    .paddingFromBaseline(56.dp),
                text = flowerDetail.name.uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = flowerDetail.type, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = flowerDetail.color, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview
@Composable
private fun DefPrev() {


}