package com.example.project

import android.content.Context
import android.content.Intent
import com.example.project.Adapter.MovieAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.models.ImageUrl
import com.example.project.models.Movies
import com.example.project.services.MovieService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection


class movie_list_view : AppCompatActivity()
{
    private lateinit var movieService: MovieService
    private lateinit var imageUrl: ImageUrl
    private lateinit var recmovielist: RecyclerView
    private lateinit var MoviesList: ArrayList<Movies>
    private lateinit var MovieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        imageUrl = ImageUrl()
        recmovielist = findViewById(R.id.recmovielist)

        configureData()
    }

    private fun configureData()
    {
        CoroutineScope(Dispatchers.IO).launch {
            movieService = MovieService()
            val response = movieService.getAllMovie()

            if (response.code == HttpURLConnection.HTTP_NOT_FOUND)
            {
                Toast.makeText(this@movie_list_view,"No Data Found", Toast.LENGTH_LONG).show()
            }

            MoviesList = ArrayList()
            val movies = Gson().fromJson(response.message, Array<Movies>::class.java)

            for (movie in movies)
            {
                GlobalScope.launch (Dispatchers.Main){
                    MoviesList.add(
                        Movies(
                            Id = movie.Id,
                            Name = movie.Name,
                            Description = movie.Description,
                            ReleaseDate = movie.ReleaseDate,
                            Language = movie.Language,
                            TicketPrice = movie.TicketPrice,
                            ImageName = imageUrl.ImageBaseUrl.plus(movie.ImageName)
                        )
                    )
                    MovieAdapter = MovieAdapter(this@movie_list_view, MoviesList, object : MovieAdapter.OnItemClickListener{
                        override fun onClick(movie: Movies)
                        {
                            val intent = Intent(this@movie_list_view, movie_list_view::class.java)
                            intent.putExtra("movieId", movie.Id)
                            startActivity(intent)
                        }
                    })

                    recmovielist.layoutManager = GridLayoutManager(this@movie_list_view, 1)
                    recmovielist.adapter = MovieAdapter
                }
            }
        }

    }
}