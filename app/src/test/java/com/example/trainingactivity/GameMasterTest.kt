package com.example.trainingactivity

import com.example.trainingactivity.GameMasterRepository.ButtonValue
import com.example.trainingactivity.GameMasterRepository.PlayerResult
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class GameMasterTest {
    val gameMaster = GameMaster()

    @Test
    fun gameMasterCheckPlayerInputCorrectGame() {
        //given
        val position = 3
        val input = ButtonValue.BLUE
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(position)
        val expected = PlayerResult.CorrectGame
        //when
        val result = gameMaster.checkPlayerInput(position, input)
        //then
        TestCase.assertEquals(expected, result)
    }

    @Test
    fun gameMasterCheckPlayerInputCorrectSequence() {
        //given
        val position = 0
        val input = ButtonValue.RED
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(position)
        val expected = PlayerResult.CorrectSequence
        //when
        val result = gameMaster.checkPlayerInput(position, input)
        //then
        TestCase.assertEquals(expected, result)
    }

    @Test
    fun gameMasterCheckPlayerInputCorrectGuess() {
        //given
        val position = 0
        val input = ButtonValue.RED
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(3)
        val expected = PlayerResult.CorrectGuess
        //when
        val result = gameMaster.checkPlayerInput(position, input)
        //then
        TestCase.assertEquals(expected, result)
    }

    @Test
    fun gameMasterCheckPlayerInputIncorrectGuess() {
        //given
        val position = 0
        val input = ButtonValue.GREEN
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(position)
        val expected = PlayerResult.IncorrectGuess
        //when
        val result = gameMaster.checkPlayerInput(position, input)
        //then
        TestCase.assertEquals(expected, result)
    }

    @Test
    fun gameMasterCheckPlayerInputPositionTooHigh() {
        //given
        val position = 4
        val input = ButtonValue.RED
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(3)
        val expected = "Position Too High"
        //when
        val result = Assert.assertThrows(Exception::class.java) {
            gameMaster.checkPlayerInput(position, input)
        }
        //then
        TestCase.assertEquals(expected, result.message)
    }

    @Test
    fun gameMasterCheckPlayerInputPositionTooLow() {
        //given
        val position = -1
        val input = ButtonValue.RED
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(0)
        val expected = "Position Too Low"
        //when
        val result = Assert.assertThrows(Exception::class.java) {
            gameMaster.checkPlayerInput(position, input)
        }
        //then
        TestCase.assertEquals(expected, result.message)
    }

    @Test
    fun gameMasterCheckPlayerInputPositionInvalid() {
        //given
        val position = 1
        val input = ButtonValue.RED
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(0)
        val expected = "Position Invalid"
        //when
        val result = Assert.assertThrows(Exception::class.java) {
            gameMaster.checkPlayerInput(position, input)
        }
        //then
        TestCase.assertEquals(expected, result.message)
    }

    @Test
    fun gameMasterGetCurrentSequence() {
        //given
        gameMaster.setGameSequence(listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW, ButtonValue.BLUE))
        gameMaster.setPlayerPosition(2)
        val expected = listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.YELLOW)
        //when
        val result = gameMaster.getCurrentSequence()
        //then
        TestCase.assertEquals(expected, result)
    }
}