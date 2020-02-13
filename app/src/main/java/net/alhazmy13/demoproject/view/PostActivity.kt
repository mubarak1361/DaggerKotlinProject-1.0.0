package net.alhazmy13.demoproject.view

import android.os.Bundle
import net.alhazmy13.demoproject.R
import net.alhazmy13.demoproject.data.model.Post
import net.alhazmy13.demoproject.data.remote.PostService
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
class PostActivity : BaseActivity<ActivityPostBinding>() {

    @Inject
    lateinit var postService: PostService

    @Inject
    lateinit var value:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postService.getPosts().enqueue(object:Callback<MutableList<Post>>{
            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        viewDataBinding.viewModel = PostViewModel(it)
                    }
                }
            }
        })
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_post
    }
}
