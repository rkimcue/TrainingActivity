package com.example.trainingactivity

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.util.Log.d
import android.widget.Button
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingactivity.GameMasterRepository.ButtonValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val gameMaster: GameMasterRepository = GameMaster(),
    private val trainingLogger: TrainingLogger = AndroidLogger(),
): MainViewModelInterface() {
    private val textviewStateMutableLiveData = MutableLiveData<String>("Welcome to Simon!")
    override val textviewStateLiveData: LiveData<String> = textviewStateMutableLiveData
    private var playerPosition = 0
    private val highlightedButtonStateMutableLiveData = MutableLiveData<MainViewModelInterface.HighlightedButtonState>(
        MainViewModelInterface.HighlightedButtonState.None)
    override val highlightedButtonStateLiveData: LiveData<MainViewModelInterface.HighlightedButtonState> = highlightedButtonStateMutableLiveData

    private suspend fun animateSequence() {
        val sequence = gameMaster.getCurrentSequence()
        trainingLogger.d("mainActivity", "Sequence $sequence")
        sequence.forEach { item ->
            when (item) {
                ButtonValue.RED -> animateCurrentButton(MainViewModelInterface.HighlightedButtonState.RedHighlighted)
                ButtonValue.GREEN -> animateCurrentButton(MainViewModelInterface.HighlightedButtonState.GreenHighlighted)
                ButtonValue.YELLOW -> animateCurrentButton(MainViewModelInterface.HighlightedButtonState.YellowHighlighted)
                ButtonValue.BLUE -> animateCurrentButton(MainViewModelInterface.HighlightedButtonState.BlueHighlighted)
            }
            delay(500)
        }
    }
    private suspend fun animateCurrentButton(buttonState: MainViewModelInterface.HighlightedButtonState) {
        trainingLogger.d("MainActivity", "Animate Button")
        highlightedButtonStateMutableLiveData.postValue(buttonState)
        delay(1000)
        highlightedButtonStateMutableLiveData.postValue(MainViewModelInterface.HighlightedButtonState.None)
        trainingLogger.d("MainActivity", "Return to Original Color")
    }
    override fun startView() {
        viewModelScope.launch {
            delay(3000)
            animateSequence()
        }
    }

    override fun checkPlayerInput(guess: ButtonValue) {
        val guessResult = gameMaster.checkPlayerInput(playerPosition, guess)
        textviewStateMutableLiveData.value = guessResult.value

        when (guessResult) {
            GameMasterRepository.PlayerResult.CorrectGuess -> playerPosition++
            GameMasterRepository.PlayerResult.CorrectSequence -> {
                playerPosition = 0
                viewModelScope.launch {
                    delay(500)
                    animateSequence()
                }
            }
            GameMasterRepository.PlayerResult.CorrectGame -> {
                highlightedButtonStateMutableLiveData.value = MainViewModelInterface.HighlightedButtonState.AllHighlighted
            }
            GameMasterRepository.PlayerResult.IncorrectGuess -> {
                playerPosition = 0
                viewModelScope.launch {
                    delay(500)
                    animateSequence()
                }
            }
        }
    }

    @VisibleForTesting
    fun getPlayerPosition() = playerPosition

}