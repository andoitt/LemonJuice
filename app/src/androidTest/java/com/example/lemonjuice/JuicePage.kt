package com.example.lemonjuice

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom

class JuicePage() {

    private val rootId = R.id.rootLayout
    private val parent = ViewMatchers.withParent(isAssignableFrom(LinearLayout::class.java))


    private val imageUI = ImageUI(rootId, parent)
    private val buttonUI = ButtonUI(rootId, parent)
    private val textUI = TextUI(rootId, parent)


    fun checkInitialState() {
        imageUI.checkInitState()
        buttonUI.checkInitState()
        textUI.checkInitState()
    }


    fun clickNext() {
        buttonUI.click()
    }

    fun clickImage() {
      //  buttonUI.click()
        textUI.click()

    }

    fun clickStartAgain() {
        buttonUI.click()
    }

    fun checkSqueezeState() {
        imageUI.checkSqueezeState()
        buttonUI.checkSqueezeState()
        textUI.checkSqueezeState()

    }

    fun checkSqueezeProcessState() {
        imageUI.checkProcessState()
        buttonUI.checkProcessState()
        textUI.checkProcessState()
    }

    fun checkReadyToMadeState() {
        buttonUI.checkMadeState()
        textUI.checkMadeState()
        imageUI.checkMadeState()

    }
    fun checkFinishState() {
        imageUI.checkFinishState()
        buttonUI.checkFinishState()
        textUI.checkFinishState()
    }

}
