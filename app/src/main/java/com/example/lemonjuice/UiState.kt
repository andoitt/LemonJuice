package com.example.lemonjuice

import com.example.lemonjuice.databinding.ActivityMainBinding
import java.io.Serializable
import java.lang.IllegalStateException

interface UiState : Serializable {


    fun update(binding: ActivityMainBinding)

   // fun handleAction(juiceViewModel: Actions): UiState

    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : UiState {
        override fun update(binding: ActivityMainBinding) = with(binding) {
            title.update(textView)
            imageButton.updateUiState(image)
            button.updateUiState(button)
        }
    }

    data class Initial(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button) {

    /*    override fun handleAction(juiceViewModel: Actions): UiState {
            return juiceViewModel.goToSqueeze()
        }*/
    }

    data class Squeeze(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button) {

  /*      override fun handleAction(juiceViewModel: Actions): UiState {
            throw IllegalStateException()
        }*/
    }

    data class Process(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button) {

    /*    override fun handleAction(juiceViewModel: Actions): UiState {
            return juiceViewModel.goToMade()
        }*/

    }

    data class Made(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button) {

   /*     override fun handleAction(juiceViewModel: Actions): UiState {
            return juiceViewModel.goToFinish()
        }*/

    }

    data class Finish(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button) {

    /*    override fun handleAction(juiceViewModel: Actions): UiState {
            return juiceViewModel.startAgain()
        }*/
    }
}

