package com.example.lemonjuice.fragmentInitial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.main.Navigation
import com.example.lemonjuice.databinding.FragmentInitialBinding
import com.example.lemonjuice.fragmentSqueeze.SqueezeFragment
import com.example.lemonjuice.fragmentSqueeze.SqueezeNavigation

class InitialFragment: Fragment() {

    private var _binding: FragmentInitialBinding? = null
    private val binding: FragmentInitialBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitialBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
          //  (requireActivity() as Navigation).navigate(SqueezeFragment())
            (requireActivity() as InitialNavigation).navigateFromInitialScreen()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

interface InitialNavigation {

    fun navigateFromInitialScreen()
}