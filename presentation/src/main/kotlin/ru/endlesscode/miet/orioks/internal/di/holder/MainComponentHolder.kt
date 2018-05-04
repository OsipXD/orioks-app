package ru.endlesscode.miet.orioks.internal.di.holder

import ru.endlesscode.miet.orioks.internal.di.holder.common.SubComponentHolder
import ru.endlesscode.miet.orioks.internal.di.component.ApplicationComponent
import ru.endlesscode.miet.orioks.internal.di.component.MainComponent


class MainComponentHolder(
    parent: ApplicationComponentHolder
) : SubComponentHolder<MainComponent, ApplicationComponent>(parent) {

    override fun provideInternal(parentComponent: ApplicationComponent): MainComponent {
        return parentComponent.mainComponent().build()
    }
}
