package com.example.trainingactivity

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.trainingactivity.GameMasterRepository.ButtonValue
import com.example.trainingactivity.MainViewModel.HighlightedButtonState
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var testGameMasterRepository: TestGameMasterRepository

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        testGameMasterRepository = TestGameMasterRepository()
        viewModel = MainViewModel(testGameMasterRepository, TestTrainingLogger())
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun checkPlayerInputCorrectGuess() {
        //given
        val testPosition = 0
        val correctGuess = ButtonValue.RED
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.CorrectGuess
        //then
        assertEquals(0, viewModel.getPlayerPosition())
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(1, viewModel.getPlayerPosition())
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(2, viewModel.getPlayerPosition())
    }

    @Test
    fun checkPlayerInputCorrectGame() {
        //given
        val correctGuess = ButtonValue.RED
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.CorrectGame
        val expectedStateStart = HighlightedButtonState.None
        val expectedStateEnd = HighlightedButtonState.AllHighlighted
        //then
        assertEquals(expectedStateStart, viewModel.highlightedButtonStateLiveData.value)
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(expectedStateEnd, viewModel.highlightedButtonStateLiveData.value)
    }

    @Test
    fun checkPlayerInputCorrectSequence() = runTest {
        //given
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.CorrectGuess
        val correctGuess = ButtonValue.RED
        //then
        assertEquals(0, viewModel.getPlayerPosition())
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(1, viewModel.getPlayerPosition())
        //given
        testGameMasterRepository.expectedSequence = listOf(ButtonValue.RED, ButtonValue.GREEN, ButtonValue.BLUE, ButtonValue.YELLOW)
        val expectedSequenceList = listOf(
            HighlightedButtonState.None,
            HighlightedButtonState.RedHighlighted,
            HighlightedButtonState.None,
            HighlightedButtonState.GreenHighlighted,
            HighlightedButtonState.None,
            HighlightedButtonState.BlueHighlighted,
            HighlightedButtonState.None,
            HighlightedButtonState.YellowHighlighted,
            HighlightedButtonState.None,
        )
        val actualSequenceList: MutableList<HighlightedButtonState> = mutableListOf()
        viewModel.highlightedButtonStateLiveData.observeForever() {
            actualSequenceList.add(it)
        }
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.CorrectSequence
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(0, viewModel.getPlayerPosition())
        //delay(10000)
        advanceUntilIdle()
        assertEquals(expectedSequenceList, actualSequenceList)
    }

    @Test
    fun checkPlayerInputIncorrectGuess() = runTest {
        //given
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.CorrectGuess
        val correctGuess = ButtonValue.RED
        //then
        assertEquals(0, viewModel.getPlayerPosition())
        //when
        viewModel.checkPlayerInput(correctGuess)
        //then
        assertEquals(1, viewModel.getPlayerPosition())
        //given
        val expectedSequenceList = listOf(
            HighlightedButtonState.None,
            HighlightedButtonState.RedHighlighted,
            HighlightedButtonState.None,
            HighlightedButtonState.GreenHighlighted,
            HighlightedButtonState.None,
        )
        val actualSequenceList: MutableList<HighlightedButtonState> = mutableListOf()
        viewModel.highlightedButtonStateLiveData.observeForever() {
            actualSequenceList.add(it)
        }
        testGameMasterRepository.expectedPlayerResult = GameMasterRepository.PlayerResult.IncorrectGuess
        val incorrectGuess = ButtonValue.GREEN
        //when
        viewModel.checkPlayerInput(incorrectGuess)
        //then
        assertEquals(0, viewModel.getPlayerPosition())
        //delay(10000)
        advanceUntilIdle()
        assertEquals(expectedSequenceList, actualSequenceList)
    }

    @Test
    fun startViewTest() = runTest {
        //given
        val expectedSequenceList = listOf(
            HighlightedButtonState.None,
            HighlightedButtonState.RedHighlighted,
            HighlightedButtonState.None,
            HighlightedButtonState.GreenHighlighted,
            HighlightedButtonState.None,
        )
        val actualSequenceList: MutableList<HighlightedButtonState> = mutableListOf()
        viewModel.highlightedButtonStateLiveData.observeForever() {
            actualSequenceList.add(it)
        }
        //when
        viewModel.startView()
        //then
        //delay(10000)
        advanceUntilIdle()
        assertEquals(expectedSequenceList, actualSequenceList)
    }
}