package fr.skyle.peoplover.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import fr.skyle.peoplover.R
import fr.skyle.peoplover.model.entity.PeopLove
import fr.skyle.peoplover.utils.DateUtils
import kotlinx.android.synthetic.main.item_main.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject


/**
 * Created by Openium on 19/02/2019.
 */
class AdapterMain(
    private var data: List<PeopLove>,
    private val onItemClick: ((PeopLove) -> Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), KoinComponent {

    private val dateUtils by inject<DateUtils>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PeopLoveHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val peopLove = data[position]

        holder.itemView.textViewItemPeopLoveName.text = peopLove.name ?: ""
        holder.itemView.textViewItemPeopLoveMeetingDate.text =
            holder.itemView.context.getString(
                R.string.main_added_at_format,
                dateUtils.format(DateUtils.Format.PRESENTER_DATE_AND_TIME, peopLove.meetingDate)
            )

        holder.itemView.imageViewItemPeopLove.load("https://picsum.photos/100") {
            crossfade(true)
            placeholder(R.drawable.ic_user_placeholder)
        }

        holder.itemView.setOnClickListener {
            onItemClick.invoke(peopLove)
        }
    }

    override fun getItemCount(): Int = data.count()

    fun refreshData(peopLoves: List<PeopLove>) {
        data = peopLoves
        notifyDataSetChanged()
    }

    class PeopLoveHolder(view: View) : RecyclerView.ViewHolder(view)
}