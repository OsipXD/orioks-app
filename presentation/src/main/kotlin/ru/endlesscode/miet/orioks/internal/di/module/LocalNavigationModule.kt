package ru.endlesscode.miet.orioks.internal.di.module

import dagger.Module
import dagger.Provides
import ru.endlesscode.miet.orioks.presentation.common.navigation.LocalCiceroneHolder

@Module
object LocalNavigationModule {

    private val localCiceroneHolder by lazy { LocalCiceroneHolder() }

    @JvmStatic
    @Provides
    fun provideLocalCiceroneHolder(): LocalCiceroneHolder = localCiceroneHolder
}
