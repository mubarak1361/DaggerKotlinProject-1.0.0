package net.alhazmy13.demoproject.data.remote

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val originalRequest: Request = chain!!.request()

        return chain.proceed(originalRequest)
    }


}