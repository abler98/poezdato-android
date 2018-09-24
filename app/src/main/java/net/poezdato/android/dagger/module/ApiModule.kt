package net.poezdato.android.dagger.module

import dagger.Module
import dagger.Provides
import net.poezdato.android.api.TimetableApi
import net.poezdato.android.domain.retrofit.factory.RetrofitFactory

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

@Module(
    includes = [
        RetrofitModule::class
    ]
)
class ApiModule {

    @Provides
    fun provideTimetableApi(factory: RetrofitFactory): TimetableApi {
        return factory.create(TimetableApi::class)
    }

}
