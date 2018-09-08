package me.thuongle.daggersample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.thuongle.daggersample.ui.MainFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
