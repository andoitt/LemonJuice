package com.example.lemonjuice.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lemonjuice.JuiceApp
import com.example.lemonjuice.ManageViewModels
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.finish.FinishNavigation
import com.example.lemonjuice.presentation.finish.FinishScreen
import com.example.lemonjuice.presentation.initial.InitialNavigation
import com.example.lemonjuice.presentation.initial.InitialScreen
import com.example.lemonjuice.presentation.made.MadeScreen
import com.example.lemonjuice.presentation.made.MadeNavigation
import com.example.lemonjuice.presentation.squeeze.SqueezeNavigation
import com.example.lemonjuice.presentation.squeeze.SqueezeScreen

class MainActivity : AppCompatActivity(), Navigation , ManageViewModels {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val viewModel = (application as JuiceApp).mainViewModel

        val viewModel = viewModel(MainViewModel::class.java)

        val lastScreen = viewModel.init(savedInstanceState == null)
        navigate(lastScreen)

    }

    override fun navigate(screen: Screen) {
        screen.show(R.id.container, supportFragmentManager)
    }

    override fun clear(clazz: Class<out MyViewModel>) {
        (application as ManageViewModels).clear(clazz)
    }

    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return (application as ManageViewModels).viewModel(clazz)
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






