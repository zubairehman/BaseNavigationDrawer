package com.zubair.basenavigationdrawer

import android.app.Application
import android.content.Context

class ApplicationController : Application() {
    protected var mUserAgent: String? = null

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {

        var appContext: Context? = null
            private set
    }

}
