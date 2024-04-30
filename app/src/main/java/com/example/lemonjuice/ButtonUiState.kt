package com.example.lemonjuice

import android.widget.Button
import androidx.annotation.StringRes

interface ButtonUiState {
    fun update(mainButton: Button)

    abstract class Abstract(
        @StringRes private val resId: Int = R.string.next,
        private val enabled: Boolean = true
    ) : ButtonUiState {
        override fun update(mainButton: Button) {
            mainButton.setText(resId)
            mainButton.isEnabled = enabled
        }
    }
    object Initial : Abstract() {

    }

    object Squeeze : Abstract(enabled = false) {

    }

    object Process :Abstract()  {

    }

    object Made : Abstract() {

    }

    object Finish : Abstract(resId = R.string.start_again)  {

    }
}




