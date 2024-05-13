package com.example.lemonjuice.views.image

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageButton

class ImageButton : AppCompatImageButton, ImageAction {


    private lateinit var ImageUiState: ImageUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )


    override fun updateUiState(outer: ImageUiState) {
        ImageUiState = outer
        ImageUiState.update(this)
    }

    override fun updateUi(clickable: Boolean, imageResource: Int) {
        isClickable = clickable
        setImageResource(imageResource)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ImageSavedState(it)
            state.save(ImageUiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ImageSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }

}
    interface ImageAction {

        fun updateUiState(outer: ImageUiState)

        fun updateUi(clickable: Boolean, @DrawableRes imageResource: Int)
    }
