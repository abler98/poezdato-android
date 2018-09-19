package net.poezdato.android.mvp.timetable

import android.content.SharedPreferences
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class TimetablePresenterImpl @Inject constructor(private val preferences: SharedPreferences) :
    MvpBasePresenter<TimetableView>(), TimetablePresenter {

    override fun readValue() {
        ifViewAttached { it.showToast(preferences.getString("key", "value")) }
    }

}
