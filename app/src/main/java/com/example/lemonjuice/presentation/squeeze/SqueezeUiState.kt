package com.example.lemonjuice.presentation.squeeze

import android.widget.TextView
import com.example.lemonjuice.views.action.ActionButton
import com.example.lemonjuice.views.action.ActionButtonUiState
import com.example.lemonjuice.views.image.ImageAction
import com.example.lemonjuice.views.image.ImageUiState
import com.example.lemonjuice.presentation.text.TitleUiState
import com.squareup.wire.internal.Serializable

interface SqueezeUiState : Serializable{

    fun update(
        textView: TextView,
        imageButton: ImageAction,
        actionButton: ActionButton
    ) = Unit

    object Empty : SqueezeUiState


    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : SqueezeUiState {
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

    data class SqueezeUp(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState,
    ) : Abstract(title, image, button)

    data class SqueezeOff(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState,
    ) : Abstract(title, image, button)

}
