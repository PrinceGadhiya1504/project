package com.example.project.Adapter

import Movie
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R


class MovieAdapter(private val context: Context, courseModelArrayList: ArrayList<Movie>) :
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
        private val courseModelArrayList: ArrayList<Movie>
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
        {
                // to inflate the layout for each item of recycler view.
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_movie_list_view, parent, false)
                return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                // to set data to textview and imageview of each card layout
                val model: Movie = courseModelArrayList[position]
                holder.name.text = model.getName()
                holder.image.setImageResource(model.getImage())
                holder.description.text = model.getDescription()
                holder.price.text = model.getPrice()
        }

        override fun getItemCount(): Int {
                // this method is used for showing number of card items in recycler view.
                return courseModelArrayList.size
        }

        // View holder class for initializing of your views such as TextView and Imageview.
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val name : TextView
                val image: ImageView
                val description: TextView
                val price: TextView

                init {
                        name = itemView.findViewById(R.id.txttitle)
                        image = itemView.findViewById(R.id.image)
                        description = itemView.findViewById(R.id.txtdescription)
                        price = itemView.findViewById(R.id.txtprice)
                }
        }

        // Constructor
        init {
                this.courseModelArrayList = courseModelArrayList
        }
}
