package bdl.lockey.ghtk_ex2.ui.b1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import bdl.lockey.ghtk_ex2.R
import bdl.lockey.ghtk_ex2.databinding.FragmentB1Binding

class B1Fragment : Fragment() {

    private var _binding: FragmentB1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: B1ViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_b1, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // tạo các biến liên kết với fragment
        binding.b1ViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.b1Fragment = this
    }

    // Hàm nhận chuỗi nhập vào
    fun submitString(){
        viewModel.setCurrentString(binding.stringEditText.text.toString())
        viewModel.setResult()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}