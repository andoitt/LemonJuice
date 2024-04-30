package com.example.lemonjuice

interface Repository {

    fun addCounter()
    fun isMax() : Boolean
    fun reset()

    class Base(): Repository {
        private var currentTimesClicked = 0

        override fun addCounter() {
            currentTimesClicked++

        }
        override fun isMax() : Boolean {
            return currentTimesClicked == 5
        }

        override fun reset() {
            currentTimesClicked = 0
        }
    }
}