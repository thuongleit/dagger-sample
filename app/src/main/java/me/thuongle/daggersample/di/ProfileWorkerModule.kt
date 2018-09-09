package me.thuongle.daggersample.di

import dagger.Subcomponent
import dagger.android.AndroidInjector
import me.thuongle.daggersample.SampleWorker

@Subcomponent
interface SampleWorkerComponent: AndroidInjector<SampleWorker> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SampleWorker>()
}