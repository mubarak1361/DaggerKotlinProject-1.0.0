package net.alhazmy13.demoproject.data.remote

import net.alhazmy13.demoproject.data.model.Post
import retrofit2.Call

import retrofit2.http.GET

/**
 * @author CIPL0349
 * @created 21/05/18
 */
interface PostService{

     @GET("/posts")
     fun getPosts(): Call<MutableList<Post>>
}