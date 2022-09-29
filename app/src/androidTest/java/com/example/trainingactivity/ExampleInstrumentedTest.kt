package com.example.trainingactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.trainingactivity", appContext.packageName)
    }
    @Test
    fun testInitialViewState() {
        launchActivity<MainActivity>().use {
            onView(withId(R.id.textview))
                .check(matches(withText("Welcome to Simon!")))
//            onView(withId(R.id.button_first)).perform(click())
//            onView(allOf(withId(R.id.button_first), hasBackground(R.drawable.ic_button_red)))
//                .check(matches(isDisplayed()))
//            onView(withId(R.id.button_first)).check { view, noViewFoundException ->
//                val background = view.background
//                val expectedBackground = view.context.getDrawable(R.drawable.ic_button_red)
//                assertEquals(expectedBackground, background)
//            }
            onView(withId(R.id.button_first))
                .check(matches(hasBackground(R.drawable.ic_button_red)))
            onView(withId(R.id.button_second))
                .check(matches(hasBackground(R.drawable.ic_button_green)))
            onView(withId(R.id.button_third))
                .check(matches(hasBackground(R.drawable.ic_button_yellow)))
            onView(withId(R.id.button_fourth))
                .check(matches(hasBackground(R.drawable.ic_button_blue)))

        }
    }
    @Test
    fun testClickButtonOneIsRedGuess() {
        //given
        val testViewModel = TestViewModel()
        val expectedGuesses = listOf(
            GameMasterRepository.ButtonValue.RED
        )
        ViewModelFactoryProducer.setTestFactory(TestFactory(testViewModel))
        launchActivity<MainActivity>().use {
            //when
            onView(withId(R.id.button_first)).perform(click())
            //then
            assertEquals(expectedGuesses, testViewModel.playerGuesses)
        }
    }
    @Test
    fun testClickButtonTwoIsGreenGuess() {
        //given
        val testViewModel = TestViewModel()
        val expectedGuesses = listOf(
            GameMasterRepository.ButtonValue.GREEN
        )
        ViewModelFactoryProducer.setTestFactory(TestFactory(testViewModel))
        launchActivity<MainActivity>().use {
            //when
            onView(withId(R.id.button_second)).perform(click())
            //then
            assertEquals(expectedGuesses, testViewModel.playerGuesses)
        }
    }
    @Test
    fun testClickButtonThreeIsYellowGuess() {
        //given
        val testViewModel = TestViewModel()
        val expectedGuesses = listOf(
            GameMasterRepository.ButtonValue.YELLOW
        )
        ViewModelFactoryProducer.setTestFactory(TestFactory(testViewModel))
        launchActivity<MainActivity>().use {
            //when
            onView(withId(R.id.button_third)).perform(click())
            //then
            assertEquals(expectedGuesses, testViewModel.playerGuesses)
        }
    }
    @Test
    fun testClickButtonFourIsBlueGuess() {
        //given
        val testViewModel = TestViewModel()
        val expectedGuesses = listOf(
            GameMasterRepository.ButtonValue.BLUE
        )
        ViewModelFactoryProducer.setTestFactory(TestFactory(testViewModel))
        launchActivity<MainActivity>().use {
            //when
            onView(withId(R.id.button_fourth)).perform(click())
            //then
            assertEquals(expectedGuesses, testViewModel.playerGuesses)
        }
    }
}
class TestFactory(val testViewModel: TestViewModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass, CreationExtras.Empty)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (MainViewModelInterface::class.java.isAssignableFrom(modelClass)) {
            return testViewModel as T
        }
        return super.create(modelClass, extras)
    }
}
class TestViewModel: MainViewModelInterface() {
    override val textviewStateLiveData: LiveData<String>
        get() = MutableLiveData()
    override val highlightedButtonStateLiveData: LiveData<HighlightedButtonState>
        get() = MutableLiveData()
    val playerGuesses = mutableListOf<GameMasterRepository.ButtonValue>()
    override fun startView() {

    }

    override fun checkPlayerInput(guess: GameMasterRepository.ButtonValue) {
        playerGuesses.add(guess)
    }
}