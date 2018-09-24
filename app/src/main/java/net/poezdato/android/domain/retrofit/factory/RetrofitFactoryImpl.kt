package net.poezdato.android.domain.retrofit.factory

import retrofit2.Retrofit
import javax.inject.Inject
import kotlin.reflect.KClass

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class RetrofitFactoryImpl @Inject constructor(private val retrofit: Retrofit) : RetrofitFactory {
    override fun <T : Any> create(service: KClass<T>): T = retrofit.create(service.java)
}
