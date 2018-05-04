package ru.endlesscode.github.internal.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.endlesscode.miet.orioks.internal.di.module.RxModule


@Module(includes = [RxModule::class])
class ContextModule(private val app: Application) {

    @Provides
    fun provideAppContext(): Context = app
}
