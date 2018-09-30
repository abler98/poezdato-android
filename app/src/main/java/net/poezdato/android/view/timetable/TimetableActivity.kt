package net.poezdato.android.view.timetable

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import net.poezdato.android.R
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.TrainStation
import net.poezdato.android.kotlin.ensureFragment

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class TimetableActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        ensureFragment(R.id.container) {
            val route = Route(TrainStation("1", "Южный Пост"), TrainStation("2", "Безруковка"))
            TimetableFragmentBuilder(route).build()
        }
    }

}
