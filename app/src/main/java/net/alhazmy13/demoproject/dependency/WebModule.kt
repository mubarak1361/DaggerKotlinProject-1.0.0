package net.alhazmy13.demoproject.dependency

import android.content.Context
import dagger.Module
import dagger.Provides
import net.alhazmy13.demoproject.BuildConfig
import net.alhazmy13.demoproject.data.model.Movie
import net.alhazmy13.demoproject.data.remote.ApiInterceptor
import net.alhazmy13.demoproject.data.remote.MovieService
import net.alhazmy13.demoproject.data.remote.PostService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author CIPL0349
 * @created 21/05/18
 */
@Module
class WebModule(private val context: Context) {

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
    fun provideRetrofit(httpClient: OkHttpClient.Builder,builder: Retrofit.Builder,loggingInterceptor: HttpLoggingInterceptor): Retrofit {
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(loggingInterceptor)
            httpClient.addInterceptor(ApiInterceptor(context))
        }
        builder.client(httpClient.build())
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit):MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun providePostService(retrofit: Retrofit):PostService {
        return retrofit.create(PostService::class.java)
    }

    @Singleton
    @Provides
    fun provideMovies(movieService: MovieService): Call<MutableList<Movie>> {
        return movieService.getMovies()
    }

}
