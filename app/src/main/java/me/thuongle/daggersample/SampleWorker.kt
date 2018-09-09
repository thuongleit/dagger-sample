package me.thuongle.daggersample

import android.util.Log
import androidx.work.Worker
import me.thuongle.daggersample.di.AndroidWorkerInjection
import javax.inject.Inject

class SampleWorker : Worker() {

    @Inject
    lateinit var sampleRepository: SampleRepository

    override fun doWork(): Result {
        AndroidWorkerInjection.inject(this)

        Log.d(TAG, "worker get ${sampleRepository.getDescription()}")
        return Result.SUCCESS
    }

    companion object {
        private const val TAG = "SampleWorker"
    }
}

