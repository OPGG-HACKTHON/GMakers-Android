package com.example.gmakers_android

import android.app.Application
import android.content.Context

class MainApplication: Application() {
    init {
        instance = this
    }
    companion object {
        private var instance: MainApplication? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }
}