package com.example.lemonjuice

import androidx.annotation.DrawableRes
import java.io.Serializable

interface ImageUiState : Serializable {
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

    object Initial : Abstract(resId = R.drawable.tree)


    object Squeeze : Abstract(resId = R.drawable.lemon, true)


    object Process : Abstract(resId = R.drawable.lemon)


    object Made : Abstract(resId = R.drawable.lemonade)


    object Finish : Abstract(resId = R.drawable.glass)

}


