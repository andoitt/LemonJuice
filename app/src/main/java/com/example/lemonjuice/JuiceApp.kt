package com.example.lemonjuice

import android.app.Application
import android.content.Context
import com.example.lemonjuice.presentation.squeeze.SqueezeViewModel
import com.example.lemonjuice.presentation.main.MainViewModel
import com.example.lemonjuice.data.IntCache
import com.example.lemonjuice.data.MainRepository
import com.example.lemonjuice.data.PermanentStorage
import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.data.StringCache
import com.example.lemonjuice.presentation.main.MyViewModel
import com.example.lemonjuice.presentation.squeeze.SqueezeScreen
import com.google.inject.Module

class JuiceApp : Application(), ManageViewModels {

    /* lateinit var mainViewModel: MainViewModel
     lateinit var viewModel: SqueezeViewModel
     lateinit var lastScreen: StringCache*/

    private lateinit var factory: ManageViewModels

    override fun onCreate() {
        super.onCreate()
        factory = ProvideViewModel.Factory(ProvideViewModel.Make(Core(this)))

    }

    override fun clear(clazz: Class<out MyViewModel>) {
        factory.clear(clazz)
    }

    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return factory.viewModel(clazz)
    }
}

interface ClearViewModel {

    fun clear(clazz: Class<out MyViewModel>)
}

interface ManageViewModels : ClearViewModel, ProvideViewModel

interface ProvideViewModel {

    fun <T : MyViewModel> viewModel(clazz: Class<T>): T

    class Factory(
        private val make: ProvideViewModel
    ) : ManageViewModels {

        private val mutableMap = mutableMapOf<Class<out MyViewModel>, MyViewModel?>()

        override fun clear(clazz: Class<out MyViewModel>) {
            mutableMap[clazz] = null  // mb remove
        }

        override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
            return if (mutableMap[clazz] == null) {
                val viewModel = make.viewModel(clazz)
                mutableMap[clazz] = viewModel
                viewModel
            } else
                mutableMap[clazz] as T
        }
    }

    class Make(private val core: Core) : ProvideViewModel {
        override fun <T : MyViewModel> viewModel(clazz: Class<T>): T = with(core) {
            return when (clazz) {
                MainViewModel::class.java -> MainViewModel(MainRepository.Base(lastScreen))

                SqueezeViewModel::class.java -> SqueezeViewModel(
                    Repository.Base(
                        lastScreen,
                        currentTimesClicked,
                    )
                )

                else -> throw IllegalStateException("unknown viewModel $clazz go and add it to ProvideViewModel.Make")
            } as T
        }
    }
}

class Core(context: Context) {
    val lastScreen: StringCache
    val currentTimesClicked: IntCache
    val permanentStorage: PermanentStorage

    init {
        val runUiTest = BuildConfig.DEBUG
        val name = if (runUiTest) "uitestname" else context.getString(R.string.app_name)

        permanentStorage = PermanentStorage.Base(
            context.getSharedPreferences(
                name, Context.MODE_PRIVATE
            )
        )

        lastScreen = StringCache.Base(
            "lastScreen",
            permanentStorage,
            SqueezeScreen::class.java.canonicalName
        )

        currentTimesClicked = IntCache.Base("currentClicks", permanentStorage, 0)

    }
}

/*
abstract class ProvideAbstract(
    protected val core: Core,
    private val nextChain: ProvideViewModel,
    private val viewModelClass: Class<out MyViewModel>
) : ProvideViewModel {

    protected abstract fun module(): Module<out MyViewModel>



}

interface Module < T : MyViewModel> {

    fun viewModel(): T
}



class MainModule(private val core: Core) : com.example.lemonjuice.Module<MainViewModel> {

}

class SqueezeModule(private val core: Core) : Module<SqueezeViewModel> {


}

class ProvideSqueezeViewModel(
    core: Core,
    provideOther: ProvideViewModel,
): {

}
*/
