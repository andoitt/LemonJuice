package com.example.lemonjuice.ImageButtonUi

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class ImageSavedState : View.BaseSavedState {


    private lateinit var state: ImageUiState

    constructor(superState: Parcelable) : super(superState)


    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ImageUiState::class.java.classLoader,
                ImageUiState::class.java
            ) as ImageUiState
        } else {
            parcelIn.readSerializable() as ImageUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore() : ImageUiState = state

    fun save(uiState: ImageUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ImageSavedState> {
        override fun createFromParcel(parcel: Parcel): ImageSavedState =
            ImageSavedState(parcel)

        override fun newArray(size: Int): Array<ImageSavedState?> =
            arrayOfNulls(size)
    }
}