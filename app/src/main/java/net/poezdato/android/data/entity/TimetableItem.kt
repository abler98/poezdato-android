package net.poezdato.android.data.entity

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

data class TimetableItem(
    val train: Train,
    val route: Route,
    val origin: Point,
    val destination: Point
)
