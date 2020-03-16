package fr.skyle.peoplover.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by Openium on 19/02/2019.
 */

abstract class AbstractFragment : Fragment() {

    protected abstract val layoutId: Int

    // --- Life Cycle
    // ---------------------------------------------------

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layoutId, container, false)
}
