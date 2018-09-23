package net.poezdato.android.domain.retrofit.factory

import net.poezdato.android.mock.server.MockRegistry
import javax.inject.Inject


/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class MockRetrofitFactory @Inject constructor(private val registry: MockRegistry) : RetrofitFactory {

    override fun <T> create(service: Class<T>): T {
        return registry.find(service)
    }

}
