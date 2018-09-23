package net.poezdato.android.dagger.module

import dagger.Module
import dagger.Provides
import net.poezdato.android.api.TimetableApi
import net.poezdato.android.mock.api.MockTimetableApi
import net.poezdato.android.mock.server.MockRegistry
import retrofit2.Retrofit
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

@Module
class MockApiModule {

    @Provides
    fun provideMockRetrofit(retrofit: Retrofit): MockRetrofit {
        return MockRetrofit.Builder(retrofit)
            .networkBehavior(NetworkBehavior.create())
            .build()
    }

    @Provides
    fun provideMockRegistry(timetableApi: MockTimetableApi): MockRegistry {
        return MockRegistry.Builder()
            .add(TimetableApi::class.java, timetableApi)
            .build()
    }

}
