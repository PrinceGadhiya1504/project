package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class movie : AppCompatActivity()
{
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        findViewById<Button>(R.id.btnbooknowmovie1).let {
            it.setOnClickListener {
                val intent = Intent(this, ShowTime::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btnbooknowmovie2).let {
            it.setOnClickListener {
                val intent = Intent(this, ShowTime::class.java)
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.btnbooknowmovie3).let {
            it.setOnClickListener {
                val intent = Intent(this,ShowTime::class.java)
                startActivity(intent)
            }
        }
    }
}