package net.alhazmy13.demoproject.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import net.alhazmy13.demoproject.data.remote.MovieService
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

    }
}