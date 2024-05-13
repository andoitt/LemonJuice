package com.example.lemonjuice.presentation.main

import com.example.lemonjuice.data.MainRepository

class MainViewModel(
    private val mainRepository: MainRepository
) : MyViewModel{

    fun init(isFirstRun: Boolean): Screen {
        return if (isFirstRun)
            mainRepository.lastSavedScreen()
            else
            Screen.Empty
    }
}

interface MyViewModel