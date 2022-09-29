package com.example.trainingactivity

import com.example.trainingactivity.GameMasterRepository.ButtonValue

class TestGameMasterRepository: GameMasterRepository {
    var expectedPlayerResult: GameMasterRepository.PlayerResult? = null
    var expectedSequence: List<ButtonValue> = listOf(ButtonValue.RED, ButtonValue.GREEN)
    override fun checkPlayerInput(
        position: Int,
        input: ButtonValue
    ): GameMasterRepository.PlayerResult {
        return expectedPlayerResult!!
    }

    override fun getCurrentSequence(): List<ButtonValue> {
        return expectedSequence
    }
}