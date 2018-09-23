package net.poezdato.android.view.timetable

import dagger.Binds
import dagger.Module
import net.poezdato.android.data.repository.TimetableRepository
import net.poezdato.android.data.repository.TimetableRepositoryImpl
import net.poezdato.android.mvp.timetable.TimetablePresenter
import net.poezdato.android.mvp.timetable.TimetablePresenterImpl

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

@Module
abstract class TimetableModule {

    @Binds
    abstract fun bindTimetablePresenter(presenter: TimetablePresenterImpl): TimetablePresenter

    @Binds
    abstract fun bindTimetableRepository(repositoryImpl: TimetableRepositoryImpl): TimetableRepository

}
