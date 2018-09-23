package net.poezdato.android.mock.server

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

class MockRegistry private constructor(private val services: Map<Class<*>, Any>) {

    fun <T> find(service: Class<T>): T {
        return service.cast(services.getValue(service))
    }

    class Builder {

        private val services: MutableMap<Class<*>, Any> = mutableMapOf()

        fun <T : Any> add(service: Class<T>, mock: T): Builder {
            services[service] = mock
            return this
        }

        fun build(): MockRegistry {
            return MockRegistry(services)
        }

    }

}
