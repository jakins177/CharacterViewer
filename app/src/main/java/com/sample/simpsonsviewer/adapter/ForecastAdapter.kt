package com.sample.simpsonsviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpsonsviewer.R
import com.sample.simpsonsviewer.model.ForecastDetails
import com.sample.simpsonsviewer.model.Weather


class ForecastAdapter(
    private val dataSet:
    List<ForecastDetails>? = mutableListOf(),
    private val listener: (ForecastDetails) -> Unit
) :
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ForecastViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.forecast_row_item, viewGroup, false)

        return ForecastViewHolder(view)
    }


    override fun getItemCount() = dataSet?.size ?: 0


    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       // private var tempTextView: TextView = itemView.findViewById(R.id.temp_textview)
        private var conTextView: TextView = itemView.findViewById(R.id.name_textview)

        fun updateInfo(item: ForecastDetails?) {
            if (item != null && item.weather != null) {

                var weather: Weather = item.weather[0]

             //   tempTextView.text = "Temp: ${item.main?.temp.toString()}"
                conTextView.text = weather.main.toString()

            };
        }
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)

        holder.itemView.setOnClickListener {
            if (item != null) {
                listener(item)
            }
        }

    }


}