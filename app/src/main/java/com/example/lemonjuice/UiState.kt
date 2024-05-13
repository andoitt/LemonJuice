package com.example.lemonjuice

import android.widget.TextView
import com.example.lemonjuice.views.action.ActionButton
import com.example.lemonjuice.views.action.ActionButtonUiState
import com.example.lemonjuice.views.image.ImageAction
import com.example.lemonjuice.views.image.ImageUiState
import com.example.lemonjuice.presentation.text.TitleUiState
import com.example.lemonjuice.presentation.squeeze.SqueezeUiState
import java.io.Serializable

interface UiState : Serializable {

    fun update (
        textView: TextView,
        imageButton: ImageAction,
        actionButton: ActionButton
    )

    object Empty : UiState  {
        override fun update(
            textView: TextView,
            imageButton: ImageAction,
            actionButton: ActionButton
        ) = Unit
    }

   // fun handleAction(juiceViewModel: Actions): UiState

    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : UiState {
        override fun update(
            textView: TextView,
            imageButton: ImageAction,
            actionButton: ActionButton
        ) {
            title.update(textView)
            imageButton.updateUiState(image)
            actionButton.updateActionButton(button)

        }
    }

    data class Initial(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button)


    data class Squeeze(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button)

    data class Process(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button)

    data class Made(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button)

    data class Finish(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : Abstract(title, image, button)

    data class SqueezeUp(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState,
    ) : SqueezeUiState.Abstract(title, image, button)

    data class SqueezeOff(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState,
    ) : SqueezeUiState.Abstract(title, image, button)
}

