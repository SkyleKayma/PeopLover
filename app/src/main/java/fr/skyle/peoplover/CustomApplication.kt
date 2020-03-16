package fr.skyle.peoplover

import android.app.Application
import androidx.preference.PreferenceManager
import com.google.firebase.crashlytics.FirebaseCrashlytics
import fr.skyle.peoplover.di.Modules
import fr.skyle.peoplover.log.FirebaseCrashlyticsTree
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by Openium on 20/03/2018.
 */

abstract class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CustomApplication)
            modules(
                listOf(
                    Modules.configModule,
                    Modules.serviceModule,
                    Modules.databaseModule,
                    Modules.viewModelModule,
                    Modules.daoModule,
                    Modules.repositoryModule
                )
            )
        }

        val firebaseCrashlytics: FirebaseCrashlytics by inject()

        initTimber(firebaseCrashlytics)
        saveActualBuildCode()
    }

    // --- Init methods
    // ---------------------------------------------------

    open fun initTimber(firebaseCrashlytics: FirebaseCrashlytics) {
        Timber.plant(FirebaseCrashlyticsTree(firebaseCrashlytics))
    }

    private fun saveActualBuildCode() {
        PreferenceManager.getDefaultSharedPreferences(applicationContext).apply {
            val currentBuildVersion = BuildConfig.VERSION_CODE
            val oldBuildVersion = getInt(KEY_BUILD_CODE, 0)

            Timber.i("[UPDATE] Old build code : $oldBuildVersion | Current build code: $currentBuildVersion")
            edit().putInt(KEY_BUILD_CODE, currentBuildVersion).apply()
        }
    }

    // --- Other methods
    // ---------------------------------------------------

    companion object {
        const val KEY_BUILD_CODE = "KEY_BUILD_CODE"
    }
}