package bdl.lockey.ghtk_ex2.ui.b3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class B3ViewModel : ViewModel() {
    private val _history = MutableLiveData<List<HistoryModel>>(mutableListOf())
    val history: LiveData<List<HistoryModel>> = _history

    fun setHistory() {

    }
}