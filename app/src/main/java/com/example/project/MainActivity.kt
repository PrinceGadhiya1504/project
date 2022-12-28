package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.project.Adapter.MovieAdapter
import com.example.project.models.Movie

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = arrayOf(
            Movie(1,"RRR1","movie.png","The Beginning 2011 Full Movie","100"),
            Movie(2,"RRR2","movie.png","The Beginning 2012 Full Movie","200"),
            Movie(3,"RRR3","movie.png","The Beginning 2013 Full Movie","300"),
            Movie(4,"RRR4","movie.png","The Beginning 2014 Full Movie","400"),
            Movie(5,"RRR5","movie.png","The Beginning 2015 Full Movie","500")
        )

        val adapter = MovieAdapter(this,movies)
        val lstMovies = findViewById<ListView>(R.id.lstMovie)
        lstMovies.adapter = adapter
    }
}