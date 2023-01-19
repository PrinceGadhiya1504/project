package com.example.project.Adapter

import android.content.Context
import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.AdapterView.OnItemClickListener
import android.widget.ExpandableListView.OnChildClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.models.Movies
import com.example.project.movie
import java.nio.file.Files.size
import java.text.FieldPosition

class MovieAdapter(
    private var context: Context,
    private var Movie: ArrayList<Movies>,
    private var clickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.activity_movie_list_view, null, true)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.bind(Movie[position])
    }

    override fun getItemCount(): Int
    {
        return Movie.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private var image: ImageView = itemView.findViewById(R.id.image)
        private var title: TextView = itemView.findViewById(R.id.txttitle)
        private var description: TextView = itemView.findViewById(R.id.txtdescription)
        private var releasedate: TextView = itemView.findViewById(R.id.txtreleasedate)
        private var language: TextView = itemView.findViewById(R.id.txtlanguage)
        private var price: TextView = itemView.findViewById(R.id.txtprice)

        fun bind(movie: Movies)
        {
            Glide.with(context).load(movie.ImageName).into(image)

            title.text = movie.Name
            description.text = movie.Description
            releasedate.text = movie.ReleaseDate
            language.text = movie.Language
            price.text = movie.TicketPrice.toString()

            itemView.setOnClickListener { clickListener?.onClick(movie) }
        }
    }

    interface OnItemClickListener
    {
        fun onClick(movie: Movies)
    }


}