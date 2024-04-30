package com.example.lemonjuice

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class TextUI(
    private val rootId: Int,
    private val parent: Matcher<View>,
) {


    private val interaction = Espresso.onView(
        Matchers.allOf(
            withId(R.id.textView),
            ViewMatchers.isAssignableFrom(TextView::class.java),
            parent,
            ViewMatchers.withParent(withId(rootId)),
        )
    )

    fun checkInitialState() {
        interaction.check(matches(isDisplayed()))
            .check(matches(withText(R.string.hint_select_lemon)))
    }

    fun checkSqueezeState() {
        interaction.check(matches(withText(R.string.squeeze_lemon)))
    }
    fun checkProcessState() {
        interaction.check(matches(withText(R.string.squeeze_lemon)))
    }

    fun checkMadeState() {
        interaction.check(matches(withText(R.string.hint_drink)))
    }

    fun checkFinishState() {
        interaction.check(matches(withText(R.string.hint_start_again)))
    }


}
