package com.example.lemonjuice

import android.content.SharedPreferences

interface Repository {

    fun addCounter()
    fun isMax() : Boolean
    fun reset()

    class Base(
        private val currentTimesClicked: IntCache
    ):  Repository {


      //  private var currentTimesClicked = 0

        override fun addCounter() {
            val currentClicks = currentTimesClicked.read()
            val newClicks = currentClicks + 1
            currentTimesClicked.save(newClicks)

        }
        override fun isMax() : Boolean {
            return currentTimesClicked.read() == 5
        }

        override fun reset() {
            currentTimesClicked.save(0)
        }
    }
}
