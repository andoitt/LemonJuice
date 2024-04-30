package com.example.lemonjuice

import com.example.lemonjuice.databinding.ActivityMainBinding
import java.lang.IllegalStateException

interface UiState {


    fun update(binding: ActivityMainBinding)
    fun handleAction(gameViewModel: Actions): UiState

    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : UiState {
        override fun update(binding: ActivityMainBinding) = with(binding) {
            title.update(textView)
            image.update(imageButton)
            button.update(actionButton)
        }
    }

    data class Initial(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button) {

        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToSqueeze()
        }
    }


    data class Squeeze(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button) {

        override fun handleAction(gameViewModel: Actions): UiState {
            throw IllegalStateException()
        }
    }


    data class Process(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button) {

        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToMade()
        }

    }


    data class Made(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button) {

        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.goToFinish()
        }

    }

    data class Finish(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ButtonUiState
    ) : Abstract(title, image, button) {

        override fun handleAction(gameViewModel: Actions): UiState {
            return gameViewModel.startAgain()
        }
    }
}

