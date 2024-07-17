package bdl.lockey.ghtk_ex2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // base url phai ket thuc bang "/"
    private const val BASE_URL = "https://cache.giaohangtietkiem.vn/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}