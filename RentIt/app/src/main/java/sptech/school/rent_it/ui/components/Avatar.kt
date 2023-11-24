package sptech.school.rent_it.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Avatar(
    drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        painter = painterResource(id = drawableResource),
        contentDescription = description
    )
}