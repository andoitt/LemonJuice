package com.example.lemonjuice

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class ActionButtonSavesState : View.BaseSavedState {

    //  View.BaseSavedState

    private lateinit var state: ActionButtonUiState

    constructor(superState: Parcelable) : super(superState)


    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ActionButtonUiState::class.java.classLoader,
                ActionButtonUiState::class.java
            ) as ActionButtonUiState
        } else {
            parcelIn.readSerializable() as ActionButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore() : ActionButtonUiState = state

    fun save(uiState: ActionButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ActionButtonSavesState> {
        override fun createFromParcel(parcel: Parcel): ActionButtonSavesState =
            ActionButtonSavesState(parcel)

        override fun newArray(size: Int): Array<ActionButtonSavesState?> =
            arrayOfNulls(size)
    }
}