package com.example.lemonjuice.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lemonjuice.JuiceApp
import com.example.lemonjuice.R
import com.example.lemonjuice.fragmentFinish.FinishNavigation
import com.example.lemonjuice.fragmentInitial.FinishScreen
import com.example.lemonjuice.fragmentInitial.InitialFragment
import com.example.lemonjuice.fragmentInitial.InitialNavigation
import com.example.lemonjuice.fragmentInitial.InitialScreen
import com.example.lemonjuice.fragmentInitial.MadeScreen
import com.example.lemonjuice.fragmentMade.MadeNavigation
import com.example.lemonjuice.fragmentSqueeze.SqueezeFragment
import com.example.lemonjuice.fragmentSqueeze.SqueezeNavigation
import com.example.lemonjuice.fragmentSqueeze.SqueezeScreen

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*   if (savedInstanceState == null) {
               navigate(InitialFragment())
           }*/

        val viewModel = (application as JuiceApp).mainViewModel

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)

    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }

}

interface Navigation : SqueezeNavigation, InitialNavigation, MadeNavigation, FinishNavigation {
    fun navigate(screen: Screen)

    override fun navigateFromSqueezeScreen() {
        navigate(SqueezeScreen)
    }

    override fun navigateFromInitialScreen() {
        navigate(InitialScreen)
    }

    override fun navigateFromMadeScreen() {
        navigate(MadeScreen)
    }

    override fun navigateFromFinishScreen() {
        navigate(FinishScreen)
    }
}

interface Screen {

    fun show(containerId: Int, fragmentManager: FragmentManager) = Unit

    object Empty : Screen

    abstract class Replace : Screen {

        abstract fun fragment(): Fragment

        override fun show(containerId: Int, fragmentManager: FragmentManager) {
            fragmentManager.beginTransaction()
                .replace(containerId, fragment())
                .commit()
        }
    }
}






