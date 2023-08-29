package com.example.ticmasproject

// MainActivityTest.kt
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import com.example.ticmasproject.MainActivity

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun clickingCompare_ChangesResultText() {
        onView(withId(R.id.editText1)).perform(typeText("Hola"))
        onView(withId(R.id.editText2)).perform(typeText("Hola"))
        onView(withId(R.id.compareButton)).perform(click())

        onView(withId(R.id.resultText)).check(matches(withText("Las cadenas son iguales")))
    }
}
