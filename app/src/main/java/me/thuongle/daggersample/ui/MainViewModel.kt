package me.thuongle.daggersample.ui

import androidx.lifecycle.ViewModel
import me.thuongle.daggersample.SampleRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(val sample: SampleRepository) : ViewModel()