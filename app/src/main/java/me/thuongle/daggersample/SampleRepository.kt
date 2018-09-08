package me.thuongle.daggersample

import javax.inject.Inject

class SampleRepository @Inject constructor(){
    fun getDescription() = "Hello Dagger"
}