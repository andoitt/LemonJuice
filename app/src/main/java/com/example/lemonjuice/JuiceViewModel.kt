package com.example.lemonjuice

class JuiceViewModel(
    private val repository: Repository
) : Actions {

    fun init(): UiState = UiState.Initial(
        title = TitleUiState.Initial,
        image = ImageUiState.Initial,
        button = ActionButtonUiState.Initial,
    )


    override fun goToSqueeze(): UiState = UiState.Squeeze(
        title = TitleUiState.Squeeze,
        image = ImageUiState.Squeeze,
        button = ActionButtonUiState.Squeeze,
    )

    fun handleImage(): UiState {
        repository.addCounter()
        return if (repository.isMax()) {
            UiState.Process(
                title = TitleUiState.Process,
                image = ImageUiState.Process,
                button = ActionButtonUiState.Process,
            )
        } else {
            UiState.Squeeze(
                title = TitleUiState.Squeeze,
                image = ImageUiState.Squeeze,
                button = ActionButtonUiState.Squeeze,

                )
        }
    }


    override fun goToMade(): UiState =
        UiState.Made(
            title = TitleUiState.Made,
            image = ImageUiState.Made,
            button = ActionButtonUiState.Made,
        )


    override fun goToFinish(): UiState = UiState.Finish(
        title = TitleUiState.Finish,
        image = ImageUiState.Finish,
        button = ActionButtonUiState.Finish,
    )

    override fun startAgain(): UiState {
        repository.reset()
        return init()
    }
}

interface Actions {

    fun goToSqueeze(): UiState
    fun goToMade(): UiState
    fun goToFinish(): UiState
    fun startAgain(): UiState

}