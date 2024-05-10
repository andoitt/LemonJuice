package com.example.lemonjuice.fragmentSqueeze

import android.widget.TextView
import com.example.lemonjuice.ActionButtonUi.ActionButton
import com.example.lemonjuice.ActionButtonUi.ActionButtonUiState
import com.example.lemonjuice.ImageButtonUi.ImageAction
import com.example.lemonjuice.ImageButtonUi.ImageUiState
import com.example.lemonjuice.UiState
import com.example.lemonjuice.TextViewUi.TitleUiState
import com.squareup.wire.internal.Serializable

interface FragmentUiState : Serializable{

    fun update(
        textView: TextView,
        imageButton: ImageAction,
        actionButton: ActionButton
    ) = Unit

    object Empty : FragmentUiState {
        override fun update(
            textView: TextView,
            imageButton: ImageAction,
            actionButton: ActionButton
        ) = Unit
    }

    abstract class Abstract(
        private val title: TitleUiState,
        private val image: ImageUiState,
        private val button: ActionButtonUiState
    ) : FragmentUiState {
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
