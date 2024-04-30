package com.example.lemonjuice

import android.widget.TextView
import androidx.annotation.StringRes

interface TitleUiState {
    fun update(titleTextView: TextView)

    abstract class Abstract(@StringRes private val resId: Int):TitleUiState {
        override fun update(titleTextView: TextView) {
            titleTextView.setText(resId)
        }
    }

    object Initial : Abstract(R.string.hint_select_lemon) {

    }

    object Squeeze : Abstract(R.string.squeeze_lemon) {

    }

    object Process : Abstract(R.string.squeeze_lemon) {

    }

    object Made : Abstract(R.string.hint_drink) {

    }

    object Finish :  Abstract(R.string.hint_start_again) {

    }

}
