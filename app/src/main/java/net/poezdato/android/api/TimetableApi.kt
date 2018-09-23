package net.poezdato.android.api

import io.reactivex.Single
import net.poezdato.android.data.entity.Timetable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

interface TimetableApi {

    @GET("timetable/route/{origin}/{destination}")
    fun getByRoute(@Path("origin") origin: String, @Path("destination") destination: String): Single<Timetable>

    @GET("timetable/station/{station}")
    fun getByStation(@Path("station") station: String): Single<Timetable>

}
