package com.example.lemonjuice.TextViewUi

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView : AppCompatTextView , UpdateText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateText(resId: Int) {
        setText(resId)
    }
}

interface UpdateText {
    fun updateText(@StringRes resId : Int)
}