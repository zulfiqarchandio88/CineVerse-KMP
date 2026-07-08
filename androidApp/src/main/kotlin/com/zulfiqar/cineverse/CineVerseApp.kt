package com.zulfiqar.cineverse

import android.app.Application
import com.zulfiqar.cineverse.di.initKoin

class CineVerseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}