package bdl.lockey.ghtk_ex2.ui.b3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bdl.lockey.ghtk_ex2.ApiInterface
import bdl.lockey.ghtk_ex2.R
import bdl.lockey.ghtk_ex2.RetrofitInstance
import bdl.lockey.ghtk_ex2.databinding.FragmentB3Binding
import retrofit2.Callback
import retrofit2.Response


class B3Fragment : Fragment() {

    private var _binding: FragmentB3Binding? = null
    private val binding get() = _binding!!

    private lateinit var apiInterface: ApiInterface
    private val historyList = mutableListOf<HistoryModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentB3Binding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getInterface()
        getData()
//        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowTitleEnabled(false)
//        val inflater = LayoutInflater.from(activity)
//        val customView: View = inflater.inflate(R.layout.custom_action_bar, null)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.custom_action_bar)
    }


    private fun getInterface() {
        apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
    }

    private fun getData() {
        val call = apiInterface.getData()
        call.enqueue(object : Callback<B3Model> {
            override fun onResponse(call: retrofit2.Call<B3Model>, response: Response<B3Model>) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!

                    binding.textViewName.text = data.fullName
                    binding.textViewPosition.text = data.position
                    data.history.forEach { history ->
                        historyList.add(history)
                    }
                    setHistoryRecyclerView()
                }
            }
            override fun onFailure(call: retrofit2.Call<B3Model>, t: Throwable) {
                Toast.makeText(context, "That bai", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setHistoryRecyclerView() {
        binding.recyclerViewHistory.adapter = B3Adapter(requireContext(), historyList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(false)
        _binding = null
    }


}
