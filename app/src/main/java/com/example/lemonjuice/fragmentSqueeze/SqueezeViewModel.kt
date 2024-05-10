package com.example.lemonjuice.fragmentSqueeze

import com.example.lemonjuice.ActionButtonUi.ActionButtonUiState
import com.example.lemonjuice.ImageButtonUi.ImageUiState
import com.example.lemonjuice.TextViewUi.TitleUiState
import com.example.lemonjuice.repository.Repository

class SqueezeViewModel(
    private val repository: Repository
) {
    /* fun init(): SqueezeUiState = SqueezeUiState.Initial(
         title = TitleUiState.Initial,
         image = ImageUiState.Initial,
         button = ActionButtonUiState.Initial,
     )*/

    fun init(isFirstTime: Boolean = true): FragmentUiState {
        return if (isFirstTime) {
            FragmentUiState.SqueezeUp(
                image = ImageUiState.SqueezeUp,
                button = ActionButtonUiState.SqueezeUp,
                title = TitleUiState.SqueezeUp
            )
        } else {
            FragmentUiState.Empty
        }
    }


    fun handleImage(): FragmentUiState {
        repository.addCounter()
        return if (repository.isMax()) {
            FragmentUiState.SqueezeOff(
                title = TitleUiState.SqueezeOff,
                image = ImageUiState.SqueezeOff,
                button = ActionButtonUiState.SqueezeOff,
            )
        } else {
            FragmentUiState.SqueezeUp(
                title = TitleUiState.SqueezeUp,
                image = ImageUiState.SqueezeUp,
                button = ActionButtonUiState.SqueezeUp,

                )
        }
    }
    fun exit() {
        repository.reset()
    }
}
