package bdl.lockey.ghtk_ex2.ui.b3

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import bdl.lockey.ghtk_ex2.R
import bdl.lockey.ghtk_ex2.databinding.FragmentB3Binding


class B3Fragment : Fragment() {

    private var _binding: FragmentB3Binding? = null
    private val binding get() = _binding!!

    private val viewModel: B3ViewModel by viewModels()

    private lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentB3Binding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.b3ViewModel = viewModel
        binding.b3Fragment = this

        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setCustomView(R.layout.custom_action_bar)

        viewModel.setHistoryList()


        viewModel.historyList.observe(viewLifecycleOwner) {
            adapter = HistoryAdapter(viewModel.historyList.value!!)
            binding.recyclerViewHistory.adapter = adapter
            adapter.notifyDataSetChanged()
            Log.d("HistoryFragment", viewModel.historyList.value?.size.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayShowCustomEnabled(false)
        _binding = null
    }


}
