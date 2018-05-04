package ru.endlesscode.miet.orioks.internal.di.module

import dagger.*
import ru.endlesscode.miet.orioks.presentation.common.navigation.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Named

@Module
object LocalNavigationModule {

    private val localCiceroneHolder = LocalCiceroneHolder()

    @JvmStatic
    @Provides
    fun provideLocalNavigationHolder(): LocalCiceroneHolder = localCiceroneHolder
}
