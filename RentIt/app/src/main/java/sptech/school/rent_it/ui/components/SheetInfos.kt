package sptech.school.rent_it.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sptech.school.rent_it.ui.theme.typography

@Composable
fun SheetInfos(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier) {
        Text(
            text = title,
            style = typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = text,
            style = typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }

}