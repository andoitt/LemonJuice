package com.example.lemonjuice

import android.widget.Button
import androidx.annotation.StringRes
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun update(actionButton: Button)

    fun handleAction(viewModel: Actions): UiState
    fun updateUiState(button: ActionButtonUiState) {
        TODO("Not yet implemented")
    }

    abstract class Abstract(
        private val isEnabled: Boolean = true,
        @StringRes private val resId: Int,
    ) : ActionButtonUiState {

        override fun update(actionButton: Button) {
            actionButton.isEnabled = isEnabled
            actionButton.setText(resId)
        }
    }

    object Initial : Abstract(resId = R.string.select_lemon) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToSqueeze()
        }

    }

    object Squeeze : Abstract(isEnabled = false, resId = R.string.squeeze_lemon) {
        override fun handleAction(viewModel: Actions): UiState = throw IllegalStateException("")
    }

    object Process : Abstract(resId = R.string.squeeze_lemon) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToMade()
        }
    }

    object Made : Abstract(resId = R.string.drink) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToFinish()
        }
    }

    object Finish : Abstract(resId = R.string.start_again) {
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.startAgain()
        }
    }

}


