package my.petris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import my.petris.ui.theme.PetrisTheme
import my.petris.view.GameScreen

class MainActivity : ComponentActivity() {
    private val blockGridVM: BlockGridViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        blockGridVM.gameLoopFunction = {
            runOnUiThread {
                blockGridVM.changeColor()
            }
        }

        setContent {
            PetrisTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GameScreen()
                }
            }
        }
    }
}
