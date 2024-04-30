package com.example.lemonjuice

import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class ButtonUI(

    private val rootId: Int,
    private val parent: Matcher<View>,
) {

    private val actionButton: Int = R.id.actionButton

    private val interaction = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(actionButton),
            ViewMatchers.isAssignableFrom(Button::class.java),
            parent,
            ViewMatchers.withParent(ViewMatchers.withId(rootId)),
        )
    )

    fun click() {
        interaction.perform(androidx.test.espresso.action.ViewActions.click())
    }

    fun checkInitialState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.next)))
    }


    fun checkSqueezeState() {
        interaction.check(matches(ViewMatchers.isNotEnabled()))
            .check(matches(withText(R.string.next)))
    }

    fun checkProcessState() {
        interaction.check(matches((isEnabled())))
            .check(matches(withText(R.string.next)))
    }

    fun checkMadeState() {
        interaction.check(matches((isEnabled())))
            .check(matches(withText(R.string.next)))
    }

    fun checkFinishState() {
        interaction.check(matches(isEnabled()))
            .check(matches(withText(R.string.start_again)))
    }

}
