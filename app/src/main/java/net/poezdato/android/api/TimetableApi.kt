package net.poezdato.android.api

import io.reactivex.Single
import net.poezdato.android.data.entity.Timetable
import net.poezdato.android.data.entity.TrainStation
import net.poezdato.android.domain.retrofit.type.JsonParam
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

interface TimetableApi {

    @GET("timetable/route/{origin}/{destination}")
    fun getByRoute(
        @JsonParam("id") @Path("origin") origin: TrainStation,
        @JsonParam("id") @Path("destination") destination: TrainStation
    ): Single<Timetable>

    @GET("timetable/station/{station}")
    fun getByStation(@JsonParam("id") @Path("station") station: TrainStation): Single<Timetable>

}
