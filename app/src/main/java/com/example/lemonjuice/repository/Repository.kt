package com.example.lemonjuice.repository

interface Repository {

    fun addCounter()
    fun isMax() : Boolean
    fun reset()

    class Base(
        private val currentTimesClicked: IntCache
      //  private val cache: IntCache

    ): Repository {

      //  private var currentTimesClicked = 0

        override fun addCounter() {

            // cache.save(cache.reade() + 1 )
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
