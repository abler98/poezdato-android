package net.poezdato.android.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.poezdato.android.view.timetable.TimetableActivity
import net.poezdato.android.view.timetable.TimetableFragment
import net.poezdato.android.view.timetable.TimetableModule

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeTimetableActivityInjector(): TimetableActivity

    @ContributesAndroidInjector(modules = [TimetableModule::class])
    abstract fun contributeTimetableFragmentInjector(): TimetableFragment

}
