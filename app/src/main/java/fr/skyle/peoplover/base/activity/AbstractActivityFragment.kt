package fr.skyle.peoplover.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import fr.skyle.peoplover.R

/**
 * Created by Openium on 20/03/2018.
 */

abstract class AbstractActivityFragment(
    @LayoutRes var layoutId: Int? = null,
    var fragment: Fragment
) : AbstractActivity(layoutId ?: R.layout.container_toolbar) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDefaultFragment()
    }

    protected open fun addDefaultFragment() {
        val fragmentManager = supportFragmentManager
        val previousFragment = fragmentManager.findFragmentById(containerId)
        if (previousFragment == null) {
            fragment.arguments = intent?.extras
            fragmentManager.beginTransaction().replace(containerId, fragment).commit()
        }
    }

    // Retourne l'id de la vue qui contient le fragment
    protected open val containerId: Int = R.id.container_framelayout
}
