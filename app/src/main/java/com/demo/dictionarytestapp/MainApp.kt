package com.demo.dictionarytestapp

import android.app.Application
import com.demo.dictionarytestapp.network.translation.NetworkTranslationHelper

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkTranslationHelper.init(applicationContext)
    }
}