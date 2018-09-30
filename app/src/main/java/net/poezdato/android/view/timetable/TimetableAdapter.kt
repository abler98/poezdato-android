package net.poezdato.android.view.timetable

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.timetable_list_item.view.*
import net.poezdato.android.R
import net.poezdato.android.data.entity.Timetable
import net.poezdato.android.kotlin.inflate
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Author: Sergey Semenko <abler98@gmail.com>
 * Created at 29.09.2018.
 */

class TimetableAdapter(private val timetable: Timetable) :
    RecyclerView.Adapter<TimetableAdapter.TimetableViewHolder>() {

    private val timeFormatter = SimpleDateFormat("HH.mm", Locale.ROOT)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): TimetableViewHolder {
        return TimetableViewHolder(parent.inflate(R.layout.timetable_list_item))
    }

    override fun getItemCount(): Int {
        return timetable.items.size
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        val item = timetable.items[position]
        holder.trainNumber?.text = item.train.number
        holder.originTime?.text = timeFormatter.format(item.origin.time)
        holder.originName?.text = item.origin.station.name
        holder.destinationTime?.text = timeFormatter.format(item.destination.time)
        holder.destinationName?.text = item.destination.station.name
        holder.duration?.text = holder.itemView.context.getString(
            R.string.timetable_duration_text,
            item.getDuration(TimeUnit.MINUTES)
        )
    }

    class TimetableViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val trainNumber: TextView? = view.trainNumber
        val originTime: TextView? = view.originTime
        val originName: TextView? = view.originName
        val destinationTime: TextView? = view.destinationTime
        val destinationName: TextView? = view.destinationName
        val duration: TextView? = view.duration
    }

}
