package com.example.lemonjuice.views.action

import androidx.annotation.StringRes
import com.example.lemonjuice.R
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun update(button: UpdateActionButton)

    abstract class Abstract(
        private val isEnabled: Boolean = true,
        @StringRes private val resId: Int,
    ) : ActionButtonUiState {

        override fun update(button: UpdateActionButton) {
            button.updateEnabled(isEnabled)
            button.updateText(resId)
        }
    }

    object Initial : Abstract(resId = R.string.select_lemon)

    object SqueezeUp : Abstract(isEnabled = false, resId = R.string.squeeze_lemon)

    object SqueezeOff : Abstract(resId = R.string.squeeze_lemon)

    object Squeeze : Abstract(isEnabled = false, resId = R.string.squeeze_lemon)


    object Process : Abstract(resId = R.string.squeeze_lemon)
}
