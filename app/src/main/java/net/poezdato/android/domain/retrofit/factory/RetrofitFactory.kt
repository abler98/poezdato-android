package net.poezdato.android.domain.retrofit.factory

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

interface RetrofitFactory {
    fun <T> create(service: Class<T>): T
}
