package me.thuongle.daggersample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import me.thuongle.daggersample.R
import me.thuongle.daggersample.SampleRepository
import me.thuongle.daggersample.di.Injectable
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var repository: SampleRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_description.text = repository.getDescription()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
