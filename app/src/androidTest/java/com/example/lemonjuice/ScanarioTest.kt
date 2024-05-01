package com.example.lemonjuice

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
Test Case #1 :  Сorrect step


1. Нажать на кнопку next ,
-> отображается состояние MakeJuice

3. Кликнуть 5 раз по imageButton ,
-> отображается состояние SqueezeState

4. кликнуть кнопку next ,

отображается  ->  SqueezeProcessState,

5. кликнуть кнопку next ,

отображается состояние FinishState


6.кликнуть кнопку next ,

отображается изначальное состояние InitialState


--------------------------------------------------------------------------------------------

 */
@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun caseNumberOne() {
        var juicePage = JuicePage()

        juicePage.checkInitialState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkInitialState()                  // init

        juicePage.clickNext()

        repeat(5) {
            juicePage.checkSqueezeState()
            activityScenarioRule.scenario.recreate()
            juicePage.checkSqueezeState()
            juicePage.clickImage()

        }

        juicePage.checkSqueezeProcessState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkSqueezeProcessState()
        juicePage.clickNext()


        juicePage.checkReadyToMadeState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkReadyToMadeState()
        juicePage.clickNext()


        juicePage.checkFinishState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkFinishState()

        juicePage.clickStartAgain()
        juicePage.checkInitialState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkInitialState()

        juicePage.checkInitialState()
        activityScenarioRule.scenario.recreate()
        juicePage.checkInitialState()

    }
}