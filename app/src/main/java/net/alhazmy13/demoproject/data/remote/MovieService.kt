package net.alhazmy13.demoproject.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import net.alhazmy13.demoproject.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("/json/movies.json")
    fun getMovies(): Call<MutableList<Movie>>
}