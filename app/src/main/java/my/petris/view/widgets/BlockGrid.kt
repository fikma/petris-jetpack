package my.petris.view.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.petris.BlockGridViewModel
import my.petris.ui.theme.PetrisTheme
import my.petris.view.Block

@Composable
fun BlockGrid(
    viewModel: BlockGridViewModel = viewModel(),
    modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .width((viewModel.xCount * viewModel.blockSize).dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(10),
            horizontalArrangement = Arrangement.Center,
            content = {
                for (item in viewModel.blocks.value!!) {
                    item {
                        Block(color = item.color, size = viewModel.blockSize.dp)
                    }
                }
            },
            modifier = Modifier.width((viewModel.xCount * viewModel.blockSize).dp)
        )
    }

}

@Preview(widthDp = 320)
@Composable
fun BlockGridPrev() {
    PetrisTheme {
        BlockGrid(viewModel = BlockGridViewModel())
    }
}
