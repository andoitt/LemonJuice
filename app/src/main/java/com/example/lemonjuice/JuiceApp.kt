package com.example.lemonjuice

import android.app.Application
import android.content.Context
import com.example.lemonjuice.fragmentSqueeze.SqueezeViewModel
import com.example.lemonjuice.main.MainViewModel
import com.example.lemonjuice.repository.IntCache
import com.example.lemonjuice.repository.PermanentStorage
import com.example.lemonjuice.repository.Repository

class JuiceApp : Application() {

    lateinit var mainViewModel: MainViewModel
    lateinit var viewModel: SqueezeViewModel

    override fun onCreate() {
        super.onCreate()
        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE
            )
        )
        viewModel = SqueezeViewModel(
            Repository.Base(
                IntCache.Base("currentClicks", permanentStorage, 0)
            )
        )
    }
}