package net.alhazmy13.demoproject.dependency

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.alhazmy13.demoproject.view.PostActivity

@Module
abstract class AppModule{
    @ContributesAndroidInjector
    abstract fun getPostActivity(): PostActivity
}