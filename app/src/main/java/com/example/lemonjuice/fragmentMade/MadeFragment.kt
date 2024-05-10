package com.example.lemonjuice.fragmentMade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.main.Navigation
import com.example.lemonjuice.databinding.FragmentMadeBinding
import com.example.lemonjuice.fragmentFinish.FinishFragment

class MadeFragment: Fragment() {

    private var _binding: FragmentMadeBinding? = null
    private val binding: FragmentMadeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMadeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(FinishFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}