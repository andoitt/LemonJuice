package com.example.lemonjuice

import com.example.lemonjuice.presentation.squeeze.SqueezeViewModel
import com.example.lemonjuice.data.Repository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


/**
 * Test Case #1 :  Сorrect step
 *
 *
1. Нажать на кнопку next ,
-> отображается состояние MakeJuice

3. Кликнуть 5 раз по imageButton ,
-> отображается состояние SqueezeState

4. кликнуть кнопку next ,

отображается  ->  SqueezeProcessState,

5. кликнуть кнопку next ,

отображается состояние FinishState


6.кликнуть кнопку next ,

отображается изначальное состояние InitialState
 */
class SqueezeViewModelTest {

    private lateinit var repository: FakeRepository
    private lateinit var viewModel: SqueezeViewModel

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = SqueezeViewModel(
            repository = repository
        )
    }

    @Test
    fun caseNumberOne() {

      /*  var actual: UiState = viewModel.init()
        var expected: UiState = UiState.Initial(
            title = TitleUiState.Initial,
            image = ImageUiState.Initial,
            button = ActionButtonUiState.Initial,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToSqueeze()
        expected = UiState.Squeeze(
            title = TitleUiState.Squeeze,
            image = ImageUiState.Squeeze,
            button = ActionButtonUiState.Squeeze,

            )
        assertEquals(expected, actual)


        repeat(5) {
            assertEquals(expected, actual)
            actual = viewModel.handleImage()

        }

        expected = UiState.Process(
            title = TitleUiState.Process,
            image = ImageUiState.Process,
            button = ActionButtonUiState.Process,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToMade()
        expected = UiState.Made(
            title = TitleUiState.Made,
            image = ImageUiState.Made,
            button = ActionButtonUiState.Made,
        )
        assertEquals(expected, actual)


        actual = viewModel.goToFinish()
        expected = UiState.Finish(
            title = TitleUiState.Finish,
            image = ImageUiState.Finish,
            button = ActionButtonUiState.Finish,
        )
        assertEquals(expected, actual)


        actual = viewModel.startAgain()
        expected = UiState.Initial(
            title = TitleUiState.Initial,
            image = ImageUiState.Initial,
            button = ActionButtonUiState.Initial,
        )
        assertEquals(expected, actual)*/

    }

    @Test
    fun testExit() {
        viewModel.exit()
        assertEquals(1,repository.resetCount)
    }
}

private class FakeRepository : Repository {

    private var currentTimesClicked = 0
    var resetCount: Int = 0

    override fun addCounter() {
        currentTimesClicked++
    }

    override fun isMax(): Boolean {
        return currentTimesClicked == 5
    }

    override fun reset() {
        currentTimesClicked = 0
        resetCount++
    }

    override fun saveCurrentScreen() {
        TODO("Not yet implemented")
    }
}


