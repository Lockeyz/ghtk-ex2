package bdl.lockey.ghtk_ex2.ui.b1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
        if (!checkErrorTextField()) {
            viewModel.setCurrentString(binding.stringEditText.text.toString())
            viewModel.setResult()
        }
    }

    fun checkErrorTextField(): Boolean {
        if (binding.stringEditText.text.isNullOrEmpty()) {
            binding.stringInputLayout.isErrorEnabled = true
            binding.stringInputLayout.error = getString(R.string.error_field_required)
            return true
        } else {
            binding.stringInputLayout.isErrorEnabled = false
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}