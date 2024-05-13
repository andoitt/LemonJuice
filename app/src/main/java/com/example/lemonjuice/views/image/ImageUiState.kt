package com.example.lemonjuice.views.image

import androidx.annotation.DrawableRes
import com.example.lemonjuice.R
import java.io.Serializable

interface ImageUiState : Serializable {
    fun update(imageButton: ImageAction)


    abstract class Abstract(
        @DrawableRes private val resId: Int,
        private val isClickable: Boolean = false
    ) : ImageUiState {
        override fun update(imageButton: ImageAction) {
            imageButton.updateUi(isClickable, resId)
            /*     imageButton.setImageResource(resId)
                 imageButton.isClickable = isClickable*/
        }
    }

    object SqueezeUp : Abstract(isClickable = true, resId = R.drawable.lemon)

    object SqueezeOff : Abstract(resId = R.drawable.lemon)

    object Initial : Abstract(resId = R.drawable.tree)


    object Squeeze : Abstract(resId = R.drawable.lemon, true)

    object Process : Abstract(resId = R.drawable.lemon)

    object Made : Abstract(resId = R.drawable.lemonade)

    object Finish : Abstract(resId = R.drawable.glass)


}


