package com.example.lemonjuice

import android.view.View
import android.widget.ImageButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not

class ImageUI(
     rootId: Int,
     parent: Matcher<View>,
) {


    private val interaction = Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(R.id.pictureImageButton),
            ViewMatchers.isAssignableFrom(ImageButton::class.java),
            parent,
            ViewMatchers.withParent(withId(rootId)),
        )
    )

  fun checkInitialState() {
      interaction.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
          .check(ViewAssertions.matches(not(ViewMatchers.isClickable())))
          .check(ViewAssertions.matches(DrawableMatcher(R.drawable.tree)))   // отображение pict tree
  }


    fun checkSqueezeState() {
        interaction.check(ViewAssertions.matches(ViewMatchers.isClickable()))
            .check(ViewAssertions.matches(DrawableMatcher(R.drawable.lemon)))

    }

    fun checkProcessState() {
        interaction.check(ViewAssertions.matches(not(ViewMatchers.isClickable())))
            .check(ViewAssertions.matches(DrawableMatcher(R.drawable.lemon)))
    }

    fun checkMadeState() {
        interaction.check(ViewAssertions.matches(not(ViewMatchers.isClickable())))
            .check(ViewAssertions.matches(DrawableMatcher(R.drawable.lemonade)))
    }

    fun checkFinishState() {
        interaction.check(ViewAssertions.matches(not(ViewMatchers.isClickable())))
            .check(ViewAssertions.matches(DrawableMatcher(R.drawable.glass)))
    }

    fun click() {
        interaction.perform(ViewActions.click())
    }

}
