package fr.skyle.peoplover.utils

import android.app.Activity
import androidx.annotation.ColorRes
import fr.openium.kotlintools.ext.getColorCompat

object StatusBarUtils {

    fun setStatusBarColor(activity: Activity, @ColorRes idColor: Int) {
        activity.window?.statusBarColor = activity.applicationContext.getColorCompat(idColor)
    }

    fun setStatusBarColor(color: Int, activity: Activity) {
        activity.window?.statusBarColor = color
    }
}