package net.poezdato.android.domain.retrofit.factory

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class RetrofitFactoryImpl @Inject constructor(private val retrofit: Retrofit) : RetrofitFactory {

    override fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}
