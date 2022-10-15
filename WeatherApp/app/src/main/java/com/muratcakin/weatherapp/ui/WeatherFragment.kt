package com.muratcakin.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muratcakin.weatherapp.R
import com.muratcakin.weatherapp.data.api.ApiClient
import com.muratcakin.weatherapp.data.models.Model
import com.muratcakin.weatherapp.databinding.FragmentWeatherBinding
import com.muratcakin.weatherapp.ui.adapter.DaysAdapter
import retrofit2.Call
import retrofit2.Response

class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private lateinit var rvDaysList: RecyclerView
    private lateinit var currentWeather: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvDaysList = view.findViewById(R.id.rvDaysList)
        getWeatherData()
    }

    private fun getWeatherData() {
        ApiClient
            .getApiService()
            .getWeatherData(28.962078,40.2216568,"metrics")
            .enqueue(object : retrofit2.Callback<List<Model>>{
                override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                    if(response.isSuccessful) {
                        val days = response.body()
                        days?.let { safeDays ->
                            rvDaysList.adapter = DaysAdapter().apply {
                                submitList(safeDays)
                            }
                        }
                        binding.tvCurrentWeather.text = response.body()?.current

                    }
                }

                override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                    Log.d("deneme1", t.message.toString())
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}