package net.alhazmy13.demoproject.view

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    abstract fun getLayoutId(): Int

    lateinit var viewDataBinding: T
        private set


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<T>(this, getLayoutId())
    }
}