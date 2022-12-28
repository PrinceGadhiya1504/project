package com.example.project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.example.project.Adapter.MovieAdapter
import com.example.project.models.Movie
import kotlinx.coroutines.*

class movie : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
