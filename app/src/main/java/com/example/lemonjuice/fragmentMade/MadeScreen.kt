package com.example.lemonjuice.fragmentInitial

import androidx.fragment.app.Fragment
import com.example.lemonjuice.fragmentMade.MadeFragment
import com.example.lemonjuice.main.Screen

object MadeScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return MadeFragment()
    }
}