package me.thuongle.daggersample.di

import androidx.work.Worker
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import me.thuongle.daggersample.SampleWorker

@Module(subcomponents = [SampleWorkerComponent::class])
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(SampleWorker::class)
    internal abstract fun bindWorkerFactory(profileWorker: SampleWorkerComponent.Builder): AndroidInjector.Factory<out Worker>
}