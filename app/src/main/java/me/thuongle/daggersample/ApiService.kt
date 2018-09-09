package me.thuongle.daggersample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{path}")
    fun getItems(@Path("path") path: String): Call<List<Long>>
}