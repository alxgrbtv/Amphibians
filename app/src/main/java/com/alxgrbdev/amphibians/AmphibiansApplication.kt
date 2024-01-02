package com.alxgrbdev.amphibians

import android.app.Application
import com.alxgrbdev.amphibians.data.AppContainer
import com.alxgrbdev.amphibians.data.DefaultAppContainer

class AmphibiansApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}