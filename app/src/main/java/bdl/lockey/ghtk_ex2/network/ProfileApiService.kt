package bdl.lockey.ghtk_ex2.network

import bdl.lockey.ghtk_ex2.ui.b3.B3Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://cache.giaohangtietkiem.vn/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ProfileApiService {
    @GET("d/af3cc8b64fa487da8be34c1cc1c5d2d5.json")
    suspend fun getData(): Call<B3Model>
}

object ProfileApi {
    val retrofitService : ProfileApiService by lazy { retrofit.create(ProfileApiService::class.java) }
}



