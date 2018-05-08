package ru.endlesscode.miet.orioks.internal.di.holder

import android.app.Application
import ru.endlesscode.miet.orioks.internal.di.module.ContextModule
import ru.endlesscode.miet.orioks.internal.di.holder.common.ComponentHolder
import ru.endlesscode.miet.orioks.internal.di.component.ApplicationComponent
import ru.endlesscode.miet.orioks.internal.di.component.DaggerApplicationComponent


class ApplicationComponentHolder(private val app: Application) : ComponentHolder<ApplicationComponent>() {

    val main: MainComponentHolder by lazy { MainComponentHolder(this) }

    override fun provideInternal(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .contextModule(ContextModule(app))
            .build()
    }
}
