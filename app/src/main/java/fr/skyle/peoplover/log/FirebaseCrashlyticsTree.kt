package fr.skyle.peoplover.log

import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

/**
 * Created by Openium on 20/03/2018.
 */

class FirebaseCrashlyticsTree(private val firebaseCrashlytics: FirebaseCrashlytics) : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        firebaseCrashlytics.log(message)
        t?.let { firebaseCrashlytics.recordException(it) }
    }
}