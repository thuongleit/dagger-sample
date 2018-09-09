package me.thuongle.daggersample

import android.app.Activity
import android.app.Application
import androidx.work.Worker
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.thuongle.daggersample.di.AppInjector
import me.thuongle.daggersample.di.HasWorkerInjector
import javax.inject.Inject

open class App : Application(), HasActivityInjector, HasWorkerInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchWorkerInjector: DispatchingAndroidInjector<Worker>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

    override fun workerInjector() = dispatchWorkerInjector
}
