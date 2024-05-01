package com.example.lemonjuice

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: JuiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState

         viewModel = (application as JuiceApp).viewModel


        binding.actionButton.setOnClickListener {
            uiState = binding.actionButton.handleAction(viewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = viewModel.handleImage()
            uiState.update(binding)
        }




        uiState = viewModel.init().also {
            it.update(binding)
        }
        if (savedInstanceState == null)
            uiState = viewModel.init().also {
                it.update(binding)
            }
    }












    /*  uiState = viewModel.init()
       uiState.update(binding)*/



    /* uiState = if (savedInstanceState == null) {
         viewModel.init().also {
             it.update(binding)
         }
     } else {
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
         } else {
             savedInstanceState.getSerializable(KEY) as UiState
         }
     }

     fun onSaveInstanceState(outState: Bundle) {
         super.onSaveInstanceState(outState)
         outState.putSerializable(KEY, uiState)
     }*/

    }

/*    companion object {
        private const val KEY = "uiStateKey"
    }
}*/
