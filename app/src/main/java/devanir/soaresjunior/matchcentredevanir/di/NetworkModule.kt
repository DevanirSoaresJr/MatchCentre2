package devanir.soaresjunior.matchcentredevanir.di

import dagger.Module
import dagger.Provides
import devanir.soaresjunior.matchcentredevanir.BASE_URL
import devanir.soaresjunior.matchcentredevanir.net.MatchService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpCookie
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    //Logging the response in the LogCat to check if right response was retrieved
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @Singleton
    //Creating the OkHttpClient
    fun provideOkHttp(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @Singleton
    //Creating Retrofit Client
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMatchService(retrofit: Retrofit): MatchService {
        return retrofit.create(MatchService::class.java)
    }
}