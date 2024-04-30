package com.example.lemonjuice

import android.widget.ImageButton
import androidx.annotation.DrawableRes

interface ImageUiState {
    fun update(imageButton: ImageButton)

    abstract class Abstract(
        @DrawableRes private val resId: Int,
        private val isClickable: Boolean = false
    ) : ImageUiState {
        override fun update(imageButton: ImageButton) {
            imageButton.setImageResource(resId)
            imageButton.isClickable = isClickable
        }
    }

    object Initial : Abstract(R.drawable.tree) {

    }

    object Squeeze : Abstract(R.drawable.lemon, true) {

    }

    object Process : Abstract(R.drawable.lemon) {

    }

    object Made : Abstract(R.drawable.lemonade) {

    }

    object Finish : Abstract(R.drawable.glass) {

    }
}
