package ru.endlesscode.miet.orioks.internal.di

import android.annotation.SuppressLint
import android.app.Application
import ru.endlesscode.miet.orioks.internal.di.holder.ApplicationComponentHolder
import ru.endlesscode.miet.orioks.internal.di.holder.MainComponentHolder


@SuppressLint("StaticFieldLeak")
object DI {

    val main: MainComponentHolder get() = app.main

    private val app: ApplicationComponentHolder by lazy { ApplicationComponentHolder(appInstance) }

    private lateinit var appInstance: Application

    fun init(appInstance: Application) {
        DI.appInstance = appInstance
    }
}
