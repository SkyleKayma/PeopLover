package fr.skyle.peoplover.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import fr.skyle.peoplover.R
import fr.skyle.peoplover.base.activity.AbstractActivityFragment
import fr.skyle.peoplover.utils.StatusBarUtils

class ActivityMain : AbstractActivityFragment(layoutId = R.layout.container_no_toolbar, fragment = FragmentMain()) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set statusBar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StatusBarUtils.setStatusBarColor(this, R.color.autoColorWhite)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}