package ru.a_party

import android.app.Application

class App: Application() {

    companion object {
        var demoData = DemoData()
    }

    override fun onCreate() {
        super.onCreate()
        demoData.createDemoData()
    }
}