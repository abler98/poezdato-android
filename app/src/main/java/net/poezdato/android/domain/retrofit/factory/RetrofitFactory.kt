package net.poezdato.android.domain.retrofit.factory

import kotlin.reflect.KClass

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

interface RetrofitFactory {
    fun <T : Any> create(service: KClass<T>): T
}
