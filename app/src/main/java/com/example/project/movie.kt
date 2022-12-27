package com.example.project

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.project.models.Movie
import com.example.project.models.User
import com.example.project.services.AuthService
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.net.HttpURLConnection

class movie : AppCompatActivity()
{
    private lateinit var authService: AuthService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        authService = AuthService()

        val image = findViewById<CardView>(R.id.image)
        val txttitle = findViewById<TextView>(R.id.txttitle)
        val txtdescription = findViewById<TextView>(R.id.txtdescription)
        val txtprice = findViewById<TextView>(R.id.txtprice)


            val images = image.toString()
            val name = txttitle.text.toString()
            val description = txtdescription.text.toString()
            val price = txtprice.text.toString()
            val movie = Movie(MoviePhoto = images, Name = name, Description = description, TicketPrice = price)

        findViewById<Button>(R.id.btnbooknowmovie).setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                val response = authService.movie(Movie())
                if (response.code == HttpURLConnection.HTTP_OK)
                {
                    click()
                }
                else if (response.code == HttpURLConnection.HTTP_NOT_FOUND)
                {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@movie, "Wrong email or password", Toast.LENGTH_LONG)
                            .show()
                    }                }
            }

            }

        }



private fun click()
{
        findViewById<Button>(R.id.btnbooknowmovie).let {
            it.setOnClickListener {
                val intent = Intent(this, ShowTime::class.java)
                startActivity(intent)
            }
        }
    }
}

//class Movieadapter(
//    private val activity: Activity,
//    private val movie: Array<Movie>
//) : ArrayAdapter<Movie>(activity,R.layout.activity_movie,movie)
//{
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
//    {
//        var view = convertView
//        if (view == null)
//        {
//            view = LayoutInflater.from(activity).inflate(R.layout.activity_movie, null)
//
//            val viewHolder = ViewHolder()
//            viewHolder.image = view!!.findViewById(R.id.image)
//            viewHolder.txttitle = view.findViewById(R.id.txttitle)
//            viewHolder.txtdescription = view.findViewById(R.id.txtdescription)
//            viewHolder.txtprice = view.findViewById(R.id.txtprice)
//
//            view.tag = viewHolder
//        }
//
//        val existingViewHolder = view.tag as ViewHolder
//
//        existingViewHolder.image
//        existingViewHolder.txttitle.text = movie[position].Name.toString()
//        existingViewHolder.txtdescription.text = movie[position].Description.toString()
//        existingViewHolder.txtprice.text = movie[position].TicketPrice.toString()
//
//        return view
//    }
//
//    class ViewHolder
//    {
//        lateinit var image: ImageView
//        lateinit var txttitle: TextView
//        lateinit var txtdescription: TextView
//        lateinit var txtprice: TextView
//    }
//}