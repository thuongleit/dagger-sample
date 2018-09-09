package me.thuongle.daggersample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import me.thuongle.daggersample.R

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.layout_container, MainFragment.newInstance())
                .commit()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
