package net.poezdato.android.mock.server

import kotlin.reflect.KClass

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class MockRegistry private constructor(private val services: Map<KClass<*>, Any>) {

    fun <T : Any> find(service: KClass<T>): T {
        @Suppress("UNCHECKED_CAST")
        return services.getValue(service) as T
    }

    class Builder {

        private val services: MutableMap<KClass<*>, Any> = mutableMapOf()

        fun <T : Any> add(service: KClass<T>, mock: T): Builder {
            services[service] = mock
            return this
        }

        fun build(): MockRegistry {
            return MockRegistry(services)
        }

    }

}
