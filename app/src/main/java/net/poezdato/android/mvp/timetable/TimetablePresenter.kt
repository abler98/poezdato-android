package net.poezdato.android.mvp.timetable

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import net.poezdato.android.data.entity.Route

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

interface TimetablePresenter : MvpPresenter<TimetableView> {
    fun loadTimetable(route: Route)
}
