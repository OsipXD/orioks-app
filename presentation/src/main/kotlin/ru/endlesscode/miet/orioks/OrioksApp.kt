package ru.endlesscode.miet.orioks

import android.app.Application
import ru.endlesscode.miet.orioks.internal.di.DI

class OrioksApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DI.init(this)
    }
}
