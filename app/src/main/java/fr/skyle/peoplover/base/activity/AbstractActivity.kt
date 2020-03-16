package fr.skyle.peoplover.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import fr.skyle.peoplover.R
import fr.skyle.peoplover.base.OnBackPressedListener
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by Openium on 20/03/2018.
 */

abstract class AbstractActivity(@LayoutRes layout: Int) : AppCompatActivity(layout) {

    protected open val handleFragmentBackPressed: Boolean = true

    protected open val showHomeAsUp: Boolean = false

    // --- Life cycle
    // ---------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbar?.also {
            setSupportActionBar(it)
        }

        setHomeAsUp(showHomeAsUp)
    }

    protected fun setHomeAsUp(enabled: Boolean = true) {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(enabled)
            setHomeButtonEnabled(enabled)
        }
    }

    override fun onBackPressed() {
        if (handleFragmentBackPressed) {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.container_framelayout)
            if (currentFragment !is OnBackPressedListener || !currentFragment.onBackPressed()) {
                super.onBackPressed()
            }
        } else super.onBackPressed()
    }
}