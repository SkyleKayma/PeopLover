package fr.skyle.peoplover.ui.main

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import fr.skyle.peoplover.R
import fr.skyle.peoplover.base.fragment.AbstractFragment
import fr.skyle.peoplover.model.entity.PeopLove
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FragmentMain : AbstractFragment() {

    override val layoutId: Int = R.layout.fragment_main

    private val model by viewModel<ViewModelMain>()

    private var adapterMain: AdapterMain? = null

    // --- Life cycle
    // ---------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initAdapter()
        updateData()
    }

    // --- Methods
    // ---------------------------------------------------

    private fun initAdapter() {
        adapterMain = AdapterMain(listOf()) {

        }

        recyclerViewPeopLove.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMain
        }
    }

    private fun updateData() {
        lifecycleScope.launch {
            val time = System.currentTimeMillis()

            model.insertPeopLoves(
                listOf(
                    PeopLove(0, "Chloé", time, time),
                    PeopLove(1, "Julie", time, time),
                    PeopLove(2, "Mélanie", time, time),
                    PeopLove(3, "Aurélie", time, time)
                )
            )
            adapterMain?.refreshData(model.getPeopLoves())
        }
    }
}