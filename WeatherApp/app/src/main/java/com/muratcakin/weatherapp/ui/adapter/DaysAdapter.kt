package com.muratcakin.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muratcakin.weatherapp.R
import com.muratcakin.weatherapp.data.models.Model

class DaysAdapter: ListAdapter<Model, DaysAdapter.WeathersViewHolder>(DaysDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeathersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return WeathersViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeathersViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    class WeathersViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvDay = view.findViewById<TextView>(R.id.tvDay)
        private val ivIcon = view.findViewById<ImageView>(R.id.ivIcon)
        private val tvMaxTemp = view.findViewById<TextView>(R.id.tvMaxTemp)
        private val tvMinTemp = view.findViewById<TextView>(R.id.tvMinTemp)

        fun bind(model: Model) {
            tvDay.text = model.daily?.dt.toString()
            //ivIcon.setImageResource(model.daily.weather.icon.)
            tvMaxTemp.text = model.daily?.temp?.max.toString()
            tvMinTemp.text = model.daily?.temp?.min.toString()
        }

    }

    class DaysDiffUtil: DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem.daily == newItem.daily
        }

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
            return oldItem == newItem
        }

    }
}