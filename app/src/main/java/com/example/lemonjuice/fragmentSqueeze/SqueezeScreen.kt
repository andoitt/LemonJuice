package com.example.lemonjuice.fragmentSqueeze

import androidx.fragment.app.Fragment
import com.example.lemonjuice.main.Screen

object SqueezeScreen : Screen.Replace() {
    override fun fragment(): Fragment {
        return SqueezeFragment()
    }

}
