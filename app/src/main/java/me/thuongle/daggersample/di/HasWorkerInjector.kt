package me.thuongle.daggersample.di

import androidx.work.Worker
import dagger.android.AndroidInjector

interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<Worker>
}