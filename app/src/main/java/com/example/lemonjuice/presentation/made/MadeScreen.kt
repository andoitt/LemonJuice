package com.example.lemonjuice.presentation.made

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.main.Screen

object MadeScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return MadeFragment()
    }
}