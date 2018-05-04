package ru.endlesscode.miet.orioks.internal.di.component

import dagger.Subcomponent
import ru.endlesscode.github.internal.di.MainScope
import ru.endlesscode.miet.orioks.presentation.main.activity.MainActivity
import ru.endlesscode.miet.orioks.presentation.main.fragment.MainMenuFragment
import ru.endlesscode.miet.orioks.presentation.main.fragment.StudentsFragment
import ru.endlesscode.miet.orioks.presentation.subjects.fragment.SubjectFragment
import ru.endlesscode.miet.orioks.presentation.subjects.fragment.SubjectsFragment


@MainScope
@Subcomponent
interface MainComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: SubjectsFragment)
    fun inject(fragment: MainMenuFragment)
    fun inject(fragment: StudentsFragment)
    fun inject(fragment: SubjectFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainComponent
    }
}
