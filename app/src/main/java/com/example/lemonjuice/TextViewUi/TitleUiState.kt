package com.example.lemonjuice.TextViewUi

import android.widget.TextView
import androidx.annotation.StringRes
import com.example.lemonjuice.R

interface TitleUiState {
    fun update(titleTextView: TextView)
  //  fun update(titleTextView: UpdateText)

    abstract class Abstract(@StringRes private val resId: Int): TitleUiState {
        override fun update(titleTextView: TextView) {
            titleTextView.setText(resId)
          //  titleTextView.updateText(resId)
        }
    }


    object SqueezeUp : Abstract(R.string.select_lemon)
    object SqueezeOff : Abstract(R.string.select_lemon)

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
