package com.example.lemonjuice.presentation.initial

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.main.Screen

object InitialScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return InitialFragment()
    }
}