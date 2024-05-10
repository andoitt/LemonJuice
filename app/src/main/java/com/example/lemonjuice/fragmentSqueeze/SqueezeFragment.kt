package com.example.lemonjuice.fragmentSqueeze

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lemonjuice.JuiceApp
import com.example.lemonjuice.main.Navigation
import com.example.lemonjuice.databinding.FragmentSqueezeBinding
import com.example.lemonjuice.fragmentMade.MadeFragment

class SqueezeFragment : Fragment() {

    private var _binding: FragmentSqueezeBinding? = null
    private val binding: FragmentSqueezeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSqueezeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lateinit var uiState: FragmentUiState
        val viewModel = (requireActivity().application as JuiceApp).viewModel


        val showUi: () -> Unit = {
            uiState.update(
                binding.hintTextView,
                binding.pictureImageButton,
                binding.actionButton
            )
        }

        binding.actionButton.setOnClickListener {
            viewModel.exit()
          //  (requireActivity() as Navigation).navigate(MadeFragment())
            (requireActivity() as SqueezeNavigation).navigateFromSqueezeScreen()
        }

        binding.pictureImageButton.setOnClickListener {
            uiState = viewModel.handleImage()
            showUi.invoke()
        }

        uiState = viewModel.init(savedInstanceState == null)
        showUi.invoke()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

interface SqueezeNavigation {

    fun navigateFromSqueezeScreen()
}