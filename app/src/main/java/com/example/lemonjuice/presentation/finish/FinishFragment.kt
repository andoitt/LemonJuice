package com.example.lemonjuice.presentation.finish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.databinding.FragmentFinishBinding

class FinishFragment: Fragment() {

    private var _binding: FragmentFinishBinding? = null
    private val binding: FragmentFinishBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
           // (requireActivity() as Navigation).navigate(InitialFragment())
            (requireActivity() as FinishNavigation).navigateFromFinishScreen()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
interface FinishNavigation {

    fun navigateFromFinishScreen()
}