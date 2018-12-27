package net.alhazmy13.demoproject.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import net.alhazmy13.demoproject.R
import net.alhazmy13.demoproject.data.model.Movie
import net.alhazmy13.demoproject.data.remote.MovieService
import net.alhazmy13.demoproject.databinding.ActivityPostBinding
import net.alhazmy13.demoproject.viewmodel.PostViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * @author CIPL0349
 * @created 21/05/18
 */
class PostActivity : AppCompatActivity() {

    @Inject
    lateinit var movieService: MovieService

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val activityPostBinding = DataBindingUtil.setContentView<ActivityPostBinding>(this, R.layout.activity_post)

        movieService.getMovies().enqueue(object :Callback<MutableList<Movie>>{
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                if (response.isSuccessful && response.body() != null) {
                    activityPostBinding.viewModel = PostViewModel(response.body()!!)
                }
            }

        })
    }
}
