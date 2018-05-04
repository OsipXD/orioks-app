package ru.endlesscode.miet.orioks.internal.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


@Module(includes = [LocalNavigationModule::class])
object NavigationModule {

    private var cicerone: Cicerone<Router> = Cicerone.create()

    @JvmStatic
    @Provides
    fun provideNavigationHolder(): NavigatorHolder = cicerone.navigatorHolder

    @JvmStatic
    @Provides
    fun provideRouter(): Router = cicerone.router
}
