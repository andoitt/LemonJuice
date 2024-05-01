package com.example.lemonjuice

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton

class ImageButton : AppCompatImageButton {


    private lateinit var uiState: ImageUiState

    constructor(context: Context) : super(context)
    constructor(context: Context,attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context,attributeSet: AttributeSet, defStyleAttrs: Int) : super(context,attributeSet,  defStyleAttrs)


   // fun handleAction(viewModel: Actions) : UiState = uiState.handleAction(viewModel)

    fun updateUiState(outer: ImageUiState){
        uiState = outer


    }
    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ImageSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ImageSavedState
        super.onRestoreInstanceState(state)
        updateUiState(restoredState.restore())
    }

    override fun setImageResource(resId: Int) {

    }

}