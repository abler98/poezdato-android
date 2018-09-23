package net.poezdato.android.data.repository

import io.reactivex.Single
import net.poezdato.android.api.TimetableApi
import net.poezdato.android.data.entity.Route
import net.poezdato.android.data.entity.Timetable
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class TimetableRepositoryImpl @Inject constructor(private val service: TimetableApi) :
    TimetableRepository {

    override fun findByRoute(route: Route): Single<Timetable> {
        return service.getByRoute(route.originStation.id, route.destinationStation.id)
    }

}
