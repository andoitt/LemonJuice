package com.example.lemonjuice

import android.app.Application
import android.content.Context

class JuiceApp: Application() {

    lateinit var viewModel: JuiceViewModel

    override fun onCreate() {
        super.onCreate()
        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE
            )
        )
        viewModel = JuiceViewModel(Repository.Base(
            IntCache.Base("currentClicks", permanentStorage,0)
        ))
    }
}