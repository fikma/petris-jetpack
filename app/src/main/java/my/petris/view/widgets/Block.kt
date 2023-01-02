package my.petris.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import my.petris.ui.theme.PetrisTheme

@Composable
fun Block(
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,) {
    Box(modifier = Modifier.size(size)) {
        Surface(color = color) {
            Box(modifier = Modifier.size(size))
        }
    }
}

@Preview(widthDp = 320)
@Composable
fun BlockWigetPreview() {
    PetrisTheme() {
        Block(color = MaterialTheme.colors.primary, size = 20.dp)
    }
}