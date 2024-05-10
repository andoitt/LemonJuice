package com.example.lemonjuice.main

import com.example.lemonjuice.repository.MainRepository
import com.example.lemonjuice.repository.Repository

class MainViewModel(
    private val mainRepository: MainRepository
) {

    fun init(isFirstRun: Boolean): Screen {
        return if (isFirstRun)
            mainRepository.lastSavedScreen()
            else
                Screen.Empty
    }
}