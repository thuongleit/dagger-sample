package me.thuongle.daggersample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.thuongle.daggersample.ui.MainActivity

@Module()
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}