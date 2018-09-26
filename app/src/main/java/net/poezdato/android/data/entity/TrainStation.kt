package net.poezdato.android.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

@Parcelize
data class TrainStation(
    val id: String,
    val name: String
) : Parcelable
