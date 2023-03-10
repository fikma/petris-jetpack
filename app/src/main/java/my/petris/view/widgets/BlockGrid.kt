package my.petris.view.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
    modifier: Modifier = Modifier)
{
    val list by viewModel.blocks.observeAsState()

    Box(modifier = Modifier
        .width((viewModel.xCount * viewModel.blockSize).dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(10),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            content = {
                for (blockState in list!!) {
                    item {
                        Block(color = blockState.color, size = viewModel.blockSize.dp)
                    }
                }
            }
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
