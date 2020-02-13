package net.alhazmy13.demoproject.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.alhazmy13.demoproject.UglyApp
import javax.inject.Singleton


/**
 * @author CIPL0349
 * @created 21/05/18
 */

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class,AppModule::class])
interface AppComponent : AndroidInjector<UglyApp> {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder

    }
}