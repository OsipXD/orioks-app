package ru.endlesscode.miet.orioks.internal.di.module

import dagger.Module
import dagger.Provides
import ru.endlesscode.miet.orioks.internal.di.MainScope
import ru.endlesscode.miet.orioks.internal.Screens
import ru.endlesscode.miet.orioks.internal.di.Local
import ru.endlesscode.miet.orioks.presentation.common.navigation.LocalCiceroneHolder
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
object MainMenuNavigationModule {

    @JvmStatic
    @Provides
    @Local
    @MainScope
    fun provideLocalCicerone(localCiceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return localCiceroneHolder.getCicerone(Screens.MAIN_MENU)
    }
}
