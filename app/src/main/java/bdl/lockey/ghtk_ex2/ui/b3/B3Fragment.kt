package bdl.lockey.ghtk_ex2.ui.b3

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import bdl.lockey.ghtk_ex2.ApiInterface
import bdl.lockey.ghtk_ex2.R
import bdl.lockey.ghtk_ex2.RetrofitInstance
import bdl.lockey.ghtk_ex2.databinding.FragmentB3Binding
import retrofit2.Callback
import retrofit2.Response


class B3Fragment : Fragment() {

    private var _binding: FragmentB3Binding? = null
    private val binding get() = _binding!!

    private val viewModel: B3ViewModel by viewModels()

    lateinit var adapter: HistoryAdapter

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
        binding.lifecycleOwner = viewLifecycleOwner
        binding.b3ViewModel = viewModel
        binding.b3Fragment = this

        viewModel.setHistoryList()
//        setHistoryRecyclerView()

        adapter = HistoryAdapter(requireContext(), viewModel.historyList.value!!)

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.custom_action_bar)
    }


//    private fun getInterface() {
//        apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
//    }
//
//    private fun getData() {
//        val call = apiInterface.getData()
//        call.enqueue(object : Callback<B3Model> {
//            override fun onResponse(call: retrofit2.Call<B3Model>, response: Response<B3Model>) {
//                if (response.isSuccessful && response.body() != null) {
//                    val data = response.body()!!
//                    val historyList = mutableListOf<HistoryModel>()
//
//                    data.history.forEach { history ->
//                        historyList.add(history)
//                    }
//
//                    viewModel.setName(data.fullName)
//                    viewModel.setPosition(data.position)
//
//
//                }
//            }
//            override fun onFailure(call: retrofit2.Call<B3Model>, t: Throwable) {
//                Toast.makeText(context, "That bai", Toast.LENGTH_LONG).show()
//            }
//        })
//    }

    private fun setHistoryRecyclerView() {
        binding.recyclerViewHistory.adapter = HistoryAdapter(requireContext(),
            viewModel.historyList.value!!
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(false)
        _binding = null
    }


}
