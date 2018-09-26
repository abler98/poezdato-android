package net.poezdato.android.view.timetable

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import net.poezdato.android.R
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.TrainStation

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 19.09.2018.
 */

class TimetableActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        supportFragmentManager.findFragmentById(R.id.timetableFragmentContainer).let {
            val route = Route(TrainStation("1", "Южный Пост"), TrainStation("2", "Безруковка"))
            supportFragmentManager.beginTransaction()
                .add(R.id.timetableFragmentContainer, TimetableFragmentBuilder(route).build())
                .commit()
        }
    }

}
