package fr.skyle.peoplover

import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

/**
 * Created by Openium on 20/03/2018.
 */
class ApplicationImpl : CustomApplication() {

    override fun initTimber(firebaseCrashlytics: FirebaseCrashlytics) {
        Timber.plant(Timber.DebugTree())
    }
}