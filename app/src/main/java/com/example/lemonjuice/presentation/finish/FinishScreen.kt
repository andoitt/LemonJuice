package com.example.lemonjuice.presentation.finish

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.main.Screen

object FinishScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return FinishFragment()
    }
}