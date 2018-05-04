package ru.endlesscode.miet.orioks.internal.di.component

import dagger.Component
import ru.endlesscode.github.internal.di.ApplicationScope
import ru.endlesscode.github.internal.di.module.ContextModule
import ru.endlesscode.miet.orioks.internal.di.module.NavigationModule


@ApplicationScope
@Component(modules = [NavigationModule::class, ContextModule::class])
interface ApplicationComponent {

    fun mainComponent(): MainComponent.Builder
}
