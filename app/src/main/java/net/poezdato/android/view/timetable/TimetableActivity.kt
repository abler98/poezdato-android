package net.poezdato.android.view.timetable

import android.os.Bundle
import android.widget.Toast
import net.poezdato.android.R
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.TrainStation
import net.poezdato.android.mvp.timetable.TimetablePresenter
import net.poezdato.android.mvp.timetable.TimetableView
import net.poezdato.android.view.base.DaggerMvpActivity
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class TimetableActivity : DaggerMvpActivity<TimetableView, TimetablePresenter>(), TimetableView {

    @Inject lateinit var mPresenter: TimetablePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        val route = Route(TrainStation("1", "Южный Пост"), TrainStation("2", "Безруковка"))
        presenter.loadTimetable(route)
    }

    override fun createPresenter(): TimetablePresenter {
        return mPresenter
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
