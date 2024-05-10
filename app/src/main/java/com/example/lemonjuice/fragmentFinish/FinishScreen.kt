package com.example.lemonjuice.fragmentInitial

import androidx.fragment.app.Fragment
import com.example.lemonjuice.fragmentFinish.FinishFragment
import com.example.lemonjuice.main.Screen

object FinishScreen: Screen.Replace() {
    override fun fragment(): Fragment {
        return FinishFragment()
    }
}