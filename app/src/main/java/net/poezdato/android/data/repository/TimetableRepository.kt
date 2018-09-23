package net.poezdato.android.data.repository

import io.reactivex.Single
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.Timetable

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

interface TimetableRepository {
    fun findByRoute(route: Route): Single<Timetable>
}
