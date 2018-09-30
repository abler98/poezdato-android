package net.poezdato.android.mvp.timetable

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView
import net.poezdato.android.data.entity.Timetable

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

interface TimetableView : MvpLceView<Timetable> {
    fun showToast(message: String)
}
