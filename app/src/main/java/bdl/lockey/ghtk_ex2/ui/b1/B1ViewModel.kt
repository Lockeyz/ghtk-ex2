package bdl.lockey.ghtk_ex2.ui.b1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class B1ViewModel : ViewModel() {

    private val _currentString = MutableLiveData("")
    val currentString: LiveData<String> = _currentString

    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    fun setCurrentString(string: String) {
        _currentString.value = string
    }

    // Hàm trả về số lượng mỗi ký tự xuất hiện trong chuỗi
    fun setResult() {
        val charArray = currentString.value!!.toCharArray()

        val countMap = mutableMapOf<Char, Int>()
        val resultList = mutableListOf<String>("Chuỗi \"" + currentString.value +"\" có các phần tử sau:")

        for (character in charArray) {
            if (countMap.containsKey(key = character)) {
                countMap[character] = countMap[character]!! + 1
            } else {
                countMap[character] = 1
            }
        }

        for ((character, count) in countMap) {
            if (character.toString() == " ") {
                resultList.add("Khoảng trắng xuất hiện $count lần")
            } else {
                resultList.add("Phần tử $character xuất hiện $count lần")
            }
        }
        _result.value = resultList.joinToString("\n")
    }

}