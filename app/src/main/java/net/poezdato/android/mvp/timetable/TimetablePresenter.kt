package net.poezdato.android.mvp.timetable

import com.hannesdorfmann.mosby3.mvp.MvpPresenter

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

interface TimetablePresenter : MvpPresenter<TimetableView> {
    fun readValue()
}
