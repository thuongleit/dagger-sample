package me.thuongle.daggersample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.fragment_main.*
import me.thuongle.daggersample.R
import me.thuongle.daggersample.SampleWorker
import me.thuongle.daggersample.di.Injectable

class MainFragment : Fragment(), Injectable {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val workRequest = OneTimeWorkRequestBuilder<SampleWorker>().build()
        WorkManager.getInstance().enqueue(workRequest)

        val workStatus = WorkManager.getInstance().getStatusById(workRequest.id)

        workStatus.observe(this, Observer {
            tv_description.text = it.state.name
        })

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
