package com.example.trainingactivity


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityEspressoTest() {
        onView(withId(R.id.textview))
            .check(matches(withText("Welcome to Simon!")))

        //first sequence
        onView(withId(R.id.button_third)).perform(click())

        //second sequence
        onView(withId(R.id.button_third)).perform(click())

        onView(withId(R.id.button_third)).perform(click())

        //third sequence
        onView(withId(R.id.button_third)).perform(click())

        onView(withId(R.id.button_third)).perform(click())

        onView(withId(R.id.button_first)).perform(click())

        //fourth sequence
        onView(withId(R.id.button_third)).perform(click())

        onView(withId(R.id.button_third)).perform(click())

        onView(withId(R.id.button_first)).perform(click())

        onView(withId(R.id.button_second)).perform(click())



        onView(withId(R.id.textview))
            .check(matches(withText("You win!")))
    }

//    private fun childAtPosition(
//        parentMatcher: Matcher<View>, position: Int
//    ): Matcher<View> {
//
//        return object : TypeSafeMatcher<View>() {
//            override fun describeTo(description: Description) {
//                description.appendText("Child at position $position in parent ")
//                parentMatcher.describeTo(description)
//            }
//
//            public override fun matchesSafely(view: View): Boolean {
//                val parent = view.parent
//                return parent is ViewGroup && parentMatcher.matches(parent)
//                        && view == parent.getChildAt(position)
//            }
//        }
//    }
}
