package net.poezdato.android.mvp.timetable

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

interface TimetableView : MvpView {
    fun showToast(message: String)
}
