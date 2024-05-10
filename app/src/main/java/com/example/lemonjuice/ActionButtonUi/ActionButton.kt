package com.example.lemonjuice.ActionButtonUi

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class ActionButton : AppCompatButton, UpdateActionButton {

  //  fun handleAction(viewModel: Actions): SqueezeUiState = actionButtonUiState.handleAction(viewModel)

    private lateinit var actionButtonUiState: ActionButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

/*    fun updateUiState(outer: ActionButtonUiState) {
        actionButtonUiState = outer
        actionButtonUiState.update(this)

    }*/


    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionButtonSavesState(it)
            state.save(actionButtonUiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionButtonSavesState
        super.onRestoreInstanceState(restoredState.superState)
        updateActionButton(restoredState.restore())
    }

    override fun updateActionButton(outer: ActionButtonUiState) {
        actionButtonUiState = outer
        actionButtonUiState.update(this)
    }

    override fun updateText(textId: Int) {
        setText(textId)
    }

    override fun updateEnabled(enabled: Boolean) {
        isEnabled = enabled
    }
}

interface UpdateActionButton {

    fun updateActionButton (outer: ActionButtonUiState)

    fun updateText(textId: Int)
    fun updateEnabled(enabled: Boolean)

}