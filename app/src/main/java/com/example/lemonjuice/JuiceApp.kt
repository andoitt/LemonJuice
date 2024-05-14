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

        private val error = Error() // єто наша else ветка которая была : и when . и  if else

        // Error єто нашe финальное звено - цепочки ( chain ) т.к. кто-то должен быть последним.
        // И мы его отдаём в следующее звено ( начинаем с него)
        private val main = ProvideMainViewModel(core, error)

        private val squeeze = ProvideSqueezeViewModel(core, main)
        override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {

            return squeeze.viewModel(clazz) // -> и выглядит это так: когда нужно будет создать ViewModelky , мы проверяем с этой линии кода,идём в проверку ->
            // ( return if (clazz == SqueezeViewModel::class.java))  если это SqueezeViewModel я создам б если нет ->
            //  else    provideOther.viewModel(clazz) - то создаст кто-то другой ( оставшиеся ВьюМодельки)
        }
    }
}

class Error : ProvideViewModel {
    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        throw IllegalStateException("unknown viewModel $clazz go and add it to ProvideViewModel.Make")
    }
}

class ProvideMainViewModel(
    private val core: Core,
    private val provideOther: ProvideViewModel
) : ProvideViewModel {
    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return if (clazz == MainViewModel::class.java)
            MainModule(core).viewModel() as T
        else
            provideOther.viewModel(clazz)
    }
}

class ProvideSqueezeViewModel(
    private val core: Core,
    private val provideOther: ProvideViewModel
) : ProvideViewModel {
    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return if (clazz == SqueezeViewModel::class.java)
            SqueezeModule(core).viewModel() as T
        else
            provideOther.viewModel(clazz)
    }
}


interface Module<T : MyViewModel> {

    fun viewModel(): T
}


class MainModule(private val core: Core) : com.example.lemonjuice.Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel(MainRepository.Base(core.lastScreen))
    }

}

class SqueezeModule(private val core: Core) : com.example.lemonjuice.Module<SqueezeViewModel> {
    override fun viewModel(): SqueezeViewModel = with(core) {
        return SqueezeViewModel(
            Repository.Base(lastScreen, currentTimesClicked)
        )
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
