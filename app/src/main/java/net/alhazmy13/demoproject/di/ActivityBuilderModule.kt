package net.alhazmy13.demoproject.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.alhazmy13.demoproject.di.post.PostModule
import net.alhazmy13.demoproject.di.post.PostScope
import net.alhazmy13.demoproject.view.PostActivity

@Module
abstract class ActivityBuilderModule{

    @PostScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun contributePostActivity(): PostActivity
}