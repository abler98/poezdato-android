package net.poezdato.android.domain.retrofit.factory

import net.poezdato.android.mock.server.MockRegistry
import javax.inject.Inject
import kotlin.reflect.KClass


/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class MockRetrofitFactory @Inject constructor(private val registry: MockRegistry) : RetrofitFactory {
    override fun <T : Any> create(service: KClass<T>) = registry.find(service)
}
