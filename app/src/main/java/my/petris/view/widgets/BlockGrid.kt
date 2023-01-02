package my.petris.view.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.petris.ui.theme.PetrisTheme
import my.petris.view.Block

@Composable
fun BlockGrid(modifier: Modifier = Modifier) {
    val list = (1..200).map { it.toString() }
    Box(modifier = Modifier.width((10 * 20).dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(10),
            contentPadding = PaddingValues(0.dp),
            horizontalArrangement = Arrangement.Center,
            content = {
                items(list.size) { index ->
                    Block(color = MaterialTheme.colors.primary, size = 20.dp)

                }
            },
            modifier = Modifier.width((10 * 20).dp)
        )
    }

}

@Preview(widthDp = 320)
@Composable
fun BlockGridPrev() {
    PetrisTheme {
        BlockGrid()
    }
}
