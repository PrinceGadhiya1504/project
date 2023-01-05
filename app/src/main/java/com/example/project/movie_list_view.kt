package com.example.project

import Movie
import com.example.project.Adapter.MovieAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class movie_list_view : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val courseRV = findViewById<RecyclerView>(R.id.recmovielist)

        // Here, we have created new array list and added data to it
        val courseModelArrayList: ArrayList<Movie> = ArrayList<Movie>()
        courseModelArrayList.add(Movie("RRR1",R.drawable.rrr_poster,"SS RAJAMOULI","100"))
        courseModelArrayList.add(Movie("RRR2",R.drawable.rrr_poster,"SS RAJAMOULI","200"))
        courseModelArrayList.add(Movie("RRR3",R.drawable.rrr_poster,"SS RAJAMOULI","300"))
        courseModelArrayList.add(Movie("RRR4",R.drawable.rrr_poster,"SS RAJAMOULI","400"))
        courseModelArrayList.add(Movie("RRR5",R.drawable.rrr_poster,"SS RAJAMOULI","500"))


        // we are initializing our adapter class and passing our arraylist to it.
        val courseAdapter = MovieAdapter(this, courseModelArrayList)

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.layoutManager = linearLayoutManager
        courseRV.adapter = courseAdapter


    }
}