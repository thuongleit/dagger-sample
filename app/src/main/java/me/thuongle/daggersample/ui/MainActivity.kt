package me.thuongle.daggersample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import me.thuongle.daggersample.R
import me.thuongle.daggersample.SampleRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var repository: SampleRepository

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, repository.getDescription(), Toast.LENGTH_SHORT).show()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.layout_container, MainFragment.newInstance())
                .commit()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
