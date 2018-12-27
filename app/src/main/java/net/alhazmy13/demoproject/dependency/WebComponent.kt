package net.alhazmy13.demoproject.dependency

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
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, WebModule::class])
interface WebComponent : AndroidInjector<UglyApp> {
    override fun inject(uglyApp: UglyApp)
}