package com.example.lemonjuice.fragmentInitial

import androidx.fragment.app.Fragment
import com.example.lemonjuice.main.Screen

object InitialScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return InitialFragment()
    }
}