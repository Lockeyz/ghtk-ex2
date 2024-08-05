package bdl.lockey.ghtk_ex2.ui.b3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bdl.lockey.ghtk_ex2.network.ProfileApiService
import bdl.lockey.ghtk_ex2.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response

enum class ApiStatus { LOADING, ERROR, DONE }

class B3ViewModel : ViewModel() {

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
        get() = _status

    private val _b3 = MutableLiveData<B3Model>()
    val b3: LiveData<B3Model> get() = _b3

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _position = MutableLiveData("")
    val position: LiveData<String> = _position

    private val _historyList = MutableLiveData<List<HistoryModel>>(mutableListOf())
    val historyList: LiveData<List<HistoryModel>> = _historyList

    fun setName(name: String) {
        _name.value = name
    }

    fun setPosition(position: String) {
        _position.value = position
    }

    fun setHistoryList() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            delay(2000)
            val profileApi = RetrofitInstance.getInstance().create(ProfileApiService::class.java)

            val call = profileApi.getData()
            call.enqueue(object : Callback<B3Model> {
                override fun onResponse(call: retrofit2.Call<B3Model>, response: Response<B3Model>) {
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!

                        setName(data.fullName)
                        setPosition(data.position)
                        _historyList.value = data.history
                    }
                }
                override fun onFailure(call: retrofit2.Call<B3Model>, t: Throwable) {

                }
            })
        }

    }
}