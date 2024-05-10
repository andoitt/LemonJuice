package com.example.lemonjuice

import com.example.lemonjuice.ActionButtonUi.ActionButton
import com.example.lemonjuice.ActionButtonUi.ActionButtonUiState
import com.example.lemonjuice.ImageButtonUi.ImageAction
import com.example.lemonjuice.ImageButtonUi.ImageUiState
import com.example.lemonjuice.TextViewUi.TitleUiState
import com.example.lemonjuice.TextViewUi.UpdateText
import org.junit.Test

class SqueezeFragmentUiStateTest() {

    @Test
    fun Test() {
        val initial = UiState.Initial(TitleUiState.Initial,ImageUiState.Initial,ActionButtonUiState.Initial)
        initial.update(FakeTextView(), FakeImageButton() ,  FakeActionButton)
    }

}

private class FakeTextView() : UpdateText {
    override fun updateText(resId: Int) {
        TODO("Not yet implemented")
    }
}
private abstract class FakeImageButton() : ImageAction {
    override fun updateText(resId: Int) {
        TODO("Not yet implemented")
    }
}

private class FakeActionButton() : ActionButton {
    override fun updateText(resId: Int) {
        TODO("Not yet implemented")
    }

    override fun updateEnabled(enabled: Boolean) {
        TODO("Not yet implemented")
    }
}