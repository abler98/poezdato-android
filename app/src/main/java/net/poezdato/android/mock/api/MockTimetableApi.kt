package net.poezdato.android.mock.api

import io.reactivex.Single
import net.poezdato.android.api.TimetableApi
import net.poezdato.android.data.entity.*
import net.poezdato.android.util.DateUtils
import retrofit2.mock.MockRetrofit
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class MockTimetableApi @Inject constructor(mockRetrofit: MockRetrofit) : TimetableApi {

    private val delegate = mockRetrofit.create(TimetableApi::class.java)

    override fun getByRoute(origin: String, destination: String): Single<Timetable> {
        val timetable = Timetable(
            listOf(
                TimetableItem(
                    Train(TrainType.SUBURB, "6006"),
                    Route(
                        TrainStation("1", "Харьков"),
                        TrainStation("2", "Казачья Лопань")
                    ),
                    Point(
                        TrainStation(origin, "Южный Пост"),
                        DateUtils.fromTimeString("04:42")
                    ),
                    Point(
                        TrainStation(destination, "Безруковка"),
                        DateUtils.fromTimeString("05:14")
                    ),
                    60 * 32
                ),
                TimetableItem(
                    Train(TrainType.SUBURB, "6008"),
                    Route(
                        TrainStation("1", "Харьков"),
                        TrainStation("2", "Казачья Лопань")
                    ),
                    Point(
                        TrainStation(origin, "Южный Пост"),
                        DateUtils.fromTimeString("05:24")
                    ),
                    Point(
                        TrainStation(destination, "Безруковка"),
                        DateUtils.fromTimeString("05:55")
                    ),
                    60 * 31
                ),
                TimetableItem(
                    Train(TrainType.SUBURB, "6012"),
                    Route(
                        TrainStation("1", "Харьков"),
                        TrainStation("2", "Казачья Лопань")
                    ),
                    Point(
                        TrainStation(origin, "Южный Пост"),
                        DateUtils.fromTimeString("07:02")
                    ),
                    Point(
                        TrainStation(destination, "Безруковка"),
                        DateUtils.fromTimeString("07:35")
                    ),
                    60 * 33
                )
            )
        )
        return delegate.returningResponse(timetable).getByRoute(origin, destination)
    }

    override fun getByStation(station: String): Single<Timetable> {
        TODO("not implemented")
    }

}
