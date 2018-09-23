package net.poezdato.android.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

object DateUtils {

    fun fromTimeString(value: String): Date {
        return SimpleDateFormat("HH:mm", Locale.ROOT).parse(value)
    }

}
