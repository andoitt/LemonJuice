package com.example.lemonjuice.data

import com.example.lemonjuice.presentation.main.Screen

interface MainRepository {

    fun lastSavedScreen(): Screen


    class Base(
        private val lastScreen: StringCache
    ): MainRepository{
        override fun lastSavedScreen(): Screen {
            val string = lastScreen.read()
            return Class.forName(string).getDeclaredConstructor().newInstance() as Screen
        }
    }
}