package net.alhazmy13.demoproject.di.post

import dagger.Module
import dagger.Provides
import net.alhazmy13.demoproject.data.remote.PostService
import retrofit2.Retrofit

@Module
class PostModule{

    @PostScope
    @Provides
    fun providePostService(retrofit: Retrofit): PostService {
        return retrofit.create(PostService::class.java)
    }
}