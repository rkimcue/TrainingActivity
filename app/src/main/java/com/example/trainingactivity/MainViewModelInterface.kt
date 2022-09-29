package com.example.trainingactivity

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class MainViewModelInterface: ViewModel() {
    abstract val textviewStateLiveData: LiveData<String>
    abstract val highlightedButtonStateLiveData: LiveData<HighlightedButtonState>
    abstract fun startView()
    abstract fun checkPlayerInput(guess: GameMasterRepository.ButtonValue)

    enum class HighlightedButtonState {
        None,
        RedHighlighted,
        GreenHighlighted,
        YellowHighlighted,
        BlueHighlighted,
        AllHighlighted,
    }
}