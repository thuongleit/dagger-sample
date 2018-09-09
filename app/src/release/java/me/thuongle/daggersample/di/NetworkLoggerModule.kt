package me.thuongle.daggersample.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class NetworkLoggerModule {

    @NetworkInterceptor @Provides @Singleton @IntoSet
    fun provideNetworkLogger(): okhttp3.Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.NONE
    }
}
