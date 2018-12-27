package net.alhazmy13.demoproject

import android.databinding.DataBindingUtil
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.alhazmy13.demoproject.component.BaseDataBindingComponent
import net.alhazmy13.demoproject.dependency.DaggerWebComponent
import net.alhazmy13.demoproject.dependency.WebModule

/**
 * @author CIPL0349
 * @created 21/05/18
 */
 class UglyApp : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerWebComponent.builder().webModule(WebModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        DataBindingUtil.setDefaultComponent(BaseDataBindingComponent())
    }

}