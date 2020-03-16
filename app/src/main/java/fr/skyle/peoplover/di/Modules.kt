package fr.skyle.peoplover.di

import com.google.firebase.crashlytics.FirebaseCrashlytics
import fr.skyle.peoplover.BuildConfig
import fr.skyle.peoplover.event.ForegroundBackgroundListener
import fr.skyle.peoplover.model.PLClient
import fr.skyle.peoplover.repository.PeopLoveRepository
import fr.skyle.peoplover.ui.main.ViewModelMain
import fr.skyle.peoplover.utils.DateUtils
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Openium on 20/03/2018.
 */

object Modules {

    val configModule = module {
        single {
            FirebaseCrashlytics.getInstance().apply {
                setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
            }
        }
    }

    val serviceModule = module {
        single {
            ForegroundBackgroundListener(androidContext())
        }
        single {
            DateUtils(androidContext())
        }
    }

    val databaseModule = module {
        single {
            PLClient.getInstance(androidContext())
        }
    }

    val daoModule = module {
        single {
            get<PLClient>().database.peopLoveDao()
        }
    }

    val repositoryModule = module {
        single {
            PeopLoveRepository(get())
        }
    }

    val viewModelModule = module {
        viewModel {
            ViewModelMain(get())
        }
    }
}