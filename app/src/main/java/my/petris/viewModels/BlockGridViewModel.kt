package my.petris

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.timer


data class BlockState(
    val x: Int,
    val y: Int,
    var color: Color
)

class BlockGridViewModel : ViewModel() {
    val xCount:Int = 10
    val yCount:Int = 20
    val blockSize: Int = 30

    private var _blocks:MutableLiveData<MutableList<BlockState>> = MutableLiveData()
    val blocks: LiveData<MutableList<BlockState>> = _blocks
    lateinit var gameLoop: Timer

    lateinit var gameLoopFunction: TimerTask.() -> Unit

    var _toggler: Boolean = false

    init {
        _blocks.value = initBlocks(xCount, yCount, Color.Red)
    }

    fun initBlocks(x: Int, y: Int, color: Color = Color.Black) : MutableList<BlockState> {
        var result = mutableListOf<BlockState>()
        for (i in 0..x-1) {
            for (j in 0..y-1) {
                result.add(BlockState(i, j, color))
            }
        }
        return result
    }

    fun pauseGameLoop() {
        gameLoop.cancel()
    }

    fun resumeGameLoop() {
        gameLoop = timer("gameLoop", false, 1000, 1000, gameLoopFunction)
    }

    fun changeColor() {
        _blocks.value = initBlocks(xCount, yCount, if (_toggler) Color.Black else Color.Red)
        _toggler = !_toggler
    }
}