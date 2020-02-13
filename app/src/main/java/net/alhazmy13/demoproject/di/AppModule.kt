package net.alhazmy13.demoproject.di

import android.app.Application
import dagger.Module
import dagger.Provides
import net.alhazmy13.demoproject.BuildConfig
import net.alhazmy13.demoproject.data.remote.ApiInterceptor
import net.alhazmy13.demoproject.data.remote.MovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author CIPL0349
 * @created 21/05/18
 */
@Module
class AppModule {

    private val BASE_URL = "https://api.androidhive.info"


    @Singleton
    @Provides
    fun provideBuilder():Retrofit.Builder{
       return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun provideHttpClient():OkHttpClient.Builder = OkHttpClient.Builder()

    @Singleton
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideRetrofit(application:Application,httpClient: OkHttpClient.Builder,builder: Retrofit.Builder,loggingInterceptor: HttpLoggingInterceptor): Retrofit {
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(loggingInterceptor)
            httpClient.addInterceptor(ApiInterceptor(application))
        }
        builder.client(httpClient.build())
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit):MovieService {
        return retrofit.create(MovieService::class.java)
    }

}
