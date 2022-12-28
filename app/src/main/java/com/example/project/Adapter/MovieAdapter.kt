package com.example.project.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.project.R
import com.example.project.models.Movie

class MovieAdapter(
        private val activity: Activity,
        private val persons: Array<Movie>
) : ArrayAdapter<Movie>(activity, R.layout.activity_movie, persons)
{
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
        {
                var view = convertView
                if (view == null)
                {
                        view = LayoutInflater.from(activity).inflate(R.layout.activity_movie, null)

                        val viewHolder = ViewHolder()
                        viewHolder.image = view!!.findViewById(R.id.image)
                        viewHolder.txttitle = view.findViewById(R.id.txttitle)
                        viewHolder.txtdescription = view.findViewById(R.id.txtdescription)
                        viewHolder.txtprice = view.findViewById(R.id.txtprice)

                        view.tag = viewHolder
                }

                val existingViewHolder = view.tag as ViewHolder

                existingViewHolder.image.setImageResource(R.drawable.movie)
                existingViewHolder.txttitle.text = persons[position].Name
                existingViewHolder.txtdescription.text = persons[position].Description.toString()
                existingViewHolder.txtprice.text = persons[position].TicketPrice.toString()

                return view
        }

        class ViewHolder
        {
                lateinit var image: ImageView
                lateinit var txttitle: TextView
                lateinit var txtdescription: TextView
                lateinit var txtprice: TextView
        }
}