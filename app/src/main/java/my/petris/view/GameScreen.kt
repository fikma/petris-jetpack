package my.petris.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import my.petris.ui.theme.PetrisTheme
import my.petris.view.widgets.BlockGrid

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BlockGrid()
    }
}

@Preview(widthDp = 320)
@Composable
fun GameScreenPrev() {
    PetrisTheme {
        GameScreen()
    }
}