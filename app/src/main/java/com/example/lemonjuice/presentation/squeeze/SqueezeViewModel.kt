package com.example.lemonjuice.presentation.squeeze

import com.example.lemonjuice.views.action.ActionButtonUiState
import com.example.lemonjuice.views.image.ImageUiState
import com.example.lemonjuice.presentation.text.TitleUiState
import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.presentation.main.MyViewModel

class SqueezeViewModel(
    private val repository: Repository
) : MyViewModel {


    fun init(isFirstTime: Boolean = true): SqueezeUiState {
        return if (isFirstTime) {
            repository.saveCurrentScreen()
            if (repository.isMax()) {
                SqueezeUiState.SqueezeOff(
                    image = ImageUiState.SqueezeOff,
                    button = ActionButtonUiState.SqueezeOff,
                    title = TitleUiState.SqueezeOff
                )
            } else {
                SqueezeUiState.SqueezeUp(
                    title = TitleUiState.SqueezeUp,
                    image = ImageUiState.SqueezeUp,
                    button = ActionButtonUiState.SqueezeUp
                )
            }
        } else {
            SqueezeUiState.Empty
        }

    }

    fun handleImage(): SqueezeUiState {
        repository.addCounter()
        return if (repository.isMax()) {
            SqueezeUiState.SqueezeOff(
                title = TitleUiState.SqueezeOff,
                image = ImageUiState.SqueezeOff,
                button = ActionButtonUiState.SqueezeOff,
            )
        } else {
            SqueezeUiState.SqueezeUp(
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