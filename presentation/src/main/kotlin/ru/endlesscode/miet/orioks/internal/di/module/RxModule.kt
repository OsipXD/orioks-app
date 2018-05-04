package ru.endlesscode.miet.orioks.internal.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers


@Module
object RxModule {

    @JvmStatic
    @Provides
    fun provideMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
