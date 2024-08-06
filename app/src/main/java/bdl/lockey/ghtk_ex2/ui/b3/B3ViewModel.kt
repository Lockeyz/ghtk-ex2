package bdl.lockey.ghtk_ex2.ui.b3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bdl.lockey.ghtk_ex2.network.ProfileApiService
import bdl.lockey.ghtk_ex2.network.ProfileApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class B3ViewModel : ViewModel() {

    private val _b3 = MutableLiveData<B3Model>()
    val b3: LiveData<B3Model> get() = _b3

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _position = MutableLiveData("")
    val position: LiveData<String> = _position

    private val _historyList = MutableLiveData<List<HistoryModel>>(mutableListOf())
    val historyList: LiveData<List<HistoryModel>> = _historyList

    fun setHistoryList() {
        viewModelScope.launch {
            delay(2000)
            try {
                val data = ProfileApi.retrofitService.getData()
                val profile = data.body()
                _name.value = profile?.fullName
                _position.value = profile?.position
                _historyList.value = profile?.history
            } catch (e: Exception) {
                _name.value = ""
                _position.value = ""
                _historyList.value = listOf()
            }
        }

    }
}