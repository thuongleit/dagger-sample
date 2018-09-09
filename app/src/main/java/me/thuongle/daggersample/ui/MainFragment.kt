package me.thuongle.daggersample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.fragment_main.*
import me.thuongle.daggersample.ApiService
import me.thuongle.daggersample.R
import me.thuongle.daggersample.di.Injectable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_items.adapter = ItemAdapter()

        apiService.getItems("topstories.json").enqueue(object : Callback<List<Long>> {
            override fun onFailure(call: Call<List<Long>>, t: Throwable) {
                tv_description.text = t.message
                tv_description.visibility = View.VISIBLE
                rv_items.visibility = View.GONE
            }

            override fun onResponse(call: Call<List<Long>>, response: Response<List<Long>>) {
                response.body()?.let {
                    (rv_items.adapter as ListAdapter<Long, *>).submitList(it)
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
