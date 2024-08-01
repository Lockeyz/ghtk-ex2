package bdl.lockey.ghtk_ex2

import bdl.lockey.ghtk_ex2.ui.b3.B3Model
import retrofit2.Call
import retrofit2.http.GET

interface ProfileApiService {
    @GET("d/af3cc8b64fa487da8be34c1cc1c5d2d5.json")
    fun getData(): Call<B3Model>
}