package com.example.lemonjuice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState

        val juiceViewModel = JuiceViewModel(Repository.Base())

     //   val juiceViewModel = (application as LemonJuice).viewModel

        binding.imageButton.setOnClickListener {
            uiState = juiceViewModel.handleImage()        //todo какаяя метода?
            uiState.update(binding)
        }

        binding.actionButton.setOnClickListener {
            uiState = uiState.handleAction(juiceViewModel)
            uiState.update(binding)
        }

   /*     binding.textView.setOnClickListener{
            val uiState = viewModel.checkTextView()                        //todo нужно ли вообще?
            uiState.update(binding)
        }*/

        uiState = juiceViewModel.init()
        uiState.update(binding)
    }
}
