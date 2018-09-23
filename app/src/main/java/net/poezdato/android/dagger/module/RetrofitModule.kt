package net.poezdato.android.dagger.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Lazy
import dagger.Module
import dagger.Provides
import net.poezdato.android.R
import net.poezdato.android.domain.retrofit.factory.MockRetrofitFactory
import net.poezdato.android.domain.retrofit.factory.RetrofitFactory
import net.poezdato.android.domain.retrofit.factory.RetrofitFactoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 23.09.2018.
 */

@Module(
    includes = [
        MockApiModule::class
    ]
)
class RetrofitModule {

    @Provides
    fun provideRetrofit(
        @Named("baseUrl") baseUrl: String, httpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    }

    @Provides
    fun provideRetrofitFactory(
        context: Context,
        factory: Lazy<RetrofitFactoryImpl>,
        mockFactory: Lazy<MockRetrofitFactory>
    ): RetrofitFactory {
        return when (context.getString(R.string.app_server_type)) {
            "mock" -> mockFactory.get()
            "remote" -> factory.get()
            else -> throw IllegalArgumentException("Invalid server type")
        }
    }

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(context: Context): String {
        return context.getString(R.string.app_base_url)
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}
