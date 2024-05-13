package com.example.lemonjuice.presentation.squeeze

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.main.Screen

object SqueezeScreen : Screen.Replace() {
    override fun fragment(): Fragment {
        return SqueezeFragment()
    }

}
